package com.entity;

public abstract class Insurance implements Entity{
	
	protected int clientID;
	protected Customer client;
	protected int insuranceID;
	
	protected String type;
	
	public Customer getClient() {
		return client;
	}
	
	public void SetClient(Customer client) {
		 this.client = client;
	}
	
	public String getType() {
		return this.type;
	}
	
	public int getClientID() {
		return this.clientID;
	}
	
	public int getinsuranceID() {
		return this.insuranceID;
	}
	
	public void setClientID(int id) {
		this.clientID = id;
	}
	
	public void setinsuranceID(int id) {
		this.insuranceID = id;
	}
	
	public abstract String getInfo();
	
	public abstract void setInfo(String info);
	
}
