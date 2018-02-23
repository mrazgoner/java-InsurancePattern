package com.entity;

import java.util.Calendar;
import java.util.Date;

public class CalculateNormalCost implements CalculateCostVisitor{

	
	@Override
	public double calculateCost(HouseInsurance obj) {
		
		int area = obj.getArea();
		
		if(area < 15)
			return 11 + 0.01*area + area*area*0.00001;
		else if(area < 30) 
			return 12 + 0.00430*area +  area*area*0.0002;
		else 
			return 20 + 0.502*area +  area*area*0.00021;
	}

	@Override
	public double calculateCost(WorkCapacityInsurance obj) {
		
		Date date = obj.getBirthDate();
		Date now = new Date();
		
		Calendar c = Calendar.getInstance(); 

		c.setTimeInMillis(now.getTime() - date.getTime());
		
		int mYear = c.get(Calendar.YEAR);

		
		return costPerAge(mYear);
	}

	@Override
	public double calculateCost(CarInsurance obj) {
		
		Calendar c = Calendar.getInstance();
		int now = c.get(Calendar.YEAR);
		
		double years = (double)(now  - obj.getYear());
		
		if(years < 10)
			return 10 + 2*years;
		else
			return 13 + 3.5201*years;
		
	}

	@Override
	public double calculateCost(LifeInsurance obj) {
		Date date = obj.getBirthDate();
		Date now = new Date();
		
		Calendar c = Calendar.getInstance(); 

		c.setTimeInMillis(now.getTime() - date.getTime());
		
		int mYear = c.get(Calendar.YEAR);

		
		return costPerAge_Life(mYear);
	}
	
	/**
	 * parabolic calculation of loss of work capacity insurance cost per acquiring age
	 * 
	 * @param age
	 * @return price per year
	 */
	private double costPerAge(int age)
	{
		double _age = (double)age;
		double cost = 15.0 + _age*0.01 + _age*_age*0.0002;
		return cost;
	}
	
	/**
	 * parabolic calculation of Life insurance cost per acquiring age
	 * 
	 * @param age
	 * @return price per year
	 */
	private double costPerAge_Life(int age)
	{
		double _age = (double)age;
		double cost = 13.0 + _age*0.0005 + _age*_age*0.00003;
		return cost;
	}


}
