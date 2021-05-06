package com.gcu.dataService;

import java.util.List;

/**
 * This interface is used to design simple database CRUD operations for multiple model types
 * 
 * @author Marc
 *
 * @param <T> The type of model object that the implementing class is designed for
 */
public interface DataAccessService<T> {
	
	//Retrieve
	T get(String id);
	
	//Retrieve many
	List<T> getAll();
	
	//Create
	void add(T t);
	
	//Update
	void update(T t, String[] params);
	
	//Delete
	void delete(T t);
}
