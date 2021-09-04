package com.selenium.makemytrip;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class GoIbibo {
	@Test
	public void testMethod1() throws InterruptedException, IOException {
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[@id='roundTrip']")).click();
//		From
		WebElement roundFrom = driver.findElement(By.xpath("//input[@id='gosuggest_inputSrc']"));
		roundFrom.sendKeys("A");
		Thread.sleep(4000);
		roundFrom.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(4000);
//		To
		WebElement roundTo = driver.findElement(By.xpath("//input[@id='gosuggest_inputDest']"));
		roundTo.sendKeys("MAA");
		Thread.sleep(4000);
		roundTo.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(4000);

//		To get the current Date and Time [Just for reference purpose]
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//		LocalDateTime now = LocalDateTime.now();
//		System.out.println(dtf.format(now));
//		String nowDate = now.toString();
//		String substringnowDate = nowDate.substring(8, 10);
//		System.out.println(substringnowDate);

//		From Date
		List<WebElement> priceListFrom = driver.findElements(By.xpath("//div[contains(@class,'calDate')]//span[contains(@id,'price')]"));
		
		List<Integer> priceTextFrom = new ArrayList<Integer>();
		for (int i = 0; i < priceListFrom.size(); i++) {
			priceTextFrom.add(Integer.parseInt(priceListFrom.get(i).getText()));
		}
		
		int minFrom = Collections.min(priceTextFrom);
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//div[contains(@class,'calDate')]//span[text()='"+minFrom+"']")).click();
		Thread.sleep(4000);
		
//		To Date
		List<WebElement> priceListTo = driver.findElements(By.xpath("//div[contains(@class,'calDate')]//span[contains(@id,'price')]"));
		
		List<Integer> priceTextTo = new ArrayList<Integer>();
		for (int j = 0; j < priceListTo.size(); j++) {
			priceTextTo.add(Integer.parseInt(priceListTo.get(j).getText()));
		}
		
		int minTo = Collections.min(priceTextTo);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[contains(@class,'calDate')]//span[text()='"+minTo+"']")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//button[normalize-space()='SEARCH']")).click();
		
		Thread.sleep(4000);	
		
		WebElement totalPriceExp = driver.findElement(By.xpath("//span[@class='font24 quicksand fb']"));
		String totalPriceExpText = totalPriceExp.getText();
		SoftAssert softAssertion= new SoftAssert();
		int totalPriceAct = minFrom + minTo;
		softAssertion.assertEquals(totalPriceExpText, String.valueOf(totalPriceAct));
		
//		To print the flight name
		WebElement flightName = driver.findElement(By.xpath("(//span[@class='db TxtCenter grey font11 padT5'])[1]"));
		System.out.println(flightName.getText());
		
//		To Print How many stops
		WebElement stops = driver.findElement(By.xpath("(//div[@class='font12 grey TxtCenter'])[1]"));
		System.out.println(stops.getText());
		
//		To Print the travel hours 
		WebElement travelHours = driver.findElement(By.xpath("(//div[@class='ico12 grey TxtCenter padB5'])[1]"));
		System.out.println(travelHours.getText());
		
//		Take Screenshot
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SrcFile, new File(".\\screenshots\\goibibo.png"));
		
//		To Take Full Screenshot
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "jpg", new File(".\\screenshots\\goibibo01.jpg"));
		
		
		
	}
}