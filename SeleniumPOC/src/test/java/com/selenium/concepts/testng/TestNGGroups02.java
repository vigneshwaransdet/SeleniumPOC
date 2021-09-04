package com.selenium.concepts.testng;

import org.testng.annotations.Test;

public class TestNGGroups02 {
	@Test(groups = { "functionalTest" })
	public void composeMail() {
		System.out.println("Mail Sent");
	}
}
