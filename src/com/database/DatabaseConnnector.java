package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * DatabaseController:
 * class containing JDBC SQL connection
 * and methods for handling queries  
 */

public class DatabaseConnnector {

	private static DatabaseConnnector instance;
	
	private Connection connection;
	private static String host;
	private static String baseName;
	private static String user;
	private static String password;

	
	/**
	 * initialize or reset JDBC, not thread safe.
	 * should be use at startup
	 * 
	 * 
	 * @param Host
	 * @param BaseName
	 * @param User
	 * @param Password
	 */
	public static void initialize(String Host,String BaseName,String User,String Password)
	{
		host = Host;
		baseName = BaseName;
		user = User;
		password = Password;
		instance = new DatabaseConnnector();
	}

	public static synchronized DatabaseConnnector getInstance(){
        if(instance == null){
            instance = new DatabaseConnnector();
        }
        return instance;
    }
	

	/**
	 * Constructor, establishes connection to SQL 
	 * 
	 */
	@SuppressWarnings("deprecation")
	private DatabaseConnnector(){

		try 
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {System.out.println("Cannot initialize SQL driver");}

		try 
		{
			this.connection = DriverManager.getConnection("jdbc:mysql://"+ host+"/"+ baseName, user, password);      


		} catch (SQLException ex) 
		{/* handle any errors*/
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		System.out.println("SQL connection is sucessfull");

	}// constructor

	public Connection getConnection() {
		return this.connection;
	}

}



