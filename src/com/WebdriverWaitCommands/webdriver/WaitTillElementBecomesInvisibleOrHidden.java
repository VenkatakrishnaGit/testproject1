package com.WebdriverWaitCommands.webdriver;

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


public class WaitTillElementBecomesInvisibleOrHidden {
 WebDriver driver = null;
 
 @Before
 public void beforetest() {
  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
  driver = new FirefoxDriver();
  //driver.manage().window().maximize();
  driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
 }
 
 @After
 public void aftertest() {
  //driver.quit();
  
 }
 
 @Test
 public void testWaitTillElementBecInvOrHidden() {
	 
	 //Wait for element invisible
	 WebDriverWait wait = new WebDriverWait(driver,15);
	 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@id='text4']")));
	 
	 System.out.println("Text box text4 is now invisible");
 }
}
