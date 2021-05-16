package com.gcu.business;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.IDataAccessService;
import com.gcu.model.EBook;

public class BookBusinessService implements BookBusinessServiceInterface {

	@Autowired
	private IDataAccessService<EBook> bookDataAccessService;
	
	@Override
	public EBook getBook(String isbn) {
		return bookDataAccessService.get(isbn);
	}

	@Override
	public List<EBook> getAllBooks() {
		return bookDataAccessService.getAll();
	}

	@Override
	public void addBook(String isbn, String title, String author, String publisher, Date publicationDate) {
		EBook eBook = new EBook(isbn, title, author, publisher, publicationDate);
		bookDataAccessService.add(eBook);
	}
	
}
