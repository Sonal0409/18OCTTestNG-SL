package com.qa.testNGScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGSeleniumScript2 {
	
	WebDriver driver;
	SoftAssert sa = new SoftAssert();
	
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
		String expected = "Rediff MyPage Login234";
		String title = driver.getTitle();
		sa.assertEquals(title, expected);  // true
		driver.findElement(By.xpath("//*[@id='toprightinfo']/child::a[2]")).click();
		sa.assertAll();
	}
	
	@Test(priority='2')
	public void AccountTest()  // Failed
	{
		String expected1="Rediffmail Free Unlimited Storage2344";
		String title1= driver.getTitle();
		sa.assertEquals(title1, expected1); //False
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input")).sendKeys("sonal");
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")).sendKeys("sonal04");
		sa.assertAll();
	}
	
	
	@AfterClass
	public void lastmethod() throws InterruptedException{
		
		Thread.sleep(3000);
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	

}
