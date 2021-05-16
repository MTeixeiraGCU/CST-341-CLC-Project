package com.gcu.business;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.gcu.model.EBook;

public interface BookBusinessServiceInterface {

	public EBook getBook(String isbn);
	
	public List<EBook> getAllBooks();
	
	public void addBook(String isbn, String title, String author, String publisher, Date publicationDate, String image);
}
