package com.qa.testNGScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGSeleniumScript2 {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		driver = new FirefoxDriver();
		driver.get("https://mypage.rediff.com/login/dologin");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	
	@Test(priority='1')
	public void TestCreateAccount()
	{
		driver.findElement(By.xpath("//*[@id='toprightinfo']/child::a[2]")).click();
	}
	
	@Test(priority='2')
	public void AccountTest()
	{
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input")).sendKeys("sonal");
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")).sendKeys("sonal04");
	}
	
	
	@AfterClass
	public void lastmethod() throws InterruptedException{
		Thread.sleep(3000);
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	

}
