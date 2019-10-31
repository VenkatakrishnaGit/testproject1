package com.SeleniumWebDriverTipsAndTricks.webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandleSERE {
 WebDriver driver;
 @BeforeTest
 public void setup() throws Exception {
	 System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
  driver =new FirefoxDriver();     
  //driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.get("http://www.github.com");
 }
 @Test
 public void getException() throws Exception {
	// Located element and stored It's reference In variable.
	  WebElement Search_Box = driver.findElement(By.xpath("//input[@name='q']"));
	  // Used element reference variable to locate element and perform search.
	  Search_Box.sendKeys("Hello");
	  Search_Box.sendKeys(Keys.ENTER);
	  Thread.sleep(5000);
	  
	// After search operation, Element's position Is changed.
	  //use for loop.
	  for(int i=0; i<4; i++) {
		  try {
			  driver.findElement(By.xpath("//input[@name='q']")).clear();
			  break;
			  
		  }
		  catch(StaleElementReferenceException e) {
			  System.out.println("Trying to recover from a stale element :" + e.getMessage());
		  }
	  }
 }
}
