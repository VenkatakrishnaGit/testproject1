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

public class AssertFalse {
	
	WebDriver driver = null;
	WebElement chk1,chk2;
	
	@BeforeClass
	public void setUp() {
		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		  driver = new FirefoxDriver();
		 //driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  driver.get("http://only-testing-blog.blogspot.in/2014/02/attributes.html"); 
		  chk1 =  driver.findElement(By.xpath("//input[@name='option1']"));
		  chk2 =  driver.findElement(By.xpath("//input[@name='option2']"));
		
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		
	}
	
	//Assertion Method - will pass
	@Test
	public void assertFalse1() {
	System.out.println("\n"+chk1.isSelected());
	Assert.assertFalse(chk1.isSelected());
	System.out.println("\n assertFalse1 - > Executed - means assertion is pass");
	}
	
	//Assertion Method - will fail
	@Test
	public void assertFalse2() {
		System.out.println("\n"+chk2.isSelected());
		Assert.assertFalse(chk2.isSelected());
		System.out.println("\n assertFalse2 - > Executed - means assertion is pass");
		
	}


}
