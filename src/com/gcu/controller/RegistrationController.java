package com.gcu.controller;

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


@Controller
public class RegistrationController {
		
	@Autowired
	private UserBusinessServiceInterface userBusinessService;
	
	@RequestMapping (path="/register", method=RequestMethod.GET)	
	public ModelAndView Navtoregister() {
		return new ModelAndView("Registration", "user", new User());
	}
	
	@RequestMapping(path="/registerUser", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("Registration", "user", user);
		} 
		else {
			if(userBusinessService.RegisterUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber(), user.getUserName(), user.getPassword())) {
				return new ModelAndView("RegistrationSuccess", "user", user);
			} 
			else {
				return new ModelAndView("Registration", "user", user);
			}
		}
	}
}