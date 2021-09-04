package com.selenium.concepts.asserts;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAndHardAsserts {
	@Test
	 public void softAssert(){
	 SoftAssert softAssertion= new SoftAssert();
	 System.out.println("softAssert Method Was Started");
	 softAssertion.assertTrue(false);
	 String s = "True";
	 softAssertion.assertEquals("Not True", s);
	 System.out.println("softAssert Method Was Executed");
	 softAssertion.assertAll();
	 }
	 
	 @Test
	 public void hardAssert(){
	 System.out.println("hardAssert Method Was Started");
	 Assert.assertTrue(false);
	 System.out.println("hardAssert Method Was Executed");
	 }

}
