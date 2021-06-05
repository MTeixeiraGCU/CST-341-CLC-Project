package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcu.model.EBook;
import com.gcu.model.EBookRowMapper;

/**
 * This class handles database transactions for accessing a users library. It uses Spring JDBC for connection setup and object mapping.
 *
 */
public class LibraryDataAccessService implements LibraryDataAccessServiceInterface{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/**
	 * This method gets a list of books that are in the given users library.
	 * @param userName the user to look up the library for.
	 * @return a List<EBook> that contains all of the books in the users library.
	 */
	@Override
	public List<EBook> getBooks(String userName) {
		
		List<EBook> books = new ArrayList<EBook>();
		String query = "SELECT b.* "
					 + "FROM books b "
					 + "JOIN library l ON b.ISBN = l.BOOK_ID "
					 + "JOIN users u ON l.USER_ID = u.USER_NAME "
					 + "WHERE u.USER_NAME = ?";
		books = jdbcTemplate.query(query, new Object[] {userName}, new EBookRowMapper());
		return books;
	}
	
	/**
	 * This method removes a single book from the given users library.
	 * @param userName the user to remove the book from.
	 * @param isbn the isbn of the book to remove.
	 * @return true if the book was removed.
	 */
	@Override
	public boolean removeBook(String userName, String isbn) {
		
		String query = "DELETE FROM library WHERE USED_ID = ? AND BOOK_ID = ?";
		int result = jdbcTemplate.update(query, userName, isbn);
		if(result == 1) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method adds a single book to the given users library. Duplicate book entries are allowed.
	 * @param userName the user to add a book for.
	 * @param isbn the isbn of the book to add.
	 * @return  true if the book was added.
	 */
	@Override
	public boolean addBook(String userName, String isbn) {
		
		String query = "INSERT INTO library (USER_ID, BOOK_ID) VALUES (?, ?)";
		int result = jdbcTemplate.update(query, userName, isbn);
		if(result == 1) {
			return true;
		}
		return false;
	}

}
