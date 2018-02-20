package com.entity;

public class CarInsuranceDirector implements InsuranceDirector {

	@Override
	public Insurance buildInstance() {
		return new CarInsurance();

	}


	@Override
	public void initInfo(Insurance obj, String info) {
		CarInsurance ins =(CarInsurance)obj;
		ins.setyear(Integer.parseInt(info));
	}

}
