package com.qa.testnsDemoListener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterXMLDemo {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		 driver = new ChromeDriver();
		 driver.get("https://www.wikipedia.org/");
		 driver.manage().window().maximize();
	}
	
	@AfterClass
	public void CloseBrowser() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}
	
	@Parameters({"Input"})
	@Test(priority='1')
	public void TestDataDemo(String Input)
	{
		driver.findElement(By.id("searchInput")).sendKeys(Input);
		
		driver.findElement(By.xpath("//*[@id=\"search-form\"]/fieldset/button")).click();
		
	}
	
	@Test(priority='2')
	public void testOne()
	{
		Assert.assertTrue(false);
	}
	
	
	 @Test(priority='3')
	    public void testMethodSkip()
	    {
	     throw new SkipException("Skipped Intentionally");
	    }
	
	
	
	
	
	
	
	
	

}
