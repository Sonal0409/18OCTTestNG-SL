package com.qa.testNGScripts;

import org.testng.annotations.Test;

public class Annotations {
	
	// TestNG executes your testcases in an alphbatical order
	// @Test : annotation that executes your test cases
	// execute test in a sequence -- Attributes of @test annotation
	// Attribute name: priority
	
	@Test(priority='1')
	public void testLogin()  // Test method
	{
		System.out.println("Successfully logged into application");
	}
	
	@Test(priority='2')
	public void testCreateemail()
	{
		System.out.println("Created an email");
	}
	
	@Test(priority='3')
	public void Aeleteemail()
	{
		System.out.println("Deleted  an email");
	}
	
	
	
	
	
	
	
	

}
