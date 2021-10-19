package listenersDemo;


import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestUtils extends TestBase {
	
	public void getScreenshot() throws IOException
	{
		Date currentdate= new Date();
		
		String screenshotfilename=currentdate.toString().replace(" ","-").replace(":","-");
		 File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(screenshot, new File("C:\\Screenshot\\homePageScreenshot.png"));
		//FileUtils.copyFile(screenshotFile,new File(".//screenshot//"+screenshotfilename + ".png"));
	}

}
