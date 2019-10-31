package com.SeleniumWebDriverTipsAndTricks.webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetStaleelementreferenceexception {
 WebDriver driver;
 @BeforeTest
 public void setup() throws Exception {
	 System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
  driver =new FirefoxDriver();     
 // driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.get("http://www.github.com");
 }
 
 @Test
 public void getExc() throws Exception {
	//Located element and stored It's reference In variable.
	 WebElement Search_Box = driver.findElement(By.xpath("//input[@name='q']"));
	 Search_Box.sendKeys("Hello");
	 Search_Box.sendKeys(Keys.ENTER);
	 Thread.sleep(3000);
	//After search operation, Element's position Is changed.
	  //Now I am using same reference variable to clear search text box.
	  //So here, WebDriver will be not able to locate element using same reference and It will throw StaleElementReferenceException.
	 Search_Box.clear();
	 
 }
}
