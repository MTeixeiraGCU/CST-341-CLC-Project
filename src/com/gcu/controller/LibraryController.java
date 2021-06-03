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
	
	@RequestMapping(path="/add", method=RequestMethod.GET)
	@ResponseBody
	public Boolean addBook(@RequestParam("isbn") String isbn) {
		if(libraryBusinessService.addBook(session.getAttribute("userName").toString(), isbn)) {
			return true;
		}
		return false;
	}
	
	@RequestMapping(path="/remove", method=RequestMethod.GET)
	@ResponseBody
	public Boolean removeBook(@RequestParam("isbn") String isbn) {
		if(libraryBusinessService.removeBook(session.getAttribute("userName").toString(), isbn)) {
			return true;
		}
		return false;
	}
	
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
