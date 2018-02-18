package com.database;

public interface DatabaseProxy {

	public void SetConnection(String Host,String BaseName,String User,String Password);
	
	
	public void CloseConnection();
	
}
