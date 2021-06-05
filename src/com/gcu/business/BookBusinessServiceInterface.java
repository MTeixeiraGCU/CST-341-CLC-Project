package com.gcu.business;

import java.util.List;

import com.gcu.model.EBook;

/**
 * This interface is designed as a business layer for handling EBook related logic
 *
 */
public interface BookBusinessServiceInterface {

	public EBook getBook(String isbn);
	
	public List<EBook> getAllBooks();
	
	public void addBook(EBook eBook);
	
	public boolean deleteBook(EBook eBook);
}
