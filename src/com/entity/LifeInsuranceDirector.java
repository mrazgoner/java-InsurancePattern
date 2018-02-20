package com.entity;

public class LifeInsuranceDirector implements InsuranceDirector {

	@Override
	public Insurance buildInstance() {
		return new LifeInsurance();

	}


	@Override
	public void initInfo(Insurance obj, String info) {
		LifeInsurance ins =(LifeInsurance)obj;
		ins.setInfo(info);
	}

}
