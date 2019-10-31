package com.ElementLocaters.Webdriver;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatingByClassName { 
 
 WebDriver driver = null;
 
 @Before
 public void beforetest() {
	 Logger log = Logger.getLogger("devpinoyLogger");

  // set geckodriver path.
 System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
 //To open Firefox browser
 driver = new FirefoxDriver();
 log.info("Firefox browser Instance is Opend");

 //To Maximize Browser Window
  //driver.manage().window().maximize();

 //To Open URL In browser
  driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
  log.info("Application is Launched");
 }
 
 @After
 public void aftertest() {
	 Logger log = Logger.getLogger("devpinoyLogger");
     driver.quit();
     log.info("Current Browser Instance is Closed");
  
 }
 
 @Test
 public void test() 
  {
	 Logger log = Logger.getLogger("devpinoyLogger");
   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
   log.info("Implicitly wait is applied");
 //Locating element by className and store its text to variable datentime
   String  datentime = driver.findElement(By.className("date-header")).getText();
   
   System.out.print(datentime);
   log.info("Date and Time is Printed");
  }
 
 }
