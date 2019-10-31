package com.BasicActionCommandsOperations.webdriver;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GenerateAndInsertLogsByLog4j {
 WebDriver driver = null;
 
 @Before
 public void beforetest() {
	 
  Logger log = Logger.getLogger("devpinoyLogger");
  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
  driver = new FirefoxDriver();
  log.info("Firefox browser Instance is Opend");
  
 //diver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
  log.info("Implicitly wait is applied to the Script");
  driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
  log.info("Application is Launched");
 }
 
 @After
 public void aftertest() {
	 Logger log = Logger.getLogger("devpinoyLogger");
     driver.quit();
     log.info("Current Browser instance is Closed");
  
 }
 
 @Test
 public void testlog4j() { 
	 
	 Logger log = Logger.getLogger("devpinoyLogger");
	  driver.findElement(By.id("text1")).sendKeys("My First Name");
	  
	  log.debug("Type In Text field.");
	  Select mydrpdwn = new Select(driver.findElement(By.id("Carlist")));
	  mydrpdwn.selectByVisibleText("Audi");
	  
	  log.debug("Select value from drop down.");
	  WebDriverWait wait = new WebDriverWait(driver, 15);
	  wait.until(ExpectedConditions.elementToBeClickable(By.id("text2")));
	  
 }
}
