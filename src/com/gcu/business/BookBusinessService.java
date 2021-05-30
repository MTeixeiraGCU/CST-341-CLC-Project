package com.gcu.business;

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
	public void addBook(EBook eBook) {
		if(bookDataAccessService.get(eBook.getIsbn()) != null) {
			bookDataAccessService.update(eBook);
		}
		else {
			bookDataAccessService.add(eBook);
		}
	}

	@Override
	public boolean deleteBook(EBook eBook) {
		bookDataAccessService.delete(eBook);
		
		//TODO: add code here to detect proper book deletion
		return true;
	}
	
}
