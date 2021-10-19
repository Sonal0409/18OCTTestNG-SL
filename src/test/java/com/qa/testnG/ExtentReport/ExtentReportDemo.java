package com.qa.testnG.ExtentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportDemo {
	
	ExtentReports extent;
	WebDriver driver;
	@BeforeClass
	public void generateReport()
	{
	
	
	 extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
	
	spark.config().setDocumentTitle("Automationtesting");
	spark.config().setTheme(Theme.DARK);
	spark.config().setReportName("ExtentReport Demo");
	extent.attachReporter(spark);
	}
	
	@AfterClass
	public void endReport()
	{
		extent.flush();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org/");
		
	}
	
	@Test
	public void testWiki()
	{
	// Test Nodes
	ExtentTest test=extent.createTest("WikiHomePage").assignAuthor("Sonal")
			.assignCategory("Functional")
			.assignDevice("Chrome94");
	
	test.pass("Wiki homePage Title Validation");
	
	String expected = "Wikipedia2345";
	String title = driver.getTitle();
	test.fail("TestCase has failed");
	Assert.assertEquals(title, expected);
	
	
	}	
	
	
	@Test
	public void testWiki2()
	{
	// Test Nodes
	ExtentTest test1=extent.createTest("WikiHomePage").assignAuthor("Sonal")
			.assignCategory("Functional")
			.assignDevice("Chrome94");
	
	test1.pass("Wiki homePage Title Validation");
	
	String expected = "Wikipedia";
	String title = driver.getTitle();
	test1.fail("TestCase has failed");
	Assert.assertEquals(title, expected);

	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
