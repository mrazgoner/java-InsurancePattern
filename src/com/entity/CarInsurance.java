package com.entity;

public class CarInsurance extends Insurance{

	private int year; 
	
	public CarInsurance() {
		super.type = "Car Insurance";
	}
	
	public String getInfo() {
		return "" + year;
	}

	@Override
	public void setInfo(String info) {
		year = Integer.parseInt(info);
	}

}
