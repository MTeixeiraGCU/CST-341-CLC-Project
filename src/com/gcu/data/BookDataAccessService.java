package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcu.model.EBook;
import com.gcu.model.EBookRowMapper;

/**
 * This class represents access to the database for the data manipulation of EBooks
 *
 */
public class BookDataAccessService implements IDataAccessService<EBook> {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public EBook get(String isbn) {
		//Connection conn = ConnectionManager.getConnection();
		EBook eBook = null;
		
		/* Old JDBC Code
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
			throw new RuntimeException("Could not connect to Database while retrieving EBook data!", ex);
		}*/
		
		String query = "SELECT * FROM books WHERE ISBN = ?";
		eBook = jdbcTemplate.queryForObject(query, new Object[] {isbn}, new EBookRowMapper());
		
		return eBook;
	}

	@Override
	public List<EBook> getAll() {
		
		/* Old JDBC Code
		Connection conn = ConnectionManager.getConnection();
		List<EBook> eBooks = new ArrayList<EBook>();
		try {
			
			//set up prepared SQL statement
			String query = "SELECT * FROM books";
			PreparedStatement stmt = conn.prepareStatement(query);
			
			//execute statement and set the results
			ResultSet result = stmt.executeQuery();
			while(result.next())
			{
				EBook eBook = new EBook();
				eBook.setTitle(result.getString("TITLE"));
				eBook.setAuthor(result.getString("AUTHOR"));
				eBook.setPublisher(result.getString("PUBLISHER"));
				eBook.setPublicationDate(result.getDate("PUBLICATION_DATE"));
				eBook.setIsbn(result.getString("ISBN"));
				eBook.setImage(result.getString("IMAGE"));
				eBooks.add(eBook);
			}
			
			//close up connections
			result.close();
			stmt.close();
			conn.close();
		}
		catch(SQLException ex)
		{
			throw new RuntimeException("Could not connect to Database while retrieveing all EBooks data!", ex);
		}*/
		
		List<EBook> eBooks = new ArrayList<EBook>();
		String query = "SELECT * FROM books";
		eBooks = jdbcTemplate.query(query, new EBookRowMapper());
		
		return eBooks;
	}

	@Override
	public void add(EBook t) {
		
		/* Old JDBC Code
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
		}*/
		
		String query = "INSERT INTO books (TITLE, AUTHOR, PUBLISHER, PUBLICATION_DATE, IMAGE, ISBN) VALUES (?, ?, ?, ?, ?, ?)";
		int result = jdbcTemplate.update(query, t.getTitle(), t.getAuthor(), t.getPublisher(), t.getPublicationDate(), t.getImage(), t.getIsbn());
		if(result == 1) {
			System.out.println("Row was added successfully!");
		}
		
	}

	@Override
	public void update(EBook t) {
		
		/* Old JDBC Code
		Connection conn = ConnectionManager.getConnection();
		
		try {
			
			//set up prepared SQL statement
			String query = "UPDATE books SET TITLE = ?, AUTHOR = ?, PUBLISHER = ?, PUBLICATION_DATE = ?, IMAGE = ? WHERE ISBN = ?";
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
			throw new RuntimeException("Could not connect to Database while updating eBook!", ex);
		}	*/
		
		String query = "UPDATE books SET TITLE = ?, AUTHOR = ?, PUBLISHER = ?, PUBLICATION_DATE = ?, IMAGE = ? WHERE ISBN = ?";
		int result = jdbcTemplate.update(query, t.getTitle(), t.getAuthor(), t.getPublisher(), t.getPublicationDate(), t.getImage(), t.getIsbn());
		if(result == 1) {
			System.out.println("Row was updated successfully!");
		}
	}

	@Override
	public void delete(EBook t) {
		String query = "DELETE FROM books WHERE ISBN = ?";
		int result = jdbcTemplate.update(query, t.getIsbn());
		if(result == 1) {
			System.out.println("Row was removed from the database!");
		}
	}

}
