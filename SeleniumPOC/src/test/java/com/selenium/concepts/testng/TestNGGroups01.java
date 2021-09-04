package com.selenium.concepts.testng;

import org.testng.annotations.Test;

public class TestNGGroups01 {
	@Test(groups = { "smokeTest", "functionalTest" })
	public void loginTest() {
		System.out.println("Logged in successfully");
	}
}
