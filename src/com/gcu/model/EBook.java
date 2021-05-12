package com.gcu.model;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class EBook {
	
	//private fields
	@NotNull(message="There must be a valid ISBN for this book!")
	@Size(min=10,max=10,message="The ISBN must be 10 characters long!")
	String isbn;
	
	@NotNull(message="Book must contain a title!")
	String title;
	
	@NotNull(message="There must be an author for the book!")
	String author;
	
	String publisher;
	
	@DateTimeFormat(pattern="ddMMyyyy")
	Date publicationDate;

	public EBook()
	{
		this.isbn = "";
		this.title = "";
		this.author = "";
		this.publisher = "";
		this.publicationDate = new Date(0);
	}
	
	//assignment constructor
	public EBook(
			@NotNull(message = "There must be a valid ISBN for this book!") @Size(min = 10, max = 10, message = "The ISBN must be 10 characters long!") String isbn,
			@NotNull(message = "Book must contain a title!") String title,
			@NotNull(message = "There must be an author for the book!") String author, String publisher,
			@DateTimeFormat(pattern="ddMMyyyy") Date publicationDate) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publicationDate = publicationDate;
	}

	
	//getters and setters
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publiher) {
		this.publisher = publiher;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
}
