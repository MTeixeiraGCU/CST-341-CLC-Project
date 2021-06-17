package com.gcu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.BookBusinessServiceInterface;
import com.gcu.model.EBook;

/**
 * This class is setup as a Spring controller to be used for mapping book catalog transactions.
 *
 */
@Controller
public class BookController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private BookBusinessServiceInterface bookBusinessService;
	
	/**
	 * This method is an initial entry point for editing book information. 
	 * @param isbn The book ISBN retrieved from the request parameter.
	 * @param model This is the model used to give feedback in the response.
	 * @return A new AddBook view with fields filled in already based on whether the user has access to edit the book.
	 */
	@RequestMapping(path="/editBook", method=RequestMethod.GET)
	public ModelAndView editBook(@RequestParam("isbn") String isbn, ModelMap model)
	{
		if(session.getAttribute("userName") != null)
		{
			EBook eBook = bookBusinessService.getBook(isbn);
			return new ModelAndView("AddBook", "eBook", eBook);
		}
		else
		{
			model.addAttribute("msg", "You must login before you can view the eBooks list!");
			return new ModelAndView("index");
		}
	}
	
	/**
	 * This method is the initial entry point for adding a new book to the system.
	 * @param model This is the model used to give feedback in the response.
	 * @return A new AddBook view with the fields emptied for new information to be added.
	 */
	@RequestMapping(path="/add", method=RequestMethod.GET)
	public ModelAndView addBook(ModelMap model)
	{
		if(session.getAttribute("userName") != null)
		{
			return new ModelAndView("AddBook", "eBook", new EBook());
		}
		else
		{
			model.addAttribute("msg", "You must login before you can view the eBooks list!");
			return new ModelAndView("index");
		}
	}
	
	/**
	 * This method is for handling submit request to add or edit books into the database.
	 * @param eBook The request model object as an EBook to be updated or added.
	 * @param result Contains any form errors based on the required EBook model validations
	 * @param model This is the model used to give feedback in the response.
	 * @return Returns a view back to AddBook if there were errors, otherwise gives an AdBookSuccess view.
	 */
	@RequestMapping(path="/addBook", method=RequestMethod.POST)
	public ModelAndView addBook(@ModelAttribute("eBook") @Valid EBook eBook, BindingResult result, ModelMap model)
	{
		if(result.hasErrors()) {
			return new ModelAndView("AddBook", "eBook", eBook);
		} 
		else {
			bookBusinessService.addBook(eBook);
			model.addAttribute("msg", "Book has been updated into the database!");
			return new ModelAndView("AddBookSuccess", "eBook", eBook);
			
		}
		
	}
	
	/**
	 * This method is for accessing and viewing the complete EBook list.
	 * @param model This is the model used to give feedback in the response.
	 * @return A new BookList view containg all the books inthe database.
	 */
	@RequestMapping(path="/bookList", method=RequestMethod.GET)
	public ModelAndView NavToBookList(ModelMap model)
	{
		if(session.getAttribute("userName") != null)
		{
			List<EBook> books = bookBusinessService.getAllBooks();
			return new ModelAndView("BookList", "books", books);
		}
		else
		{
			model.addAttribute("msg", "You must login before you can view the eBooks list!");
			return new ModelAndView("index");
		}
	}
	
	/**
	 * This method is to access request to remove books from the database.
	 * @param isbn The ISBN of the book to remove in the form of a request parameter.
	 * @param model This is the model used to give feedback in the response.
	 * @return A new index view with response messages for success or failure.
	 */
	@RequestMapping(path="/removeBook", method=RequestMethod.GET)
	public ModelAndView removeBook(@RequestParam("isbn") String isbn, ModelMap model) {
		
		//get the book if it exists
		EBook eBook = bookBusinessService.getBook(isbn);
		
		//check for admin status
		if(session.getAttribute("admin").equals(false)) {
			model.addAttribute("msg", "You must have access to remove books from the database!");
			return new ModelAndView("index", "eBook", eBook);
		}
		
		//check for existing book
		if(eBook == null) {
			model.addAttribute("msg", "You must enter a vaild isbn for the book to be removed!");
			return new ModelAndView("index", "eBook", eBook);
		}
		
		//attempt to remove the book from the database
		if(bookBusinessService.deleteBook(eBook)) {
			model.addAttribute("msg", isbn + " was removed from the database!");
		}
		else {
			model.addAttribute("msg", "Ther were errors, could not remove " + isbn + " from the database!");
		}

		//return to home page
		return new ModelAndView("index", "eBook", eBook);
	}
		
}
