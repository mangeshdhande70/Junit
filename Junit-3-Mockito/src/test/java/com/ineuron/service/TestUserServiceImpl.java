package com.ineuron.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.ineuron.repo.UserRepository;

public class TestUserServiceImpl {
	
	
	@Mock
	private UserRepository repositoryMock;
	
	@Spy
	private UserRepository repositorySpy;
	
	@InjectMocks
	private UserServiceImpl userService;
	
	
	
	public TestUserServiceImpl() {
		MockitoAnnotations.openMocks(this);
	}
	
//	@Disabled
	@Test
	@DisplayName("Test Auth User with Valid Credential")
	public void testAuthUserWithValidCredential() {
		
		System.out.println("TestUserServiceImpl.testAuthUserWithValidCredential()");
		System.out.println("UserServiceImpl :: "+repositoryMock.getClass().getName());
		
		// Provide stub(providing functionality) for DAO authenticate method
		when(repositoryMock.authenticateUser("mangesh", "12345")).thenReturn(true);
		
		// call login method to get the result
		boolean actualResult = userService.authUser("mangesh", "12345");
		

		// compare the boolean result using assert
		assertTrue(actualResult);
		
	}
	
	
//	@Disabled
	@Test
	@DisplayName("Test Auth User with Invalid Credential")
	public void testAuthUserWithInValidCredential() {
		
		// Provide stub(providing functionality) for DAO authenticate method
		when(repositoryMock.authenticateUser("mangesh", "123")).thenReturn(false);
		
		// call login method to get the result
		boolean actualResult = userService.authUser("mangesh", "123");
		

		// compare the boolean result using assert
		assertFalse(actualResult);
		
	}
	
//	@Disabled
	@Test
	@DisplayName("Test Auth User with no Inputs Credential")
	public void testAuthUserWithNoInputCredential() {	
		System.out.println("TestUserServiceImpl.testAuthUserWithNoInputCredential()");
		assertThrows(IllegalArgumentException.class, ()->userService.authUser("", ""));
		
	}
	
	
	@Test
	@DisplayName("Test User Registration with Spy")
	public void testUserRegistrationWithSpy() {
		
		UserServiceImpl  userServiceImpl = new UserServiceImpl(repositorySpy);
		userServiceImpl.registerUser("sachin", "admin", "12345");
		userServiceImpl.registerUser("sachin", "visitor","12345");
		userServiceImpl.registerUser(" ", "admin ", "12345");
		
		verify(repositorySpy,times(1)).addUser("sachin", "admin", "12345");
		verify(repositorySpy,never()).addUser("sachin", "visitor", "12345");
		verify(repositorySpy,times(0)).addUser("", "admin", "12345");
		
		
	}
	


}
