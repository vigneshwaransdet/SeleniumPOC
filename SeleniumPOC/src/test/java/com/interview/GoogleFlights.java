package com.interview;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleFlights {
	@Test
	public void test1() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/travel/flights");
		
//		To select trip
		driver.findElement(By.xpath("//*[@class='RLVa8 GeHXyb']//span[@class='VfPpkd-kBDsod UmgCUb']")).click();
		
//		To Select one way
		driver.findElement(By.xpath("//li[text()='One way']")).click();
		
//		To enter the departure
		driver.findElement(By.xpath("//div[@jsname='FDWhSe']")).sendKeys("Chennai");
	}
}
