package com.gcu.controller;

import com.gcu.model.UserLogin;
import com.gcu.business.UserBusinessService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
	
@Controller
public class LoginController {
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping (path= "/login",method=RequestMethod.GET)	
	public ModelAndView NavToLogin() {
		return new ModelAndView("Login", "user", new UserLogin());
	}
	
	@RequestMapping(path="/loginUser", method = RequestMethod.POST)
	public ModelAndView LoginUser(@ModelAttribute("user") @Valid UserLogin user, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			return new ModelAndView("Login", "user", user);
		} 
		else {
			//TODO: this line can be replaced by DI in the next milestone
			UserBusinessService userService= new UserBusinessService();
			
			if(userService.LoginUser(user.getUserName(), user.getPassword())) {
				session.setAttribute("userName", user.getUserName());
				return new ModelAndView("LoginSuccess", "user", user);
			}
			else {
				model.addAttribute("msg", "Could not login with those credintials");
				return new ModelAndView("Login", "user", user);
			}
		}
	}
	
	@RequestMapping (path= "/logout",method=RequestMethod.GET)	
	public String LogoutUser() {
		session.removeAttribute("userName");
		return "index";
	}
}
