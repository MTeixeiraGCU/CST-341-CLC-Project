package com.gcu.dataService;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class represents a way to access connections to the persistence database through the JDBC API
 * 
 * @author Marc
 *
 */
public class ConnectionManager {
	private static String url = "";
	private static String userName = "";
	private static String password = "";
	
	/**
	 * This method uses the local connection strings to create a connection to the persistence database
	 * @return the created connection
	 */
	public static Connection getConnection()
	{
		try
		{
			DriverManager.registerDriver(new Driver());
			return DriverManager.getConnection(url, userName, password);
		}
		catch(SQLException ex)
		{
			throw new RuntimeException("Could not gain a connection to the database", ex);
		}
	}
}
