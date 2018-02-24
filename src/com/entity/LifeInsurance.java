package com.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LifeInsurance extends Insurance implements CalculateCostVisitable{

	private String ClientBirthDate; 
	
	public LifeInsurance() {
		super.type = "Life Insurance";
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
			System.out.println("*Date is invalid");
			e.printStackTrace();
			return null;
		}
	}
	
	public double calculateCost(CalculateCostVisitor obj) {
		return obj.calculateCost(this);
	}

}
