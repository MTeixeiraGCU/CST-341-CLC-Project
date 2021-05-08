package com.gcu.data;

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
	private static final String url = "jdbc:mysql://localhost:3306/cst-341-clcproject";
	private static final String userName = System.getenv("MYSQL_USERNAME");
	private static final String password = System.getenv("MYSQL_PASSWORD");
	
	private static boolean loaded = false;
	
	/**
	 * This method uses the local connection strings to create a connection to the persistence database
	 * @return the created connection
	 */
	public static Connection getConnection()
	{
		if(!loaded)
		{
			LoadDriver();
		}
		try
		{
			return DriverManager.getConnection(url, userName, password);
		}
		catch(SQLException ex)
		{
			throw new RuntimeException("Could not gain a connection to the database", ex);
		}
	}
	
	private static void LoadDriver()
	{
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    loaded= true;
		} catch (ClassNotFoundException e) {
		    throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		}
	}
}
