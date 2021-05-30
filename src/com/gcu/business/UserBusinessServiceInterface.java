package com.gcu.business;

import java.util.List;

import com.gcu.model.User;

public interface UserBusinessServiceInterface {
	
	public boolean LoginUser(String userName, String password);
	
	public boolean RegisterUser(String firstName, String lastName, String email, String phoneNumber, String userName, String password);
	
	public boolean CheckDuplicateUserName(String userName);
	
	public boolean CheckAdminStatus(String userName);
	
	public User getUser(String userName);
	
	public List<User> getUsers();
	
	public boolean UpdateUser(User user);
	
	public boolean deleteUser(User user);
	
}
