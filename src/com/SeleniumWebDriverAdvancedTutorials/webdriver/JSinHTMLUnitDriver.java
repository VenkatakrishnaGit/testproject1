package com.SeleniumWebDriverAdvancedTutorials.webdriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JSinHTMLUnitDriver {

	HtmlUnitDriver driver;
	String pagetitle;


	@AfterTest
	public void tearDown() throws Exception {
		// Closing HtmlUnitDriver.
		driver.quit();
	}

	@Test
	public void googleSearch() {
		// Get current page title using javascript executor.
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		String pagetitle = (String) javascript.executeScript("return document.title");
		System.out.println("My Page Title Is  : " + pagetitle);
	}
	@BeforeTest
	public void setup() throws Exception {
		// Initializing HtmlUnitDriver.
		driver = new HtmlUnitDriver(true);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// To hide warnings logs from execution console.
		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);
		
		// Opening URL In HtmlUnitDriver.
		driver.get("http://www.google.com");
	}

}
