package com.gcu.business;

import java.util.List;

import com.gcu.model.EBook;

public interface LibraryBusinessServiceInterface {
	
	public List<EBook> getLibrary(String userName);
	
}
