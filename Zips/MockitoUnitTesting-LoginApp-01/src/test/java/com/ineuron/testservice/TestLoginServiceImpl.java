package com.ineuron.testservice;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ineuron.dao.ILoginDao;
import com.ineuron.service.ILoginService;
import com.ineuron.service.LoginServiceImpl;



public class TestLoginServiceImpl {

	static int count = 0;
	private static ILoginDao loginDaoMock;
	private static ILoginService loginService;

	@BeforeAll // Before all test case it will execute.
	public static void init() {
		// create a mock object for DAO class having null method Implementation
		loginDaoMock = Mockito.mock(ILoginDao.class);
		System.out.println("Mock class object is :: " + loginDaoMock.getClass().getName());

		// Create Service class object by using Mock object
		loginService = new LoginServiceImpl(loginDaoMock);
	}
	
//	@BeforeEach // before each method it will execute
//	public static void beforeEach() {
//		System.out.println("Before Each :: " + ++count);
//		
//	}

	@Test
	public void testLoginWithValidCredentials() {
		// Provide stub(providing functionality) for DAO authenticate method
		Mockito.when(loginDaoMock.authenticate("sachin", "tendulkar")).thenReturn(1);

		// call login method to get the result
		boolean acutalOutput = loginService.login("sachin", "tendulkar");

		// compare the boolean result using assert
		assertTrue(acutalOutput);
	}

	@Test
	public void testLoginWithInValidCredentials() {
		// Provide stub(providing functionality) for DAO authenticate method
		Mockito.when(loginDaoMock.authenticate("sachin", "sachin@123")).thenReturn(0);

		// call login method to get the result
		boolean acutalOutput = loginService.login("sachin", "sachin@123");

		// compare the boolean result using assert
		assertFalse(acutalOutput);
	}

	@Test
	public void testLoginWithNoCredentials() {
		
		assertThrows(IllegalArgumentException.class, () -> loginService.login("", ""));
	}
	
	
	@Test
	public void testRegisterService() {
		
		
		
		ILoginDao spyDao = Mockito.spy(ILoginDao.class);
		System.out.println("Mock class object is :: " + spyDao.getClass().getName());
		
		loginService = new LoginServiceImpl(spyDao);
		
		loginService.registerUser("Sachin", "tendulkar");
		loginService.registerUser("kohli", "");
		loginService.registerUser("dhoni", "visitor");
		
		// To Check how many times method is called
		Mockito.verify(spyDao,Mockito.times(1)).addUser("Sachin", "tendulkar");
		Mockito.verify(spyDao,Mockito.never()).addUser("kohli", "");
		Mockito.verify(spyDao,Mockito.times(0)).addUser("dhoni", "visitor");
		
	}


	@AfterAll
	public static void clearOnce() {
		loginDaoMock = null;
		loginService = null;
	}

}

