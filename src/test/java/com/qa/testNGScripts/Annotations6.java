package com.qa.testNGScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotations6 {
	
   static String name="selenium";
	
	@BeforeClass  // this method will execute first, before any test method in the class
	public void setString1()
	{
		System.out.println("First method executed - BeforeClass");
	}
	
	@BeforeMethod // this method wil be executed before every test method
	public void mytool()
	{
		System.out.println("we are learning testng : before method");
	}
	
	@Test(priority='1')
	public void tool1()
	{
		
		
		System.out.println("@Test method we are learning " + name);
	}
	
	
	@AfterMethod
	public void newtool()
	{
		System.out.println("we want to learn jmeter");
	}
	
	@AfterClass
	public void closebrowser()
	{
		// this method will be exeucted as the last method in the class
		System.out.println("close browser");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
