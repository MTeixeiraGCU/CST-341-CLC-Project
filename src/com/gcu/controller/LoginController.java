package com.gcu.controller;

import com.gcu.model.UserLogin;
import com.gcu.business.UserBusinessService;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
	
@Controller
public class LoginController {
	
@RequestMapping (path= "/login",method=RequestMethod.GET)	

	public ModelAndView Navtologin() {
		return new ModelAndView("Login", "user", new UserLogin());
	}
	
	@RequestMapping(path="/loginUser", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user") @Valid UserLogin user, BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("Login", "user", user);
		} 
		else {
			UserBusinessService userService= new UserBusinessService();
			if(userService.LoginUser(user.getUserName(), user.getPassword())) {
				return new ModelAndView("LoginSuccess", "user", user);
			}
			else {
				return new ModelAndView("Login", "user", user);
			}
		}
	}
}
