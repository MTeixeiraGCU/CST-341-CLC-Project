package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcu.model.EBook;
import com.gcu.model.EBookRowMapper;

public class LibraryDataAccessService implements LibraryDataAccessServiceInterface{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
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
	
	@Override
	public boolean removeBook(String userName, String isbn) {
		String query = "DELETE FROM library WHERE USED_ID = ? AND BOOK_ID = ?";
		int result = jdbcTemplate.update(query, userName, isbn);
		if(result == 1) {
			return true;
		}
		return false;
	}
	
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
