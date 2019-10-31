package com.BasicActionCommandsOperations.webdriver;

import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.IOException;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HowToEnableOrDisableTextboxbyJSE {
 WebDriver driver = null;
 
 @Before
 public void beforetest() {
  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
  driver = new FirefoxDriver();
  driver.manage().window().maximize();
  driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
 }
 
 @After
 public void aftertest() {
  driver.quit();
  
 }
 
 @Test
 public void testElementEnabledOrDisabled() throws Exception {
	 boolean fbefore = driver.findElement(By.xpath("//input[@name='fname']")).isEnabled();
	  System.out.print("\nBefore : First Name Text box enabled status is : "+fbefore);
	  boolean lbefore = driver.findElement(By.xpath("//input[@name='lname']")).isEnabled();
	  System.out.print("\nBefore : Last Name Text box enabled status is : "+lbefore);
	  
	  Thread.sleep(2000);
	  
	  //To disable First Name text box
	  JavascriptExecutor javascript = (JavascriptExecutor) driver;
	  String todisable = "document.getElementsByName('fname')[0].setAttribute('disabled', '');";
	  javascript.executeScript(todisable);
	  Thread.sleep(2000);
	  
	  //To enable Last Name text box
	  String toenable = "document.getElementsByName('lname')[0].removeAttribute('disabled');";
	  javascript.executeScript(toenable);
	  Thread.sleep(3000);
	  
	  
	  boolean fafter = driver.findElement(By.xpath("//input[@name='fname']")).isEnabled();
	  System.out.print("\nAfter : First Name Text box enabled status is : "+fafter);
	  boolean lafter = driver.findElement(By.xpath("//input[@name='lname']")).isEnabled();
	  System.out.print("\nAfter : Last Name Text box enabled status is : "+lafter);
	    
	  }
 
 public void HighlightMyElement(WebElement element) { 
	  for (int i = 0; i < 10; i++) 
	  { 
	   JavascriptExecutor javascript = (JavascriptExecutor) driver;
	   javascript.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: orange; border: 4px solid orange;");
	   javascript.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: pink; border: 4px solid pink;");
	   javascript.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: yellow; border: 4px solid yellow;");
	   javascript.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, ""); 
	   } 
	  } 
 }