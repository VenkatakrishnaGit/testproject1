package com.WebdriverWaitCommands.webdriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ImplicitlyWaitSyntax { 
 
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
  driver.quit();
  
 }
 
 @Test
 public void testImplicitlyWait() {
	   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	   driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("My Name");
	   driver.findElement(By.xpath("//input[@name='namexyz']"));
 }
}
