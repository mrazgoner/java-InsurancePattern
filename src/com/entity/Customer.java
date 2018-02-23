package com.entity;

import com.control.SalesController;

public class Customer implements Entity{
	
	@SuppressWarnings("unused")
	private int id;
	private String fName;
	private String lName;
	private String birthDate;
	private String address;
	private String phone;
	private String email;
	private String customersId;
	
	
	public Customer(int id, String fName, String lName, String birthDate, String address, String phone, String email,
			String customersId) {
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.birthDate = birthDate;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.customersId = customersId;
	}
	
	

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getCustomersId() {
		return customersId;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	

	
	public String PrepareAddStatement() 
	{
		return "INSERT INTO client (`fName`, `lName`, `birthDate`, `address`, `phone`, `email`, `customersId`) "
				+ "VALUES ('"+this.fName+"','"+this.lName+"','"+this.birthDate+"','"+this.address+"','"+this.phone+"','"+this.email+"','"+this.customersId+"')";
	}
	
	public String PrepareAddCliendInsuranceStatement(String insuranceType, String info) 
	{
		InsuranceBuilder builder = new InsuranceBuilder();
		
		switch (insuranceType) {
		case "Car Insurance":
			builder.setDirector(new CarInsuranceDirector());
			break;
		case "Life Insurance":
			builder.setDirector(new LifeInsuranceDirector());
			break;
		case "House Insurance":
			builder.setDirector(new HouseInsuranceDirector());
			break;
		case "Loss of Working Capacity Insurance":
			builder.setDirector(new WorkInsuranceDirector());
			break;
		}
		
		System.out.println("Creating Insurance");
		Insurance ins = builder.BuildInsurance(this, info);
		double cost = ins.calculateCost(new CalculateNormalCost());
		String cost2DigDec = String.format("%.2f", cost);
		SalesController.cost = cost2DigDec;
	
		System.out.println("Insurance monthly cost: " + cost );
		
		return "INSERT INTO client_insurance (`customersId`, `insuranceType`, `info`) "
				+ "VALUES ('"+this.customersId+"','"+insuranceType+"','"+info+"')";
	}



	public String PrepareAddCliendClaimStatement(String claimType, String content) {
		int status = 1;
		return "INSERT INTO client_claim (`customersId`, `insuranceType`, `content`, `status`) "
				+ "VALUES ('"+this.customersId+"','"+claimType+"','"+content+"','"+status+"')";
	}


}
