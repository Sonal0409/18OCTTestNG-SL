package com.qa.testNGScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGSeleniumScript {
	
	WebDriver driver;
	
	@BeforeClass
	public void initialSetup()
	{
		driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
	}
	
	@Test(priority='1',description="test Wikipedia homepage")
	public void TestWikiHomePage()
	{
		String title = driver.getTitle();
		System.out.println(" title of HomePage is: " + title);
		driver.findElement(By.xpath("//*[@id='www-wikipedia-org']/descendant::input[3]")).sendKeys("Selenium Automation");
		
		driver.findElement(By.xpath("//*[@id='www-wikipedia-org']/descendant::button[1]")).click();
		
	
	}
	
	@Test(priority='2',description="test Wikipedia Searchpage")
	public void testmainpage() throws InterruptedException
	{
   //driver.findElement(By.xpath("//*[@id='www-wikipedia-org']/descendant::input[3]")).sendKeys("Selenium Automation");
		
		//driver.findElement(By.xpath("//*[@id='www-wikipedia-org']/descendant::button[1]")).click();
		
	
		
		String title = driver.getTitle();
		System.out.println("The title of search page is : " + title);
		driver.findElement(By.linkText("Main page")).click();
		
		Thread.sleep(3000);
		
		driver.close();
	}
	

}















