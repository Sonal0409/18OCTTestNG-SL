package com.qa.testNGScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Annotation2 {
	
	// you can add description to your test case
	// can i give 2 attributes to test annotation
	
	@Test(description="Add 2 numbers",priority='1')
	public void testcase1()
	{
        int a=10;
        int b=20;
        int result = a+b;
		System.out.println(a+b);
		Assert.assertTrue(result>40);

	}
	
	@Test(description="multiple 2 numbers",priority='2')
	public void testcase2()
	{
		int a=2;
		int b=3;
		System.out.println(a*b);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
