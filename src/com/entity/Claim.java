package com.entity;

public class Claim {
	private int id;
	private String fName;
	private String lName;
	private String customersId;
	private String claimType;
	private String content;
	private String status;
	
	public Claim(int id, String customersId, String claimType, String content, String status) {
		super();
		this.id = id;
		this.customersId = customersId;
		this.claimType = claimType;
		this.content = content;
		this.status = status;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getCustomersId() {
		return customersId;
	}
	
	public int getId() {
		return id;
	}

	public String getFName() {
		return fName;
	}

	public String getLName() {
		return lName;
	}

	public String getClaimType() {
		return claimType;
	}

	public String getContent() {
		return content;
	}

	public String getStatus() {
		return status;
	}

}
