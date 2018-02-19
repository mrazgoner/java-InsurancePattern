package com.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WorkCapacityInsurance extends Insurance{

	private String ClientBirthDate; 
	
	public WorkCapacityInsurance() {
		super.type = "Loss of Working Capacity Insurance";
	}
	
	public String getInfo() {
		return ClientBirthDate;
	}

	@Override
	public void setInfo(String info) {
		ClientBirthDate = info;
	}
	
	public Date getBirthDate() {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(ClientBirthDate);
		} catch (ParseException e) {
			System.out.println("Date is invalid");
			e.printStackTrace();
			return null;
		}
	}

}
