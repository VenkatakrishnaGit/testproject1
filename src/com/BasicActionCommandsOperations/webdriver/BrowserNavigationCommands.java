package com.BasicActionCommandsOperations.webdriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BrowserNavigationCommands {
 WebDriver driver = null;
 
 @Before
 public void beforetest() {
  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
  driver = new FirefoxDriver();
  //driver.manage().window().maximize();
  //driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
 }
 
 @After
 public void aftertest() {
  //driver.quit();
  
 }
 
 @Test
 public void testNavigationCommands() throws Exception {
	 
	 driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
	 Thread.sleep(3000);
	 driver.navigate().to("https://www.google.com/");
	 
	//To navigate back (Same as clicking on browser back button)
	 driver.navigate().back();
	 
	//To navigate forward (Same as clicking on browser forward button)
	  driver.navigate().forward();
	  
	  //To refresh current browser
	  driver.navigate().refresh();
	  
 }
}