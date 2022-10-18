package com.calender.Handling;

import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectTodayDateInCalenderTest {
	@Test
	public void todayDate(){
		LocalDateTime systemdate = LocalDateTime.now();
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		Actions action = new Actions(driver);
		action.moveByOffset(10, 10).click().perform();
		action.moveByOffset(10, 10).click().perform();
		driver.findElement(By.xpath("//p[@data-cy='departureDate']")).click();
		driver.findElement(By.xpath(""));
		
	}

}
