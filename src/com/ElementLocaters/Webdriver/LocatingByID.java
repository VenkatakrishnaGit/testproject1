package com.ElementLocaters.Webdriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatingByID {
	
	WebDriver driver;
	
	@Before
	public void setUP() {
	     
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
	    driver  = new FirefoxDriver();
	    driver.manage().window().maximize();
	    driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    
	}
	
	@After
	public void tearDown() {
		driver.close();
		
	}
	
	@Test
	public void testIDLocater() {
		for (int i = 0; i<=20; i++)
		  {
		   WebElement  btn = driver.findElement(By.id("submitButton"));//Locating element by id
		   if (btn.isEnabled()) 
		   {
		    //if webelement's attribute found enabled then this code will be executed.
		    System.out.print("\nCongr8s... Button is enabled and webdriver is clicking on it now");

		   //Locating button by id and then clicking on it.
		    driver.findElement(By.id("submitButton")).click(); 
		    i=20;
		    
		   }
		   else
		   {
		    //if webelement's attribute found disabled then this code will be executed.
		    System.out.print("\nSorry but Button is disabled right now..");
		   }
		   try {
		    Thread.sleep(500);
		   } catch (InterruptedException e) {
		    e.printStackTrace();
		   }
		  }
	}
	

}
