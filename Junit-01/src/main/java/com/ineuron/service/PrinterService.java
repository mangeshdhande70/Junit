package com.ineuron.service;


// Singleton Class
public class PrinterService {
	
	
	private static PrinterService INSTANCE;
	
	private PrinterService() {
		
	}
	
	public static PrinterService getInstance() {
		return INSTANCE;
	}

}
