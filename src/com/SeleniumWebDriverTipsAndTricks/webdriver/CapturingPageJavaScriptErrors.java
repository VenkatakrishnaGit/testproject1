package com.SeleniumWebDriverTipsAndTricks.webdriver;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;

public class CapturingPageJavaScriptErrors {
	WebDriver driver;
	
	@BeforeTest
	public void setUp() throws Exception {
		FirefoxProfile fp = new FirefoxProfile();
		JavaScriptError.addExtension(fp);
		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver(fp);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://only-testing-blog.blogspot.com/2015/01/table-with-checkbox.html");
	}
	
	@Test
	public void printPageErrors() {
		//Capture all errors and store them In array.
		List<JavaScriptError> Errors = JavaScriptError.readErrors(driver);
		System.out.println("Total No Of JavaScript Errors : " +Errors.size());
		//Print Javascript Errors one by one from array.
		for(int i = 0; i<Errors.size(); i++) {
			System.out.println("Error Message : "
			+Errors.get(i).getErrorMessage());
			
			System.out.println("Error Line No : "
			+Errors.get(i).getLineNumber());
			
			System.out.println(Errors.get(i).getSourceName());
			
			System.out.println();
			
			
		}
	}

}
