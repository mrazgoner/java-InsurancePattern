package com.entity;


/**
 * 
 * builder class for all types of insurance
 * 
 * @author Michael
 *
 */
public class InsuranceBuilder {
	
	
	private Insurance newInsurance;
	
	private InsuranceDirector director;
	
	public void setDirector(InsuranceDirector director) {
		this.director = director;
	}
	
	public Insurance BuildInsurance(Customer client, String info) {
		newInsurance = null;
		buildType(info);
		buildbasicInfo(client);
		
		Insurance inst = newInsurance;
		newInsurance = null;
		
		System.out.println("*Creating Insurance");
		
		return inst;
	}
	
	/**
	 * initialize type specific insurance data
	 * 
	 * @param info
	 */
	private void buildType(String info) {
		
		this.newInsurance = director.buildInstance();
		director.initInfo(newInsurance,info);
		
	}
	
	/**
	 * initialize general insurance data
	 * 
	 * @param client
	 */
	private void buildbasicInfo(Customer client)
	{
		newInsurance.SetClient(client);
		newInsurance.setClientID(Integer.parseInt(client.getCustomersId()));
	}
	

}
