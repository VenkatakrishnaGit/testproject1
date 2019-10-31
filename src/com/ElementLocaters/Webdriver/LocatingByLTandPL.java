package com.ElementLocaters.Webdriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocatingByLTandPL { 
 
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
	//Locate element by linkText and then click on it.
	 driver.findElement(By.linkText("Click Here")).click();
	 WebDriverWait wait = new WebDriverWait(driver,15);
	 //Locate element by partial linkText.
	 wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("18:")));
	 
 }
}
