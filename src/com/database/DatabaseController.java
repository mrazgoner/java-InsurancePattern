package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.entity.Customer;
import com.enums.ActionType;

/**
 * This class include the methods for SQL queries. the class also include the connection
 * into the constructor.
 *
 */
public class DatabaseController {

	
	/**
	 * static variable for database connection.
	 */
	public static Connection connection;
	
	/**
	 * Create new instance of driver for SQL connection. if the action failed
	 * exceptions throw and catch into other class.
	 * @throws InstantiationException Instantiation Exception.
	 * @throws IllegalAccessException Illegal Access Exception.
	 * @throws ClassNotFoundException Class Not Found Exception.
	 */
	public DatabaseController() throws InstantiationException,
	IllegalAccessException,
	ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	}
	
	/**
	 * Set connection to database, and presave the connection in static variable connection.
	 * @param username Gets the username
	 * @param password Gets the database password
	 * @throws SQLException SQL exceptions.
	 */
	public void SetConnection(String username, String password) throws SQLException
	{
		connection = DriverManager.getConnection("jdbc:mysql://localhost/insurance",username,password);
	}
	
	/**
	 * Close the connection from database.
	 */
	static void CloseConnection()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** Perform query to database (add).
	 * @param statement Gets the statement.
	 * @throws SQLException throw exception if there is problem in database.
	 */
	public static void addToDatabase(String statement) throws SQLException {
		Statement stmt=connection.createStatement();
		stmt.executeUpdate(statement);
	    stmt.close();	
	}
	
	/** Perform query to database (remove).
	 * @param statement Gets the statement.
	 * @throws SQLException throw exception if there is problem in database.
	 */
	public static void removeFromDatabase(String statement) throws SQLException {
		Statement stmt=connection.createStatement();
		stmt.executeUpdate(statement);
	    stmt.close();	
	}
	
	/** Perform query to database (update).
	 * @param statement Gets the statement.
	 * @throws SQLException throw exception if there is problem in database.
	 */
	public static void updateDatabase(String statement) throws SQLException {
		Statement stmt=connection.createStatement();
		stmt.executeUpdate(statement);
	    stmt.close();	
	}
	
	/** Perform query to database (search).
	 * @param statement Gets the statement.
	 * @throws SQLException throw exception if there is problem in database.
	 */
	public static ResultSet searchInDatabase(String statement) throws SQLException {
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(statement);
		return rs;	
	}
	
	public static ArrayList<Customer> getCustomers()
	{
		ArrayList<Customer> customersList = new ArrayList<Customer>();
		ResultSet rs;
		try {
			rs = DatabaseController.searchInDatabase("SELECT ID, fName, lName, birthDate, address, phone, email, customersId FROM client");
			while (rs.next())
			{
				Customer custumer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
				customersList.add(custumer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return customersList;
		
	}
	
	public static Boolean addNewCustomer(Customer customer)
	{
		boolean sqlResult = false;
		try {
			DatabaseController.addToDatabase(customer.PrepareAddStatement());
			sqlResult = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return sqlResult;
		
	}
	
	public static Boolean addNewClientInsurance(Customer customer, String insuranceType, String info)
	{
		boolean sqlResult = false;
		try {
			DatabaseController.addToDatabase(customer.PrepareAddCliendInsuranceStatement(insuranceType, info));
			sqlResult = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return sqlResult;
		
	}
	
	public static Boolean addNewClientClaim(Customer customer, String claimType, String content)
	{
		boolean sqlResult = false;
		try {
			DatabaseController.addToDatabase(customer.PrepareAddCliendClaimStatement(claimType, content));
			sqlResult = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return sqlResult;
		
	}

}
