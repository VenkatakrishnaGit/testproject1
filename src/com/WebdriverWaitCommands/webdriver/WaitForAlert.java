package com.WebdriverWaitCommands.webdriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitForAlert {
 WebDriver driver = null;
 
 @Before
 public void beforetest() {
  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
  driver = new FirefoxDriver();
 // driver.manage().window().maximize();
  driver.get("http://only-testing-blog.blogspot.in/2014/01/new-testing.html");
 }
 
 @After
 public void aftertest() {
 // driver.quit();
  
 }
 
 @Test
 public void test () 
  {  
  driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("My Name");
  WebDriverWait wait = new WebDriverWait(driver, 15);
  wait.until(ExpectedConditions.alertIsPresent());
  
  String alrt = driver.switchTo().alert().getText();
  System.out.print(alrt);
  }
 
 
 
 }
