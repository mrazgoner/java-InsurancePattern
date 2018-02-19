package com.database;

import java.util.ArrayList;

import com.entity.Entity;

public interface EntityDao<T extends Entity> {
	
	public boolean updateInDatabase(T obj);
	
	public ArrayList<T> getAll() ;


}
