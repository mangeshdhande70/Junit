package com.ineuron.service;

public class BankLoanService {
	
	
	public BankLoanService() {
		System.out.println("BankLoanService :: Zero Parameterized");
	}
	
	public float calculateSimpleInterest(float pAmount,float rate,float time) {
			
		System.out.println("BankLoanService.calculateSimpleInterest()");
		if (pAmount<=0 || rate<=0 || time<=0) 
			throw new IllegalArgumentException("Invalid Inputs");
		return (pAmount*rate*time)/100;
	}

	

	public float calculateSimpleInterestPaymentGateway(float pAmount,float rate,float time) {
		System.out.println("BankLoanService.calculateSimpleInterest()");
		if (pAmount<=0 || rate<=0 || time<=0) 
			throw new IllegalArgumentException("Invalid Inputs");
		
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return (pAmount*rate*time)/100;
	}
	
}
