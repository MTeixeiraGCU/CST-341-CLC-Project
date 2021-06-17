package com.gcu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.LibraryBusinessServiceInterface;
import com.gcu.model.EBook;

/**
 * This class is setup as a Spring controller to be used for mapping user library transactions.
 *
 */
@Controller
@RequestMapping("/library")
public class LibraryController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private LibraryBusinessServiceInterface libraryBusinessService;
	
	/**
	 * This method accepts request for users to add books to their personal library.
	 * @param isbn The ISBN of the EBook to add given as a Request Parameter.
	 * @return true if the book was added,  false otherwise.
	 */
	@RequestMapping(path="/add", method=RequestMethod.GET)
	@ResponseBody
	public Boolean addBook(@RequestParam("isbn") String isbn) {
		if(libraryBusinessService.addBook(session.getAttribute("userName").toString(), isbn)) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method accepts requests for the user to remove a book from their personal library.
	 * @param isbn The ISBN of the EBook to remove given as a Request Parameter.
	 * @return true if the EBook was removed, false otherwise.
	 */
	@RequestMapping(path="/remove", method=RequestMethod.GET)
	@ResponseBody
	public Boolean removeBook(@RequestParam("isbn") String isbn) {
		if(libraryBusinessService.removeBook(session.getAttribute("userName").toString(), isbn)) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method accepts request for viewing a users library.
	 * @param model This is the model used to give feedback in the response.
	 * @return A new Library view containing all the EBooks in the users library.
	 */
	@RequestMapping(path="/library", method=RequestMethod.GET)
	public ModelAndView NavToLibrary(ModelMap model) {
		if(session.getAttribute("userName") != null)
		{
			List<EBook> books = libraryBusinessService.getLibrary(session.getAttribute("userName").toString());
			return new ModelAndView("Library", "books", books);
		}
		else
		{
			model.addAttribute("msg", "You must login before you can access you library!");
			return new ModelAndView("index");
		}
	}
}
