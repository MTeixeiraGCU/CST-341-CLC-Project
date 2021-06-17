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
	
	/**
	 * This method handles requests for users or admins to alter a user's profile information.
	 * @param userName The user's name to alter in the database.
	 * @param model This is the model used to give feedback in the response.
	 * @return A new UserView view containing a form with the user's current information.
	 */
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
	
	/**
	 * This method handles POST requests from the UserView page form to update a user's information.
	 * @param user The User object containing the user's updated information.
	 * @param result This holds any form errors while trying to validate the passed User object. userName and password fileds will be ignored.
	 * @param model This is the model used to give feedback in the response.
	 * @return A new ProfileSuccess view for a completed update, or back to the UserView page with errors.
	 */
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
	
	/**
	 * This method handles requests to navigate to the userView. 
	 * @param model This is the model used to give feedback in the response.
	 * @return A new UserList view if the user has access, the home page otherwise.
	 */
	@RequestMapping(path="/userList", method=RequestMethod.GET)
	public ModelAndView userList(ModelMap model)
	{
		if(session.getAttribute("admin").equals(true)) {
			List<User> users = userBusinessService.getUsers();
			return new ModelAndView("UserList", "users", users);
		}
		else {
			model.addAttribute("msg", "That action requires administrator privileges!");
			return new ModelAndView("index", "users", null);
		}
	}
	
	/**
	 * This method handles requests to remove a user from the database.
	 * @param userName The userName of the user to remove.
	 * @param model This is the model used to give feedback in the response.
	 * @return A new index view with the appropriate success or failure messages.
	 */
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
		//TODO: Add code here to catch deletion of logged in user.
		return new ModelAndView("index", "user", user);
	}
	
	/**
	 * This method handles requests to navigate to a user's password change page.
	 * @param model This is the model used to give feedback in the response.
	 * @return A String that represents navigation to the PasswordChange page.
	 */
	@RequestMapping(path="/changePassword", method=RequestMethod.GET)
	public String navToChangePassword(ModelMap model) {
		if(session.getAttribute("userName") == null) {
			model.addAttribute("msg", "You must login and have access before you can change your password!");
			return "index";
		}
		
		//good to change password
		return "PasswordChange";
	}
	
	/**
	 * This method handles POST requests for a user to change their password.
	 * @param model This is the model used to give feedback in the response.
	 * @return A String that represents navigation to the PasswordChanged page.
	 */
	@RequestMapping(path="/changePassword", method=RequestMethod.POST)
	public String changePassword(ModelMap model) {
		//TODO: Add change password business code here.
		return "PasswordChange";
	}
}
