package extentreportsdemo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentScreenshot {
	
	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest extentTest;

	
	
	@BeforeTest
	public void setExtent(){
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index.html"); 
		spark.config().setTheme(Theme.DARK);
		// this shows what will be title of the report
		spark.config().setDocumentTitle("automationReport");
		spark.config().setReportName("Screenhot report demo");
		extent.attachReporter(spark);
		
	}
	
	@AfterTest
	public void endReport(){
		extent.flush();  // generate the HTML report
		
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		
		FileUtils.copyFile(source, finalDestination);
		
		return destination;
	}
	
	@BeforeMethod
	public void setup(){
	
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
	}
	
	@Test
	public void WikiTest(){
		extentTest = extent.createTest("WikiPageTest");
		driver.get("https://www.wikipedia.org/");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,"Fail"); // not Match -> False
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		
		if(result.getStatus()==ITestResult.FAILURE){
			
			extentTest.log(Status.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(Status.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
			
			String screenshotPath = ExtentScreenshot.getScreenshot(driver, result.getName());
			//extentTest.log(Status.FAIL, extentTest.addScreenCaptureFromPath(screenshotPath)); //to add screenshot in extent report
			extentTest.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); //to add screencast/video in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(Status.PASS, "Test Case PASSED IS " + result.getName());

		}
		
		
		//extent.Test(extentTest); //ending test and ends the current test and prepare to create html report
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
