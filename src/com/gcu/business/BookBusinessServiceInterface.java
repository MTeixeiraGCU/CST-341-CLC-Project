package com.gcu.business;

import java.util.List;

import com.gcu.model.EBook;

public interface BookBusinessServiceInterface {

	public EBook getBook(String isbn);
	
	public List<EBook> getAllBooks();
	
	public void addBook(EBook eBook);
}
