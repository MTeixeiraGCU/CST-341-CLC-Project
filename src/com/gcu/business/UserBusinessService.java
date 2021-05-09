package com.gcu.business;

import com.gcu.data.UserDataAccessService;
import com.gcu.model.User;

/**
 * This class offers all application specific logic for handleing user information, registration, and login
 * @author Marc
 *
 */
public class UserBusinessService {
	
	/**
	 * This method takes a users login and compares it with the information in the database
	 * @param userName the current users login name
	 * @param password the current users password
	 * @return will return true if the login infor matches, false otherwise
	 */
	public boolean LoginUser(String userName, String password)
	{
		//get the user we are interested in
		UserDataAccessService dataService = new UserDataAccessService();
		User user = dataService.get(userName);
		
		//check for a valid user and a matching password
		if(user == null)
		{
			return false;
		}
		else if(user.ValidatePassword(password))
		{
			return false;
		}
		
		//login is good
		return true;
	}
	
	/**
	 * This method attempts to add the user to the database. Does not check for duplicate userName.
	 * @param firstName 
	 * @param lastName
	 * @param email
	 * @param phoneNumber
	 * @param userName
	 * @param password
	 */
	public boolean RegisterUser(String firstName, String lastName, String email, String phoneNumber, String userName, String password)
	{
		//get a data service
		UserDataAccessService dataService = new UserDataAccessService();
		
		//create a new user
		User newUser = new User(firstName, lastName, email, phoneNumber, userName, password);
		
		try
		{
			//add them to the database
			dataService.add(newUser);
			return true;
		}
		catch(Exception ex)
		{
			throw new RuntimeException("Could not add user to the database", ex);
		}
	}
	
	/**
	 * This method checks the database for a duplicate userName
	 * @param userName the user name to check for
	 * @return will return true if there is a duplicate user, false if their is no user by that userName
	 */
	public boolean CheckDuplicateUserName(String userName)
	{
		//get a data service
		UserDataAccessService dataService = new UserDataAccessService();
		
		//grab the user if it exists
		User user = dataService.get(userName);
		
		//check for duplicate user
		if(user != null)
		{
			return true;
		}
		
		//user does not exist
		return false;
	}
}
