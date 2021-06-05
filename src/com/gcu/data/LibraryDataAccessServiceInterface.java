package com.gcu.data;

import java.util.List;

import com.gcu.model.EBook;

/**
 * This interface represents access to a database for retrieving user library information.
 *
 */
public interface LibraryDataAccessServiceInterface {
	
	public List<EBook> getBooks(String userName);
	public boolean removeBook(String userName, String isbn);
	public boolean addBook(String userName, String isbn);
	
}