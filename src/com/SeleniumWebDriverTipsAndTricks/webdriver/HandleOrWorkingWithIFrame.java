package com.SeleniumWebDriverTipsAndTricks.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandleOrWorkingWithIFrame {
	WebDriver driver;
	 @BeforeTest
	 public void setup() throws Exception {
		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
	  driver =new FirefoxDriver();     
	  //driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://only-testing-blog.blogspot.in/2015/01/iframe1.html");
	 }
	 
	 @Test
	 public void handleFrames(){
	  //Working with page element.
	  //Inserting some text In Town textbox of page.
	  driver.findElement(By.xpath("//input[@name='Town']")).sendKeys("Your town");
	  
	  //Working with Iframe1 elements
	  //switch to frame1 and select cow checkbox from table. frame1 Is ID of frame.
	  driver.switchTo().frame("frame1");
	  driver.findElement(By.xpath("//td[contains(text(),'Cow')]/preceding-sibling::td/input[@type='checkbox']")).click();
	  
	  //Switch back to page content.
	  driver.switchTo().defaultContent();
	  
	  //Working with Iframe2 elements
	  //switch to frame2 and select I have a boat checkbox.  frame2 Is ID of frame.
	  driver.switchTo().frame("frame2");
	  driver.findElement(By.xpath("//input[@value='Boat']")).click();
	  
	  //switch back to page to Inserting some text In Country textbox of page.
	  driver.switchTo().defaultContent();
	  driver.findElement(By.xpath("//input[@name='Country']")).sendKeys("your country");
	 }

}
