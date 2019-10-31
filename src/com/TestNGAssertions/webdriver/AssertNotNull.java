package com.TestNGAssertions.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AssertNotNull {
	
	WebDriver driver = null;
	WebElement txt1,txt2;
	
	@BeforeClass
	public void setUp() {
		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		  driver = new FirefoxDriver();
		 //driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  driver.get("http://only-testing-blog.blogspot.in/2014/02/attributes.html"); 
		  txt1 = driver.findElement(By.xpath("//input[@id='text1']"));
		  txt2 = driver.findElement(By.xpath("//input[@id='text2']")); 
		
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		
	}
	
	//Assertion Method - will Fail
	@Test
	public void assertNotNull1() {
	System.out.println("\n"+txt1.getAttribute("disabled"));
	Assert.assertNotNull(txt1.getAttribute("disabled"));
	
	}
	
	//Assertion Method - will Pass
	@Test
	public void assertNotNull2() {
		System.out.println("\n"+txt2.getAttribute("disabled"));
		Assert.assertNotNull(txt2.getAttribute("disabled"));
		
		
	}

}
