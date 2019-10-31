package com.AdvancedUserInteractionsAPI.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoubleClickOnButtonUsingActionsClass {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
       // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("http://only-testing-blog.blogspot.in/2014/09/selectable.html");
	}
	
	@AfterTest
	public void tearDown() {
		//driver.close();
		
		
	}
	
	@Test
	public void testDoubleClickOnButtonUsingActionsClass() throws Exception {
		
		WebElement button = driver.findElement(By.xpath("//button[contains(.,'Double-Click Me To See Alert')]"));
		//To generate double click action on "Double-Click Me To See Alert" button.
		Actions a = new Actions(driver);
		
		a.doubleClick(button);
		a.build().perform();
		
		Thread.sleep(4000);
		
		String alertMsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(alertMsg);
		
		
		
	}
	

}
