package com.ineuron.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebResponse;



public class LoginTest {
	
	String url = "http://localhost:9999";
	
	public static WebConversation conversation;
	
	@BeforeAll
	public static void setUp() {
		conversation = new WebConversation();
	}
	
	
	@Test
	@DisplayName("Testing with valid Inputs")
	public void testLoginWithValidCredentials() throws IOException, Exception {
		
		System.out.println("LoginTest.testLoginWithValidCredentials()");
		WebResponse response = conversation.getResponse(url);
		// get access to the form from the response
		WebForm webForm = response.getForms()[0];
		webForm.setParameter("uname", "sachin");
		webForm.setParameter("password", "tendulkar");
		
		WebResponse actualResponse = webForm.submit();
		
		String actualOutput = actualResponse.getText().trim();
		
		assertEquals("valid credentials", actualOutput);
	}
	
	@Test
	@DisplayName("Testing with Invalid Inputs")
	public void testLoginWithInalidCredentials() throws IOException,Exception {
		
		WebResponse response = conversation.getResponse(url);
		// get access to the form from the response
		WebForm webForm = response.getForms()[0];
		webForm.setParameter("uname", "sachin");
		webForm.setParameter("password", "tedn");
		
		WebResponse actualResponse = webForm.submit();
		
		String actualOutput = actualResponse.getText().trim();
		
		assertEquals("invalid credentials", actualOutput);
		
	}
	
	
	@Test
	@DisplayName("Testing with no Inputs")
	public void testLoginWithNoInputCredentials() throws Exception{
		
		WebResponse response = conversation.getResponse(url);
		// get access to the form from the response
		WebForm webForm = response.getForms()[0];
		webForm.setParameter("uname", "");
		webForm.setParameter("password", "");
		
		WebResponse actualResponse = webForm.submit();
		
		String actualOutput = actualResponse.getText().trim();
		
		assertEquals("provide credentials", actualOutput);
		
	}
	
	
	@AfterAll
	public static void cleanUp() {
		conversation = null;
	}
	

}
