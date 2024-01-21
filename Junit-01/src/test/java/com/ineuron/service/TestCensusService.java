package com.ineuron.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TestCensusService {
	
	private static CensusService censusService;
	
	@BeforeAll
	public static void setUp() {
		censusService = new CensusService();
	}
	
	@Disabled
	@DisplayName(value = "Test Export Data")
	// for repeat the logic and customize the message 
	@RepeatedTest(value = 10,name = "execution of {displayName}-{currentRepetition}/{totalRepetitions}")
	public void testExportData() {
		System.out.println("TestCensusService.testExportData()");
		String actualResult = censusService.exportData();
		String expectedResult = "Exported Data";
		
		assertEquals(expectedResult, actualResult);
	}
	
	
	@Disabled
	@ParameterizedTest // For provide parameter
	@ValueSource(ints = {13,7,3,11,15,19,23})
	public void testIsOddWithOddInputs(int data) {
		System.out.println("TestCensusService.testIsOddWithOddInputs():: data :: "+data);
		boolean actualResult = censusService.isOdd(data);
		assertTrue(actualResult);
	}
	
	@Disabled
	@ParameterizedTest
	@ValueSource(ints = {12,10,14,2,8,22,100})
	public void testIsOddWithEvenInputs(int data) {
		System.out.println("TestCensusService.testIsOddWithEvenInputs():: Data :: "+data);
		boolean actualResult = censusService.isOdd(data);
		assertFalse(actualResult);
	}
	
	
	@ParameterizedTest
//	@NullAndEmptySource
	@EmptySource
//	@NullSource
	public void testIsEmpty(String data) {
		System.out.println("TestCensusService.testIsEmpty()");
		assertTrue(censusService.isEmpty(data));
	}
	
	
	@AfterAll
	public static void cleanUp() {
		censusService = null;
	}

}
