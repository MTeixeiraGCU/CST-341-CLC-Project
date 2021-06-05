package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * This class is designed to allow Spring JDBC to automatically map `users` table database columns onto a User object.
 *
 */
public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet result, int row) throws SQLException {
		User user = new User();
		user.setFirstName(result.getString("FIRST_NAME"));
		user.setLastName(result.getString("LAST_NAME"));
		user.setEmail(result.getString("EMAIL"));
		user.setPhoneNumber(result.getString("PHONE_NUMBER"));
		user.setUserName(result.getString("USER_NAME"));
		user.setPassword(result.getString("PASSWORD"));
		user.setRole(result.getInt("ROLE"));
		return user;
	}

}
