package com.entity;

public class HouseInsuranceDirector implements InsuranceDirector {

	@Override
	public Insurance buildInstance() {
		return new HouseInsurance();

	}


	@Override
	public void initInfo(Insurance obj, String info) {
		HouseInsurance ins =(HouseInsurance)obj;
		ins.setArea(Integer.parseInt(info));
	}

}
