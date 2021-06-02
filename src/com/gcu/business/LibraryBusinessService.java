package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.LibraryDataAccessServiceInterface;
import com.gcu.model.EBook;

public class LibraryBusinessService implements LibraryBusinessServiceInterface {

	@Autowired
	private LibraryDataAccessServiceInterface libraryDataAccessService;
	
	@Override
	public List<EBook> getLibrary(String userName) {
		return libraryDataAccessService.getBooks(userName);
	}

}
