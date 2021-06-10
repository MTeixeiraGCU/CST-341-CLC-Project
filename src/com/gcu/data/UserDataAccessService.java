package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcu.model.User;
import com.gcu.model.UserRowMapper;

/**
 * This class represents access to the database for the data manipulation of Users. It uses Spring JDBC for connection setup 
 * and table mapping. The methods are in typical CRUD operation setup.
 *
 */
public class UserDataAccessService implements IDataAccessService<User> {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public User get(String userName) {
		
		User user = null;
		String query = "SELECT * FROM users WHERE USER_NAME = ?";
		user = jdbcTemplate.queryForObject(query, new Object[] {userName}, new UserRowMapper());
		
		return user;
	}

	@Override
	public List<User> getAll() {
		
		List<User> users = new ArrayList<User>();
		String query = "SELECT * FROM users";
		users = jdbcTemplate.query(query, new UserRowMapper());
		
		return users;
	}

	@Override
	public void add(User t) {
		
		String query = "INSERT INTO users (FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, USER_NAME, PASSWORD, ROLE) VALUES (?, ?, ?, ?, ?, ?, ?)";
		int result = jdbcTemplate.update(query, t.getFirstName(), t.getLastName(), t.getEmail(), t.getPhoneNumber(), t.getUserName(), t.getPassword(), t.getRole());
		if(result == 1) {
			System.out.println("Row was added successfully!");
		}
	}

	/**
	 * This method updates user information except for password and userName
	 */
	@Override
	public void update(User t) {
		
		String query = "UPDATE users SET FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ?, PHONE_NUMBER = ?, ROLE = ? WHERE USER_NAME = ?";
		int result = jdbcTemplate.update(query, t.getFirstName(), t.getLastName(), t.getEmail(), t.getPhoneNumber(), t.getRole(), t.getUserName());
		if(result == 1) {
			System.out.println("Row was updated successfully!");
		}
	}

	@Override
	public void delete(User t) {
		
		String query = "DELETE FROM users WHERE USER_NAME = ?";
		int result = jdbcTemplate.update(query, t.getUserName());
		if(result == 1) {
			System.out.println("Row was removed from the database!");
		}
	}

}
