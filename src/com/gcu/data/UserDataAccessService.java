package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcu.model.User;
import com.gcu.model.UserRowMapper;

/**
 * This class implements the DataAccessService object and is specifically used for CRUD operations on a User object
 * 
 * @author Marc
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
		//Connection conn = ConnectionManager.getConnection();
		User user = null;
		
		/* Old JDBC Code
		try {
			
			//set up prepared SQL statement
			String query = "SELECT * FROM users WHERE USER_NAME = ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, userName);
			
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
			throw new RuntimeException("Could not connect to Database while retrieveing user data!", ex);
		}*/
		
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
		/* Old JDBC Code
		Connection conn = ConnectionManager.getConnection();
		try {
			
			//set up prepared SQL statement
			String query = "INSERT INTO users (FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, USER_NAME, PASSWORD) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, t.getFirstName());
			stmt.setString(2, t.getLastName());
			stmt.setString(3, t.getEmail());
			stmt.setString(4, t.getPhoneNumber());
			stmt.setString(5, t.getUserName());
			stmt.setString(6, t.getPassword());
			
			//execute statement and set the results
			int result = stmt.executeUpdate();
			if(result == 0)
			{
				//TODO: Add error logic to handle user not being added instead of console print
				System.out.println("Could not add user to the database!");
			}
			
			//close up connections
			stmt.close();
			conn.close();
		}
		catch(SQLException ex)
		{
			throw new RuntimeException("Could not connect to database while adding user data!", ex);
		}*/
		
		String query = "INSERT INTO users (FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, USER_NAME, PASSWORD, ROLE) VALUES (?, ?, ?, ?, ?, ?, ?)";
		int result = jdbcTemplate.update(query, t.getFirstName(), t.getLastName(), t.getEmail(), t.getPhoneNumber(), t.getUserName(), t.getPassword(), t.getRole());
		if(result == 1) {
			System.out.println("Row was added successfully!");
		}
	}

	@Override
	public void update(User t) {
		String query = "UPDATE users SET FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ?, PHONE_NUMBER = ?, PASSWORD = ?, ROLE = ? WHERE USER_NAME = ?";
		int result = jdbcTemplate.update(query, t.getFirstName(), t.getLastName(), t.getEmail(), t.getPhoneNumber(), t.getPassword(), t.getRole(), t.getUserName());
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
