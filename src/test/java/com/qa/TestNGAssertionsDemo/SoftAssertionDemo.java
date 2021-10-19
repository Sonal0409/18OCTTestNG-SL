package com.qa.TestNGAssertionsDemo;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionDemo {
	
	// Name is class is again SoftAssert
	// Class SoftAssert, method assertEquals()
	
	SoftAssert sa = new SoftAssert();
	
	@Test
	public void titleValidate()  // Failed
	{
		String expected = "SeleniumTraining";
		String actual = "SeleniumTraining355";
		String expected1 = "SeleniumTraining";
		String actual1 = "SeleniumTraining";
		
		sa.assertEquals(actual, expected,"The title dont match"); // false -- throw an error
		// script will stop execution of the output is False
		System.out.println(expected);
		System.out.println(actual);
		
		sa.assertEquals(actual1, expected1,"2nd set of results dont match"); // true
		
		System.out.println(expected1);
		System.out.println(actual1);
		
		sa.assertAll();
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
