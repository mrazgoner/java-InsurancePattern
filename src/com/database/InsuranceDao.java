package com.database;

import java.util.ArrayList;

import com.entity.Insurance;

public class InsuranceDao implements EntityDao<Insurance> {


	@Override
	public ArrayList<Insurance> getAll() {
		ArrayList<Insurance> InsuranceList = new ArrayList<Insurance>();
		return InsuranceList;
	}

	@Override
	public boolean updateInDatabase(Insurance obj) {
		return DatabaseController.addNewClientInsurance(obj.getClient(), obj.getType(), obj.getInfo());
	}


}
