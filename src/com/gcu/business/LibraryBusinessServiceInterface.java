package com.gcu.business;

import java.util.List;

import com.gcu.model.EBook;

/**
 * This interface is designed as a business layer for handling a users library and the related logic it requires.
 *
 */
public interface LibraryBusinessServiceInterface {
	
	public List<EBook> getLibrary(String userName);
	public boolean removeBook(String userName, String isbn);
	public boolean addBook(String userName, String isbn);
}
