package com.ElementLocaters.Webdriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatingByCSSSelector { 
 
 WebDriver driver = null;
 
 @Before
 public void beforetest() {

  // set geckodriver path.
 System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
 //To open Firefox browser
 driver = new FirefoxDriver();

 //To Maximize Browser Window
  driver.manage().window().maximize();

 //To Open URL In browser
  driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
 }
 
 @After
 public void aftertest() {
  //driver.quit();
  
 }
 
 @Test
 public void test() {
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	//Locate element by cssSelector and then type the text in it.
	 driver.findElement(By.cssSelector("input[name='fname']")).sendKeys("This is krishna");
 }
}
