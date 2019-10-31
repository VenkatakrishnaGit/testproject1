package com.TestNGAssertions.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AssertNotEquals {
	
	WebDriver driver = null;
	String Actualtext;
	
	@BeforeClass
	public void setUp() {
		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		  driver = new FirefoxDriver();
		 //driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html"); 
		
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		
	}
	
	//Method Example For Assertion
	@Test
	public void assertion_Method1() {
		
		Actualtext = driver.findElement(By.xpath("//h2/span")).getText();
		
		Assert.assertNotEquals(Actualtext, "Tuesday, 28 January 2014","Expected and actual match in assertion_method_1");
		System.out.println("\n assertion_method_1() -> Part executed");
	}
	
	//Method Example For Assertion
	@Test
	public void assertion_Method2() {
		
		Assert.assertNotEquals(Actualtext, "Tuesday, 29 January 2014","Expected and actual match in assertion_method_2");
		System.out.println("\n assertion_method_2() -> Part executed");
	}
	
	@Test
	public void verification_method() {
		String time = driver.findElement(By.xpath("//div[@id='timeLeft']")).getText();
		
		if(time == "Tuesday, 28 January 2014") {
			
			System.out.println("\nText Match");
			
		}else {
			System.out.println("\n Text does not match");
		}
		
	}
}


