package com.selenium.concepts.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTests {
	@Test
	public void getFirefox() {
		WebDriverManager.firefoxdriver().setup();
		System.out.println("GetFirefox Method is running on Thread : " + Thread.currentThread().getId());
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.softwaretestingmaterial.com");
		driver.close();
	}

	@Test
	public void getChorme() {
		WebDriverManager.chromedriver().setup();
		System.out.println("GetChrome Method is running on Thread : " + Thread.currentThread().getId());
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.softwaretestingmaterial.com");
		driver.close();
	}
}
