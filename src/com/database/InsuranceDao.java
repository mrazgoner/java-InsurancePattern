package com.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entity.CarInsurance;
import com.entity.CarInsuranceDirector;
import com.entity.Customer;
import com.entity.HouseInsuranceDirector;
import com.entity.Insurance;
import com.entity.InsuranceBuilder;
import com.entity.InsuranceDirector;
import com.entity.LifeInsuranceDirector;
import com.entity.WorkInsuranceDirector;

/**
 * 
 *  data access class for the Insurance Entity in database
 *
 */
public class InsuranceDao implements EntityDao<Insurance> {


	@Override
	public ArrayList<Insurance> getAll() {
		ArrayList<Insurance> InsuranceList = new ArrayList<Insurance>();
		InsuranceBuilder builder = new InsuranceBuilder();
		InsuranceDirector car = new CarInsuranceDirector();
		InsuranceDirector life = new LifeInsuranceDirector();
		InsuranceDirector house = new HouseInsuranceDirector();
		InsuranceDirector work = new WorkInsuranceDirector();

		ResultSet rs;
		try {
			rs = DatabaseController.searchInDatabase("SELECT ID, customersId, insuranceType, info, FROM client_insurance");
			while (rs.next())
			{
				switch (rs.getString(3)) {
				case "Car Insurance":
					builder.setDirector(car);
					break;
				case "House Insurance":
					builder.setDirector(house);
					break;
				case "Life Insurance":
					builder.setDirector(life);
					break;
				case "Loss of Working Capacity Insurance":
					builder.setDirector(work);
					break;
				}
				Customer tmp = new Customer(0, null, null, null, null, null, null, rs.getString(2));

				Insurance insurance = builder.BuildInsurance(tmp, rs.getString(4));

				InsuranceList.add(insurance);
			}
		} catch (SQLException e) {
			System.out.println("*database error");
			e.printStackTrace();
		}


		return InsuranceList;
	}

	@Override
	public boolean updateInDatabase(Insurance obj) {
		if(DatabaseController.addNewClientInsurance(obj.getClient(), obj.getType(), obj.getInfo()))
		{
			System.out.println("*Insurance Sucessfully Updated:\n"
					+ " Client: "+ obj.getClientID()+"\n "
					+ " Type: "+ obj.getType());
			return true;
		}
			else return false;
	}


}
