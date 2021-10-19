package com.qa.TestNGAssertionsDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertionsDemo {
	
	
	// Assertions : Class is Assert
	// Syntax : Assert.method(actual, expected);
	//Syntax : Assert.method(actual, expected,"message");
	// if the output is true for the assert method, then testcase is pass
	// TestNg will give an exception : AssertionError ---> message upon failure
	// Hard Assertion
	@Test
	public void titleValidate()
	{
		String expected = "SeleniumTraining";
		String actual = "SeleniumTraining355";
		Assert.assertEquals(actual, expected,"The title dont match");
		// script will stop execution of the output is False
		System.out.println(expected);
		System.out.println(actual);
	}

}
