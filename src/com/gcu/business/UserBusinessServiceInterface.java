package com.gcu.business;

public interface UserBusinessServiceInterface {
	
	public boolean LoginUser(String userName, String password);
	
	public boolean RegisterUser(String firstName, String lastName, String email, String phoneNumber, String userName, String password);
	
	public boolean CheckDuplicateUserName(String userName);
	
}
