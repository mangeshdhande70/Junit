package com.ineuron.testservice;

import static org.mockito.Mockito.spy;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SpyVsMock {
	
	
	@Test
	public void test() {
		
		
		ArrayList<String> mockList = Mockito.mock(ArrayList.class);
		mockList.add("Mangesh");
		
		// If Implementation is not given by Devloper or stub then real implementation will used
		ArrayList<String> sypList = spy(new ArrayList<>());
		sypList.add("Mangesh");
		
		System.out.println("Size of Mock List is :: "+mockList.size());
		System.out.println("Size of Spy List is :: "+sypList.size());
		
		// After Given implementaion using stub
		
         
		System.out.println("After Given implementaion using stub");
		
	
		
		ArrayList<String> mockList1 = Mockito.mock(ArrayList.class);
		mockList1.add("Mangesh");
		
		Mockito.when(mockList1.size()).thenReturn(10);
		
		// If Implementation is not given by Devloper or stub then real implementation will used
		ArrayList<String> sypList1 = spy(new ArrayList<>());
		sypList1.add("Mangesh");
		
		Mockito.when(sypList1.size()).thenReturn(11);
		
		
		System.out.println("Size of Mock List is :: "+mockList1.size());
		System.out.println("Size of Spy List is :: "+sypList1.size());
		
		
	}

}
