package com.entity;

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

}
