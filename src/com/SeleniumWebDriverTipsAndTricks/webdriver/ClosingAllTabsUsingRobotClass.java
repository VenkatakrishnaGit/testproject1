package com.SeleniumWebDriverTipsAndTricks.webdriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClosingAllTabsUsingRobotClass {
	
	WebDriver driver;
	 Robot rb;
	 
	 @BeforeTest
	 public void setup() throws Exception {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  //driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.get("http://only-testing-blog.blogspot.in/2014/04/calc.html");
	 }
	 
	 @Test
	 public void openTab() {  
	  driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
	  driver.get("http://only-testing-blog.blogspot.in/2014/05/form.html");
	  switchToTab();
	  driver.findElement(By.xpath("//input[@id='6']")).click();
	  driver.findElement(By.xpath("//input[@id='plus']"));
	  driver.findElement(By.xpath("//input[@id='3']"));
	  driver.findElement(By.xpath("//input[@id='equals']"));
	  
	  switchToTab();
	  driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("hi");
	  driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("test");
	  
	  switchToTab();
	  String str = driver.findElement(By.xpath("//input[@id='Resultbox']")).getAttribute("value");
	  System.out.println("Sum result Is -> "+str);
	 } 
	 
	 public void switchToTab() {  
	  driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");  
	  driver.switchTo().defaultContent();  
	 }
	 
	 @AfterTest
	 public void closeTabs() throws AWTException {
	  //Used Robot class to perform ALT + SPACE + 'c' keypress event.
	  rb =new Robot();
	  rb.keyPress(KeyEvent.VK_ALT);
	  rb.keyPress(KeyEvent.VK_SPACE);
	  rb.keyPress(KeyEvent.VK_C);
	 }

}
