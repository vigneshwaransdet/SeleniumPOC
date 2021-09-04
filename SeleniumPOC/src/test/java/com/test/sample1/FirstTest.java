package com.test.sample1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("chrome://settings/");
		driver.manage().window().maximize();
		
		WebElement eleSettings = driver.findElement(By.tagName("settings-ui"));
		WebElement shadowFirstRoot = (WebElement) driver.executeScript("return arguments[0].shadowRoot", eleSettings);
		
//		Find the Left Menu
		WebElement eleLeftMenu = shadowFirstRoot.findElement(By.id("leftMenu"));
		WebElement shadowLeftMenu = (WebElement) driver.executeScript("return arguments[0].shadowRoot", eleLeftMenu);
		
//		Click on the Appearance
		WebElement eleAppearance = shadowLeftMenu.findElement(By.id("appearance"));
		WebElement shadowAppearance = (WebElement) driver.executeScript("return arguments[0].shadowRoot", eleAppearance);

/*
 * driver.findElement(By.xpath(".//*[@id='type']")).click();    
	((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath(".//*[@id='type']/option[3]")));
 * 
 * 
 */
//		select 80% zoom
		shadowAppearance.findElement(By.)
		
	}

}
