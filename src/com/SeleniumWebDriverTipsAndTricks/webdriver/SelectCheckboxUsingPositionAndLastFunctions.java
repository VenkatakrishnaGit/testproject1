package com.SeleniumWebDriverTipsAndTricks.webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SelectCheckboxUsingPositionAndLastFunctions {
 WebDriver driver;
 @BeforeTest
 public void setup() throws Exception {
  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
  driver =new FirefoxDriver();     
  //driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.get("http://only-testing-blog.blogspot.in/2014/09/temp.html");
 }
 @Test
 public void testSelectCheckboxUsingPositionAndLastFunctions() {
	//To select Cow checkbox using position() function.
	 driver.findElement(By.xpath("(//input[@type='checkbox'])[position()=3]")).click();
	 //To select Lion checkbox using last() function
	 driver.findElement(By.xpath("(//input[@type='checkbox'])[last()-1]")).click();
	//To select Tiger checkbox using last() function.
	 driver.findElement(By.xpath("(//input[@type='checkbox'])[last()]")).click();
 }
}
