package com.SeleniumWebDriverTipsAndTricks.webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PrecedingOrFollowingSiblingColumn {
 WebDriver driver;
 @BeforeTest
 public void setup() throws Exception {
  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
  driver =new FirefoxDriver();     
 // driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.get("http://only-testing-blog.blogspot.in/2015/01/table-with-checkbox.html");
 }
 
 @Test
 public void testPrecedingOrFollowingSiblingColumn() {
	//Locating element using preceding-sibling In XPath.
	 driver.findElement(By.xpath("//td[contains(text(),'Cow')]/preceding-sibling::td/input[@type='checkbox']")).click();
	//Locating element using following-sibling In XPath.
	  driver.findElement(By.xpath("//td[contains(text(),'Dog')]/following-sibling::td/input[@type='checkbox']")).click(); 
 }
 
}
