package com.qa.testNGScripts;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Annotations3 {
	
	@BeforeSuite
	public void firstmethod()
	{
		System.out.println(" test as part of suit start");
	}
	
	@Test
	public void login()
	{
		System.out.println("Loginto the application");
	}

	@Test(dependsOnMethods= {"login"})
	public void CreateEmail()
	{
		System.out.println("Create an email");
	}
	
	// dependency : first execute login then execute create email
	
	@Test(dependsOnMethods={"login","CreateEmail"})
	public void ModifyEmail()
	{
		System.out.println("Modify an email");
	}
	
	// dependency : first execute login then execute create email then modify email the delete email
	@Test(dependsOnMethods={"login","CreateEmail","ModifyEmail"})
	public void DeleteEmail()
	{
		System.out.println("Delete an email");
	}
}
