package com.qa.testNGScripts;

import org.testng.annotations.Test;

public class Annotations4 {
	
	@Test
	public void tool1()
	{
		System.out.println("Jira");
	}
	
	// skip this method
	@Test(timeOut=2000)  // testng to wait only for 2 sec : if more than 2 sec ..then fail the case
	public void tool2() throws InterruptedException
	{
		Thread.sleep(5000); // wait 5 sec
		System.out.println("Error on this test method");
		System.out.println("Selenium");
	}
	
	@Test
	public void tool3()
	{
		System.out.println("Appium");
	}

}
