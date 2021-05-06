package com.gcu.dataService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.gcu.model.User;

/**
 * This class implements the DataAccessService object and is specifically used for CRUD operations on a User object
 * 
 * @author Marc
 *
 */
public class UserDataAccessService implements DataAccessService<User> {

	@Override
	public User get(String userName) {
		Connection conn = ConnectionManager.getConnection();
		User user = null;
		try {
			
			//set up prepared SQL statement
			String query = "SELECT * FROM users WHERE userName = ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(0, userName);
			
			//execute statement and set the results
			ResultSet result = stmt.executeQuery();
			if(result.next())
			{
				user = new User();
				user.setFirstName(result.getString("FIRST_NAME"));
				user.setLastName(result.getString("LAST_NAME"));
				user.setEmail(result.getString("EMAIL"));
				user.setPhoneNumber(result.getString("PHONE_NUMBER"));
				user.setUserName(result.getString("USER_NAME"));
				user.setPassword(result.getString("PASSWORD"));
			}
			
			//close up connections
			result.close();
			stmt.close();
			conn.close();
		}
		catch(SQLException ex)
		{
			throw new RuntimeException("Could not connect to Databse while retrieveing user data!", ex);
		}
		return user;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub
		
	}

}
