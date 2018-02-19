package com.database;

import java.util.ArrayList;

import com.entity.Customer;

public class CustomerDao implements EntityDao<Customer> {

	@Override
	public boolean updateInDatabase(Customer obj) {
		return DatabaseController.addNewCustomer(obj);
	}

	@Override
	public ArrayList<Customer> getAll() {
		return DatabaseController.getCustomers();
	}


}
