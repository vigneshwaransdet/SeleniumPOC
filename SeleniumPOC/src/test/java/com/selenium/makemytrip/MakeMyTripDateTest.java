package com.selenium.makemytrip;

import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.CapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MakeMyTripDateTest {
	@Test
	public void testMethod2() {
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/"); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@id='hp-widget__depart']")).click();
		Thread.sleep(2000);

		Date d = new Date(1);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
		String date = formatter.format(d);
		String splitter[] = date.split("-");
		String month_year = splitter[1];
		String day = splitter[0]; 
		System.out.println(month_year);
		System.out.println(day);


		selectDate(month_year,day); 
		Thread.sleep(3000);

		public String selectDate(String month_year, String select_day) throws InterruptedException {
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/span[1]"));

		for (int i = 0; i < elements.size(); i++) {
			System.out.println(elements.get(i).getText());

			// Selecting the month
			if (elements.get(i).getText().equals(month_year)) {

				// Selecting the date
				List<WebElement> days = driver.findElements(By.xpath(
						"//div[@class='ui-datepicker-inline ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all ui-datepicker-multi ui-datepicker-multi-2']/div[2]/table/tbody/tr/td/a"));

				for (WebElement d : days) {
					System.out.println(d.getText());
					if (d.getText().equals(select_day)) {
						d.click();
						Thread.sleep(10000);
						return;
					}
				}

			}

		}
		driver.findElement(By.xpath(
				"//div[@class='ui-datepicker-inline ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all ui-datepicker-multi ui-datepicker-multi-2']/div[2]/div/a/span"))
				.click();
		selectDate(month_year, select_day);

	}
}

	private void selectDate(String month_year, String day) {
		// TODO Auto-generated method stub
		
	}
}
