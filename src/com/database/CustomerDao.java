package com.database;

import java.util.ArrayList;

import com.entity.Customer;

/**
 * 
 * data access class for the customer in database
 * 
 *
 *
 */
public class CustomerDao implements EntityDao<Customer> {

	@Override
	public boolean updateInDatabase(Customer obj) {
		if(DatabaseController.addNewCustomer(obj))
			return true;		
		return false;
	}

	@Override
	public ArrayList<Customer> getAll() {
		ArrayList<Customer> customers = DatabaseController.getCustomers();
		if(customers!= null)
		{
			System.out.println("successfully retrived " + customers.size() + " Customers from Database");
		}
		else System.out.println("Error retriving Customers");
		
		return customers;
	}


}
