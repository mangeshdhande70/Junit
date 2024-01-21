package com.ineuron.service;

public class CensusService {
	
	
	public String exportData() {
		//---- logic
		return "Exported Data";
	}
	
	public boolean isOdd(int num) {
		return num%2==0?false:true;
	}
	
	public boolean isEmpty(String name) {
		return name.isBlank();
	}
	

}
