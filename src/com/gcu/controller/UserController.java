package com.gcu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.UserBusinessServiceInterface;
import com.gcu.model.User;

/**
 * This class is setup as a Spring controller to be used for mapping user profile transactions including changes by admins.
 *
 */
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
			//search through all the errors
			for(ObjectError error : result.getAllErrors()) {
				//if it is not a password or userName error, continue on to notify user
				if(!((FieldError)error).getField().equals("password") && !((FieldError)error).getField().equals("userName")) {
					return new ModelAndView("UserView", "user", user);
				}
			}
		} 

		//no errors were encountered so continue on to update user
		userBusinessService.UpdateUser(user);
		model.addAttribute("msg", "User has been updated into the database!");
		return new ModelAndView("ProfileSuccess", "user", user);
	}
	
	@RequestMapping(path="/userList", method=RequestMethod.GET)
	public ModelAndView userList(ModelMap model)
	{
		List<User> users = userBusinessService.getUsers();
		return new ModelAndView("UserList", "users", users);
	}
	
	@RequestMapping(path="/removeUser", method=RequestMethod.GET)
	public ModelAndView removeUser(@RequestParam("userName") String userName, ModelMap model) {
		
		//get the user if they exists
		User user = userBusinessService.getUser(userName);
		
		//check for admin status
		if(session.getAttribute("admin").equals(false)) {
			model.addAttribute("msg", "You must have access to remove users!");
			return new ModelAndView("index", "user", user);
		}
		
		//check for existing user
		if(user == null) {
			model.addAttribute("msg", "You must enter a vaild user name to be removed!");
			return new ModelAndView("index", "user", user);
		}
		
		//attempt to remove them from the database
		if(userBusinessService.deleteUser(user)) {
			model.addAttribute("msg", userName + " was removed from the database!");
		}
		else {
			model.addAttribute("msg", "Ther were errors, could not remove " + userName + " from the database!");
		}

		//return to home page
		//TODO: add code here to catch deletion of logged in user.
		return new ModelAndView("index", "user", user);
	}
}
