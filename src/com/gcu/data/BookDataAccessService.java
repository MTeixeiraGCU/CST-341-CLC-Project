package com.gcu.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.gcu.model.EBook;

/**
 * This class represents access to the database for the data manipulation of EBooks
 *
 */
public class BookDataAccessService implements IDataAccessService<EBook> {

	@Override
	public EBook get(String isbn) {
		Connection conn = ConnectionManager.getConnection();
		EBook eBook = null;
		try {
			
			//set up prepared SQL statement
			String query = "SELECT * FROM books WHERE ISBN = ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, isbn);
			
			//execute statement and set the results
			ResultSet result = stmt.executeQuery();
			if(result.next())
			{
				eBook = new EBook();
				eBook.setTitle(result.getString("TITLE"));
				eBook.setAuthor(result.getString("AUTHOR"));
				eBook.setPublisher(result.getString("PUBLISHER"));
				eBook.setPublicationDate(result.getDate("PUBLICATION_DATE"));
				eBook.setIsbn(result.getString("ISBN"));
				eBook.setImage(result.getString("IMAGE"));
			}
			
			//close up connections
			result.close();
			stmt.close();
			conn.close();
		}
		catch(SQLException ex)
		{
			throw new RuntimeException("Could not connect to Database while retrieveing EBook data!", ex);
		}
		return eBook;
	}

	@Override
	public List<EBook> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(EBook t) {
		Connection conn = ConnectionManager.getConnection();
		try {
			
			//set up prepared SQL statement
			String query = "INSERT INTO books (TITLE, AUTHOR, PUBLISHER, PUBLICATION_DATE, IMAGE, ISBN) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, t.getTitle());
			stmt.setString(2, t.getAuthor());
			stmt.setString(3, t.getPublisher());
			stmt.setDate(4, t.getPublicationDate());
			stmt.setString(5, t.getImage());
			stmt.setString(6, t.getIsbn());
			
			//execute statement and set the results
			int result = stmt.executeUpdate();
			if(result == 0)
			{
				//TODO: Add error logic to handle books not being added instead of console print
				System.out.println("Could not add EBook to the database!");
			}
			
			//close up connections
			stmt.close();
			conn.close();
		}
		catch(SQLException ex)
		{
			throw new RuntimeException("Could not connect to database while adding ebook data!", ex);
		}
		
	}

	@Override
	public void update(EBook t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(EBook t) {
		// TODO Auto-generated method stub
		
	}

}
