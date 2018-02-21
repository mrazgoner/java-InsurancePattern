package com.entity;

public class CarInsurance extends Insurance implements CalculateCostVisitable{

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
	
	
	public int getYear() {
		return year;
	}
	
	public void setyear(int year) {
		this.year = year;
	}
	
	public double calculateCost(CalculateCostVisitor obj) {
		return obj.calculateCost(this);
	}

}
