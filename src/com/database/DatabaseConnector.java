package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.entity.GeneralMessages;
import com.enums.ActionType;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


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

	
	public static synchronized DatabaseConnector getInstance(){
        if(instance == null){
            instance = new DatabaseConnector();
        }
        return instance;
    }
	
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
	

	/**
	 * Constructor, establishes connection to SQL 
	 * 
	 */
	@SuppressWarnings("deprecation")
	private DatabaseConnector(){

		try 
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {System.out.println("*Cannot initialize SQL driver");}

		try 
		{
			this.connection = DriverManager.getConnection("jdbc:mysql://"+ host+"/"+ baseName, user, password);      


		} catch (SQLException ex) 
		{/* handle any errors*/
			System.out.println("*SQLException: " + ex.getMessage());
			System.out.println("*SQLState: " + ex.getSQLState());
			System.out.println("*VendorError: " + ex.getErrorCode());
			actionOnError(ActionType.TERMINATE,GeneralMessages.NO_CONNECTION_TO_DB);
		}
		System.out.println("*SQL connection is sucessfull");

	}// constructor

	private void actionOnError(ActionType terminate, String noConnectionToDb) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(noConnectionToDb);
		alert.showAndWait();
		if (terminate == ActionType.TERMINATE)
		{
			Platform.exit();
			System.exit(1);
		}
		if (terminate == ActionType.CONTINUE)
			return;
		
	}

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
			System.out.println("*Unable to close connection to DB");
			e.printStackTrace();
		}
		
	}

}



