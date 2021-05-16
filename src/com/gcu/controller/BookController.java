package com.gcu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.BookBusinessServiceInterface;
import com.gcu.model.EBook;

@Controller
@RequestMapping("/bookView")
public class BookController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private BookBusinessServiceInterface bookBusinessService;
	
	@RequestMapping("/add")
	public ModelAndView addBook()
	{
		return null;
	}
	
	@RequestMapping(path="/bookList", method=RequestMethod.GET)
	public ModelAndView NavToBokkList(ModelMap model)
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
}
