package com.selenium.concepts.windowHandles;

import java.util.Iterator;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SingleWindowHandle {
	@Test
	public void testSingleWindowHandle() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/popup.php");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Click Here")).click();
		
		String mainWindow = driver.getWindowHandle();
		
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		
		while (itr.hasNext()) {
			String childWindow = itr.next();
			
			if(!mainWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				driver.findElement(By.name("emailid")).sendKeys("gaurav.2n@gmail.com");
				driver.findElement(By.name("btnLogin")).submit();
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
	}

}
