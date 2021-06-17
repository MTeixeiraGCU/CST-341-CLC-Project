package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.IDataAccessService;
import com.gcu.model.EBook;

/**
 * 
 * The class handles business logic relating to EBook information and how it is transfered to the users
 *
 */
public class BookBusinessService implements BookBusinessServiceInterface {

	@Autowired
	private IDataAccessService<EBook> bookDataAccessService;
	
	/**
	 * This method gets a single book from the database based on the given ISBN.
	 * @param isbn The ISBN of the book to retrieve.
	 * @return A single EBook with the matching ISBN.
	 */
	@Override
	public EBook getBook(String isbn) {
		return bookDataAccessService.get(isbn);
	}

	/**
	 * This method gets a list of all the current books in the database.
	 * @return The complete List&lt;EBook&gt; of books in the database.
	 */
	@Override
	public List<EBook> getAllBooks() {
		return bookDataAccessService.getAll();
	}

	/**
	 * This method adds or updates single book to the database.
	 * @param eBook This is the eBook to add to the database.
	 */
	@Override
	public void addBook(EBook eBook) {
		//If the book does not exist add it to the database else make a new entry for it
		if(bookDataAccessService.get(eBook.getIsbn()) != null) {
			bookDataAccessService.update(eBook);
		}
		else {
			bookDataAccessService.add(eBook);
		}
	}

	/**
	 * This method takes in an eBook and attempts to remove it from the database.
	 * @param eBook the book to remove from the database
	 * @return true if the book was successfully removed.
	 */
	@Override
	public boolean deleteBook(EBook eBook) {
		bookDataAccessService.delete(eBook);
		
		//TODO: Add code here to detect proper book deletion
		return true;
	}
	
}
