package com.entity;

public class LifeInsurance extends Insurance{

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

}
