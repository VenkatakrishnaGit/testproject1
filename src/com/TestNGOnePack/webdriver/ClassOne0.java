package com.TestNGOnePack.webdriver;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClassOne0 {
  
	WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		Logger log = Logger.getLogger("devpinoyLogger");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  log.info("Firefox browser Instance is Opend");
		 // driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		  log.info("Implicitly wait is applied to the Script");
		  driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
		  log.info("Application is Launched");
	}
	
	@AfterMethod
	public void closeBrowser() {
		Logger log = Logger.getLogger("devpinoyLogger");
	     driver.quit();
	     log.info("Current Browser instance is Closed");
	  
	}
	
	@Test
	public void testMethodDone() {
		Logger log = Logger.getLogger("devpinoyLogger");
		String title = driver.getTitle();
		System.out.println("Current page title is : "+title);
		log.info("Title is Printed");
		System.out.println("\n'TestProject1 -> TestNGOnePack -> ClassOne -> testmethodone' has been executed successfully");
	}
	
	
	
	
	
	
}
