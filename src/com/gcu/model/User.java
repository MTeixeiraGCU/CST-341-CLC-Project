package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Class User is designed to hold information regarding a single registered user account
 *
 */
public class User {

	//private fields
	
	@NotNull(message="You must enter a value for the first name!")
	@Size(min=2, max=25, message="First name must be be at least 2 letters but less than 26!")
	private String firstName;
	
	@NotNull(message="You must enter a value for the last name!")
	@Size(min=2, max=25, message="Last name must be be at least 2 letters but less than 26!")
	private String lastName;
	
	@NotNull(message="You must enter a value for your email!")
	@Size(min=5, max=50, message="Email name must be be at least 5 characters!")
	private String email;
	
	@Size(min=7, max=11, message="Invalid number of digits")
	private String phoneNumber;
	
	@NotNull(message="You must enter a value for your User Name!")
	@Size(min=4, max=25, message="User Name must be be at least 4 letters but less than 26!")
	private String userName;
	
	@NotNull(message="You must enter a value for your password!")
	@Size(min=5, max=30, message="Password must be at least 5 characters!")
	private String password;

	//default constructor
	public User()
	{
		super();
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.phoneNumber = "";
		this.userName = "";
		this.password = "";
	}
	
	//assignment constructor
	public User(String firstName, String lastName, String email, String phoneNumber, String userName, String password) {
		super();
		//This is inside the constructor
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
	}
	
	/**
	 * This method checks the given password to the stored one
	 * 
	 * @param password the password to compare to
	 * @return true if the passwords match, false otherwise
	 */
	public boolean ValidatePassword(String password)
	{
		if(this.password.equals(password))
		{
			return true;
		}
		return false;
	}
	
	//getters and setters
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
