package com.entity;

public interface CalculateCostVisitor {
	
	double calculateCost(HouseInsurance obj);
	
	double calculateCost(WorkCapacityInsurance obj);
	
	double calculateCost(CarInsurance obj);
	
	double calculateCost(LifeInsurance obj);
	

}
