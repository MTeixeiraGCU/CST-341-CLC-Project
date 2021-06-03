package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcu.model.EBook;
import com.gcu.model.EBookRowMapper;

/**
 * This class represents access to the database for the data manipulation of EBooks. It uses Spring JDBC for connection setup 
 * and table mapping. The methods are in typical CRUD operation setup.
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
		
		EBook eBook = null;

		String query = "SELECT * FROM books WHERE ISBN = ?";
		eBook = jdbcTemplate.queryForObject(query, new Object[] {isbn}, new EBookRowMapper());
		
		return eBook;
	}

	@Override
	public List<EBook> getAll() {
		
		List<EBook> eBooks = new ArrayList<EBook>();
		String query = "SELECT * FROM books";
		eBooks = jdbcTemplate.query(query, new EBookRowMapper());
		
		return eBooks;
	}

	@Override
	public void add(EBook t) {
		
		String query = "INSERT INTO books (TITLE, AUTHOR, PUBLISHER, PUBLICATION_DATE, IMAGE, ISBN) VALUES (?, ?, ?, ?, ?, ?)";
		int result = jdbcTemplate.update(query, t.getTitle(), t.getAuthor(), t.getPublisher(), t.getPublicationDate(), t.getImage(), t.getIsbn());
		if(result == 1) {
			System.out.println("Row was added successfully!");
		}
		
	}

	@Override
	public void update(EBook t) {
		
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
