package com.gcu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.LibraryBusinessServiceInterface;
import com.gcu.model.EBook;

@RestController
public class LibraryController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private LibraryBusinessServiceInterface libraryBusinessService;
	
	@GetMapping(path="/library")
	public List<EBook> NavToLibrary(ModelMap model) {
		if(session.getAttribute("userName") != null)
		{
			List<EBook> books = libraryBusinessService.getLibrary(session.getAttribute("userName").toString());
			System.out.println(books.size());
			return books;
			//return new ModelAndView("Library", "books", books);
		}
		else
		{
			model.addAttribute("msg", "You must login before you can access you library!");
			return null;
			//return new ModelAndView("index");
		}
	}
}
