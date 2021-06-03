package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This class is setup as a Spring controller to be used for mapping main menu requests, (index, About, Contact) specifically.
 *
 */
@Controller
public class MainController {
	
	@RequestMapping(path= {"/", "", "index", "home", "defualt"}, method=RequestMethod.GET)
	public String homePage()
	{
		return "index";
	}
	
	@RequestMapping(path="/about", method=RequestMethod.GET)
	public String aboutPage() {
		return "About";
	}
	
	@RequestMapping(path="/contact", method=RequestMethod.GET)
	public String contactPage() {
		return "Contact";
	}
}
