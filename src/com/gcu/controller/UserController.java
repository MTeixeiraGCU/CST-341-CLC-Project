package com.gcu.controller;

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

import com.gcu.business.UserBusinessServiceInterface;
import com.gcu.model.EBook;
import com.gcu.model.User;

@Controller
public class UserController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserBusinessServiceInterface userBusinessService;
	
	@RequestMapping(path="/editUser", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("userName") String userName, ModelMap model) {
		
		//allow access to update user profile if we are the logged in user or an admin.
		if(session.getAttribute("userName") != null && (session.getAttribute("userName").equals(userName) || session.getAttribute("admin").equals(true)))
		{
			User user = userBusinessService.getUser(userName);
			return new ModelAndView("UserView", "user", user);
		}
		else
		{
			model.addAttribute("msg", "You must login and have access before you can view that profile!");
			return new ModelAndView("index");
		}
	}
	
	@RequestMapping(path="/editUser", method=RequestMethod.POST)
	public ModelAndView edit(@ModelAttribute("user") @Valid User user, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			return new ModelAndView("UserView", "user", user);
		} 
		else {
			userBusinessService.UpdateUser(user);
			model.addAttribute("msg", "User has been updated into the database!");
			return new ModelAndView("index", "user", user);
		}
	}
}
