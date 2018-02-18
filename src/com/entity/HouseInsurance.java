package com.entity;

public class HouseInsurance extends Insurance{

	private int area; 
	
	public HouseInsurance() {
		super.type = "House Insurance";
	}
	
	public String getInfo() {
		return "" + area;
	}

	@Override
	public void setInfo(String info) {
		area = Integer.parseInt(info);
	}

}
