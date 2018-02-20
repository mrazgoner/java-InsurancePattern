package com.entity;

public interface InsuranceDirector {
	
	public Insurance buildInstance();
	
	public void initType(Insurance obj);
	public void initInfo(Insurance obj,String info);

}
