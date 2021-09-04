package com.selenium.concepts.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizationTest {
	@Test
	@Parameters("browser")
	public void testMethodParameterizationTest(String browser) {
		if (browser.equals("firefox")) {
			System.out.println("Open Firefox Driver");
		} else if (browser.equals("chrome")) {
			System.out.println("Open Chrome Driver");
		}
	}
}
