package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.LibraryDataAccessService;
import com.gcu.model.EBook;

public class LibraryBusinessService implements LibraryBusinessServiceInterface {

	@Autowired
	private LibraryDataAccessService libraryDataAccessService;
	
	@Override
	public List<EBook> getLibrary(String userName) {
		libraryDataAccessService.getBooks(userName);
		return null;
	}

}
