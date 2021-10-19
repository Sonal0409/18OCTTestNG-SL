package listenersDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ListenerDemoTest extends TestBase {
	
	@Test
	public void OpenPage()
	{
		driver.get("https://mypage.rediff.com/login/dologin");
		Assert.assertTrue(false);
	}

}
