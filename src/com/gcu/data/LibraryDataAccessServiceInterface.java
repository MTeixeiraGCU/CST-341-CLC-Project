package com.gcu.data;

import java.util.List;

import com.gcu.model.EBook;

public interface LibraryDataAccessServiceInterface {
	public List<EBook> getBooks(String userName);
}