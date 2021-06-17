package com.gcu.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.UserBusinessServiceInterface;
import com.gcu.model.User;

/**
 * This class is setup as a Spring controller to be used for mapping user registration.
 *
 */
@Controller
public class RegistrationController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserBusinessServiceInterface userBusinessService;
	
	/**
	 * This method handles requests for navigation to the Registration page.
	 * @return A new Registration view where the user can fill in the information.
	 */
	@RequestMapping (path="/register", method=RequestMethod.GET)	
	public ModelAndView Navtoregister() {
		return new ModelAndView("Registration", "user", new User());
	}
	
	/**
	 * This method handles POST requests for registering a new user
	 * @param user The User object passed by the form.
	 * @param result This holds any form errors that are used to validate the passed User object
	 * @return A new RegistrationSuccess view if the user was added, or bakc to the form with errors otherwise.
	 */
	@RequestMapping(path="/registerUser", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("Registration", "user", user);
		} 
		else {
			if(userBusinessService.CheckDuplicateUserName(user.getUserName())) {
				session.setAttribute("msg", "That Username is already in use!");
				return new ModelAndView("Registration", "user", user);
			}
			else if(userBusinessService.RegisterUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber(), user.getUserName(), user.getPassword())) {
				return new ModelAndView("RegistrationSuccess", "user", user);
			} 
			else {
				return new ModelAndView("Registration", "user", user);
			}
		}
	}
}