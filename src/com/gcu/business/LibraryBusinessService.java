package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.LibraryDataAccessServiceInterface;
import com.gcu.model.EBook;

/**
 * This class handles business logic dealing with a users library of books.
 *
 */
public class LibraryBusinessService implements LibraryBusinessServiceInterface {

	@Autowired
	private LibraryDataAccessServiceInterface libraryDataAccessService;
	
	/**
	 * This method takes in a username and returns a complete list of the books contained in their library.
	 * @param userName the current user to look up the library for.
	 * @return A complete List<EBook> of the users library.
	 */
	@Override
	public List<EBook> getLibrary(String userName) {
		return libraryDataAccessService.getBooks(userName);
	}
	
	/**
	 * This method removes an eBook from the users library.
	 * @param userName the user to access and remove from.
	 * @param isbn the isbn of the book to remove.
	 * @return true if the book was removed.
	 */
	@Override
	public boolean removeBook(String userName, String isbn) {
		return libraryDataAccessService.removeBook(userName, isbn);
	}
	
	/**
	 * This method adds a single book to the users library.
	 * @param userName the user to access and add from.
	 * @param isbn of the book to add to the library.
	 * @return true if the book was added.
	 */
	@Override
	public boolean addBook(String userName, String isbn) {
		return libraryDataAccessService.addBook(userName, isbn);
	}
}
