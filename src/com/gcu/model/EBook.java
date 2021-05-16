package com.gcu.model;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class EBook {
	
	//private fields
	@NotNull(message="There must be a valid ISBN for this book!")
	@Size(min=11,max=11,message="The ISBN must be 11 characters long!")
	String isbn;
	
	@Size(min=1,message="Book must contain a title!")
	String title;
	
	@Size(min=1, message="There must be an author for the book!")
	String author;
	
	String image;
	
	String publisher;
	
	@DateTimeFormat(pattern="yyy-MM-dd")
	Date publicationDate;

	public EBook()
	{
		this.isbn = "";
		this.title = "";
		this.author = "";
		this.publisher = "";
		this.publicationDate = new Date(0);
		this.image = "";
	}
	
	//assignment constructor
	public EBook(
			@NotNull(message = "There must be a valid ISBN for this book!") @Size(min = 11, max = 11, message = "The ISBN must be 11 characters long!") String isbn,
			@Size(min=1, message = "Book must contain a title!") String title,
			@Size(min=1, message = "There must be an author for the book!") String author, String publisher,
			@DateTimeFormat(pattern="yyyy-MM-dd") Date publicationDate,
			String image) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publicationDate = publicationDate;
		this.image = image;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
