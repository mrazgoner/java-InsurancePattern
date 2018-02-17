package com.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
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
		return "INSERT INTO client_insurance (`customersId`, `insuranceType`, `info`) "
				+ "VALUES ('"+this.customersId+"','"+insuranceType+"','"+info+"')";
	}



	public String PrepareAddCliendClaimStatement(String claimType, String content) {
		return "INSERT INTO client_claim (`customersId`, `insuranceType`, `content`) "
				+ "VALUES ('"+this.customersId+"','"+claimType+"','"+content+"')";
	}

}
