package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.IDataAccessService;
import com.gcu.model.User;

/**
 * This class offers all application specific logic for handling user information, registration, and login
 *
 */
public class UserBusinessService implements UserBusinessServiceInterface{
	
	@Autowired
	private IDataAccessService<User> userDataAccessService;
	
	/**
	 * This method takes a users login and compares it with the information in the database
	 * @param userName the current users login name
	 * @param password the current users password
	 * @return will return true if the login information matches, false otherwise
	 */
	@Override
	public boolean LoginUser(String userName, String password)
	{
		//get the user we are interested in
		User user = userDataAccessService.get(userName);
		
		//check for a valid user and a matching password
		if(user == null)
		{
			return false;
		}
		else if(!user.ValidatePassword(password))
		{
			return false;
		}
		
		//login is good
		return true;
	}
	
	/**
	 * This method attempts to add the user to the database. Does not check for duplicate userName.
	 * @param firstName The user's first name.
	 * @param lastName The user's last name.
	 * @param email The user's email address
	 * @param phoneNumber The user's phone number.
	 * @param userName The user's selected user name.
	 * @param password The password for the user's new login.
	 * @return true if the user was registered into the database.
	 */
	@Override
	public boolean RegisterUser(String firstName, String lastName, String email, String phoneNumber, String userName, String password)
	{
		//create a new user
		User newUser = new User(firstName, lastName, email, phoneNumber, userName, password, 0);
		
		try
		{
			//add them to the database
			userDataAccessService.add(newUser);
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
	@Override
	public boolean CheckDuplicateUserName(String userName)
	{
		//grab the user if it exists
		User user = userDataAccessService.get(userName);
		
		//check for duplicate user
		if(user != null)
		{
			return true;
		}
		
		//user does not exist
		return false;
	}

	/**
	 * This method returns a user object by the given userName.
	 * @param userName the user to look up.
	 * @return a User object that represents the given user.
	 */
	@Override
	public User getUser(String userName) {
		return userDataAccessService.get(userName);
	}

	/**
	 * This method returns the entire list of users in the database.
	 * @return A complete List&lt;User&gt; of all the registered users in the database.
	 */
	@Override
	public List<User> getUsers() {
		return userDataAccessService.getAll();
	}

	/**
	 * This method updates a users information onto the database.
	 * @param user an object representing the users new information.
	 * @return true if the user has been updated.
	 */
	@Override
	public boolean UpdateUser(User user) {
		userDataAccessService.update(user);
		
		//TODO: Add logic to detect failed attempt.
		return true;
	}
	
	/**
	 * This method removes the given user from the database.
	 * @param user the user object to remove from the database.
	 * @return true if the user was removed from the database.
	 */
	@Override
	public boolean deleteUser(User user) {
		userDataAccessService.delete(user);
		
		//TODO: Add checks here to handle failed delete.
		return true;
	}

	/**
	 * This method checks the given user's role for admin status.
	 * @param userName the user to check for admin status.
	 * @return true if the user is an admin.
	 */
	@Override
	public boolean CheckAdminStatus(String userName) {
		if(this.getUser(userName).getRole() == 1) {
			return true;
		}
		return false;
	}
}
