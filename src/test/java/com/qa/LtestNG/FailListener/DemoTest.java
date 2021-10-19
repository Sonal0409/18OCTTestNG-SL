package com.qa.LtestNG.FailListener;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest extends TestBase{
	
	@Test
	public void Openpage()
	{
		driver.get("https://www.wikipedia.org/");
		Assert.assertTrue(false);
	}

}
