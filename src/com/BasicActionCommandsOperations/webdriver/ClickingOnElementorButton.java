package com.BasicActionCommandsOperations.webdriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ClickingOnElementorButton { 
 
 WebDriver driver = null;
 
 @Before
 public void beforetest() {

  // set geckodriver path.
 System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
 //To open Firefox browser
 driver = new FirefoxDriver();

 //To Maximize Browser Window
 // driver.manage().window().maximize();

 //To Open URL In browser
  driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
 }
 
 @After
 public void aftertest() {
  driver.quit();
  
 }
 
 @Test
 public void testClickCommand() {
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 for(int i = 0; i<=20; i++) {
		 WebElement btn = driver.findElement(By.id("submitButton"));
		 if(btn.isEnabled()) {
			//if webelement's attribute found enabled then this code will be executed.
			    System.out.print("\nCongr8s... Button is enabled and webdriver is clicking on it now");
			    
			    //Locating by Id and then Clicking on it
			    btn.click();
			    i=20;
		 }
		 else {
			//if webelement's attribute found disabled then this code will be executed.
			    System.out.print("\nSorry but Button is disabled right now..");
		 }
		 try {
			 Thread.sleep(5000);
		 }
		 catch(InterruptedException e) {
			 e.printStackTrace();
		 }
	 }
	 
	 
 }
}
