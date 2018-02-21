package com.entity;

public class HouseInsurance extends Insurance implements CalculateCostVisitable{

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
	
	public int getArea() {
		return area;
	}
	
	public void setArea(int area) {
		this.area = area;
	}

	@Override
	public double calculateCost(CalculateCostVisitor obj) {
		return obj.calculateCost(this);
	}

}
