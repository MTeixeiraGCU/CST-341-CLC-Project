package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserLogin {

	//private fields
	
	@NotNull(message="You must enter a value for your User Name!")
	@Size(min=4, max=25, message="Invalid User Name!")
	private String userName;
	
	@NotNull(message="You must enter a value for your password!")
	@Size(min=5, max=30, message="Invalid Password!")
	private String password;
	
	//default constructor
	public UserLogin()
	{
		this.userName = "";
		this.password = "";
	}
	
	//assignment constructor
	public UserLogin(
			@NotNull(message = "You must enter a value for your User Name!") @Size(min = 4, max = 25, message = "Invalid User Name!") String userName,
			@NotNull(message = "You must enter a value for your password!") @Size(min = 5, max = 30, message = "Invalid Password!") String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	//getters and setters
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
