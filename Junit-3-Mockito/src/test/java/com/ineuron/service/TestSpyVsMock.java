package com.ineuron.service;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ineuron.repo.UserRepository;

public class TestSpyVsMock {
	
	
	/**
	 * Mock used only dummy/fake implementation but spy use fake implementation if implementation is provided
	 * by tester otherwise use real implementation that's why spy also call partial mock
	 */

	
	
	@Test
	public void testList() {
		
		//Mock Object for ArrayList class
		ArrayList<String> listMock = Mockito.mock(ArrayList.class);
		
		//Spy Object for ArrayList class
		ArrayList<String> listSpy = Mockito.spy(new ArrayList<String>());
		
		//Stubbing on Mock object
		Mockito.when(listMock.size()).thenReturn(10);
		
		//Mock Object:: Stub implementation will be used
		listMock.add("sachin");
		
		//Stubbing on Spy Object
		Mockito.when(listSpy.size()).thenReturn(10);
		
		//Spy Object :: Actual implementation of ArrayList is used
		listSpy.add("sachin");
		
		System.out.println(listMock.size() + "::"  +listSpy.size());
		
	}
	
	
	@Test
	@DisplayName("Mock Vs Spy")
	public void testSpyVsMock() {

		// Mock Object for ArrayList class
		ArrayList<String> listMock = Mockito.mock(ArrayList.class);

		// Spy Object for ArrayList class
		ArrayList<String> listSpy = Mockito.spy(new ArrayList<String>());
		
		
		listMock.add("mangesh");
		listSpy.add("rakesh");
		
		
		System.out.println("Size of Mock :: "+listMock.size() +" and Size of Spy :: "+listSpy.size());
		
		

	}
	
	

}
