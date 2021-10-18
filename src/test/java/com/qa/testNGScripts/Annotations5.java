package com.qa.testNGScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations5 {
	
	
	@BeforeTest
	public void testsetup()
	{
		System.out.println("Setup the test");
	}
	
	@Test(groups= {"Regression"})
	public void testcase1()
	{
		System.out.println("its regression testcase1");
	}
	@Test (groups= {"Regression"})
	public void testcase2()
	{
		System.out.println("its regression testcase2");
	}
	
	@Test(groups= {"Regression"})
	public void testcase3()
	{
		System.out.println("its regression testcase3");
	}
	@Test(groups= {"UnitTesting"})
	public void testcase4()
	{
		System.out.println("its Unit testcase");
	}
	@Test(groups= {"UnitTesting"})
	public void testcase5()
	{
		System.out.println("its Unit testcase");
	}
	
	@AfterTest
	public void testclose()
	{
		System.out.println("Close the browser");
	}
	

}
