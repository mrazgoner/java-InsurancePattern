package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * DatabaseController:
 * class containing JDBC SQL connection
 * and methods for handling queries  
 */

public class DatabaseConnector implements DatabaseProxy{

	private static DatabaseConnector instance;
	
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
		instance = new DatabaseConnector();
	}

	public static synchronized DatabaseConnector getInstance(){
        if(instance == null){
            instance = new DatabaseConnector();
        }
        return instance;
    }
	

	/**
	 * Constructor, establishes connection to SQL 
	 * 
	 */
	@SuppressWarnings("deprecation")
	private DatabaseConnector(){

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

	@Override
	public void SetConnection(String Host, String BaseName, String User, String Password) {
		if(instance!=null)
			CloseConnection();
		initialize( Host, BaseName, User, Password);
		instance = getInstance();
		
	}

	@Override
	public void CloseConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Unable to close connection to DB");
			e.printStackTrace();
		}
		
	}

}



