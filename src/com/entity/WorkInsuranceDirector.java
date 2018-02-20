package com.entity;

public class WorkInsuranceDirector implements InsuranceDirector {

	@Override
	public Insurance buildInstance() {
		return new WorkCapacityInsurance();

	}


	@Override
	public void initInfo(Insurance obj, String info) {
		WorkCapacityInsurance ins =(WorkCapacityInsurance)obj;
		ins.setInfo(info);
	}

}
