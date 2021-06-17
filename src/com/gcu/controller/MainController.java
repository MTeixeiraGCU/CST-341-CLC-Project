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
	
	/**
	 * This method handles navigation requests to the Home page "index".
	 * @return A String representing the index page navigation.
	 */
	@RequestMapping(path= {"/", "", "index", "home", "defualt"}, method=RequestMethod.GET)
	public String homePage()
	{
		return "index";
	}
	
	/**
	 * This method handles navigation requests to the About page.
	 * @return A String representing the About page navigation link.
	 */
	@RequestMapping(path="/about", method=RequestMethod.GET)
	public String aboutPage() {
		return "About";
	}
	
	/**
	 * This method handles navigation requests to the Contact page.
	 * @return A String representing the Contact page navigation link.
	 */
	@RequestMapping(path="/contact", method=RequestMethod.GET)
	public String contactPage() {
		return "Contact";
	}
}
