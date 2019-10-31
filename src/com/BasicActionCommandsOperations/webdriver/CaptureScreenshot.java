package com.BasicActionCommandsOperations.webdriver;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class CaptureScreenshot {
 WebDriver driver = null;
 
 @Before
 public void beforetest() {
  //System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
  //driver = new FirefoxDriver();
	 driver = new SafariDriver();
  driver.manage().window().maximize();
  driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
 }
 
 @After
 public void aftertest() {
  driver.quit();
  
 }
 
 @Test
 public void testCaptureScreenshot() throws IOException
 {
	 try {
	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(scrFile , new File("C:\\Users\\VenkatakrishnaY\\Desktop\\SeleniumScrena\\Screenshot.png"));
	 System.out.println("Screenshot is captured and stored in your C: Drive");
 }
	 catch(FileNotFoundException e)
	 {
		 System.out.println("Screenshot not Captured");
	 
		 
	 }
}
}
