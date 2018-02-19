package com.entity;

public abstract class Insurance implements Entity{
	
	protected int clientID;
	protected int insuranceID;
	
	protected String type;
	
	int getClientID() {
		return this.clientID;
	}
	
	int getinsuranceID() {
		return this.insuranceID;
	}
	
	void setClientID(int id) {
		this.clientID = id;
	}
	
	void setinsuranceID(int id) {
		this.insuranceID = id;
	}
	
	public abstract String getInfo();
	
	public abstract void setInfo(String info);
	
}
