package com.ineuron.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;


@DisplayName("TestBankServiceClass")
//@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class) // to run the test cases as we have provided order to the method
@TestMethodOrder(value = MethodOrderer.MethodName.class) // based on actual method name 
public class TestBankService {
	
	
	private static BankLoanService service;
	
//	@BeforeEach
//	public void setUp() {
//		System.out.println("TestBankService.setUp()");
//		service = new BankLoanService();
//	}
	
	
	@BeforeAll
	public static void setUp() {
		System.out.println("\n************** TestBankService.setUp() **************************");
		service = new BankLoanService();
	}

	@Test
	@Tag("dev")  // to make sure only in dev it will run
	@DisplayName("Testing with small number")
	@Order(1)
	public void testCalculateSimpleInterestWithSmallNumber() {
		System.out.println("\nTestBankService.testCalculateSimpleInterestWithSmallNumber()");
		float actualOutput = service.calculateSimpleInterest(100000, 2, 12);
		float expectedOutput = 24000.0f;
		assertEquals(expectedOutput, actualOutput);

	}

	@Test
	@DisplayName("Testing with Big Number")
	@Order(3)
	@Tag("uat") 
	public void testCalculateSimpleInterestWithBigNumber(TestInfo testInfo) {
		System.out.println("TestBankService.testCalculateSimpleInterestWithBigNumber()"
	    +" Class Name "+testInfo.getClass() +" :: Method Name :: "+testInfo.getDisplayName());
		System.out.println("\nTestBankService.testCalculateSimpleInterestWithBigNumber()");
		float actualOutput = service.calculateSimpleInterest(1000000, 4, 36);
		float expectedOutput = 1440000.345f;
		// if i want to neglate 0.5 then add delta 0.5f is delta
		assertEquals(expectedOutput, actualOutput,0.5f,"Results are not matching");

	}
	
	
	@Test
	@Order(2) // to set order when this method called
	@DisplayName("Testing with Invalid Inputs")
	@Tag("dev") 
	public void testCalculateSimpleInterestWithInvalidInputs() {
		System.out.println("\nTestBankService.testCalculateSimpleInterestWithInvalidInputs()");
        assertThrows(IllegalArgumentException.class, ()->service.calculateSimpleInterest(0, 0, 0));
	}
	
	
	@Test
//	@Disabled
	@Tag("dev") 
	@Tag("uat")
	@DisplayName("Testing with Payment Gateway Timer")
	public void testCalculateSimpleInteresttPaymentGatewayWithTimer() {
		System.out.println("\nTestBankService.testCalculateSimpleInteresttPaymentGatewayWithTimer()");
		assertTimeout(Duration.ofMillis(30000), ()->service.calculateSimpleInterestPaymentGateway(12000, 2, 24));
		
	}
	
	
	// it will throw the error and test case will show in errors section
	@Test
	@Disabled
	@Tag("dev") 
	@DisplayName("Testing with Payment Invalid Input Error")
	public void testCalculateSimpleInterestWithInvalidInputsError() {
		System.out.println("\nTestBankService.testCalculateSimpleInterestWithInvalidInputsError()");
		float actualOutput = service.calculateSimpleInterest(0, 0, 0);
		float expectedOutput = 1440000.345f;
        assertEquals(expectedOutput, actualOutput);
	}
	
	
//	@AfterEach
//	public void cleanUp() {
//		System.out.println("TestBankService.cleanUp()");
//		service = null;
//	}

	
	@AfterAll
	public static void cleanUp() {
		System.out.println("\n*************** TestBankService.cleanUp() ***********************");
		service = null;
	}


}
