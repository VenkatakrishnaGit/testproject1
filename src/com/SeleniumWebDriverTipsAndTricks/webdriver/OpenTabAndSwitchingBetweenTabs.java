package com.SeleniumWebDriverTipsAndTricks.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenTabAndSwitchingBetweenTabs {
	WebDriver driver;
	 
	 @BeforeTest
	 public void setup() throws Exception {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
	  driver = new FirefoxDriver();
		 //System.setProperty("webdriver.chrome.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\chromedriver_win32\\chromedriver.exe");
		 // driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.get("http://only-testing-blog.blogspot.in/2014/04/calc.html");
	  
	 }
	 
	 @Test
	 public void openTab() throws Exception {
		 
	  //Open tab 2 using CTRL + t keys.
	  driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
	  //Open URL In 2nd tab.
	  driver.get("http://only-testing-blog.blogspot.in/2014/05/form.html");
	  
	  //Call switchToTab() function to switch to 1st tab
	  switchToTab();
	  //perform required actions on tab 1.
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@id='6']")).click();
	  driver.findElement(By.xpath("//input[@id='plus']"));
	  driver.findElement(By.xpath("//input[@id='3']"));
	  driver.findElement(By.xpath("//input[@id='equals']"));
	  
	  //Call switchToTab() function to switch to 2nd tab.
	  switchToTab();
	  //perform required actions on tab 2.
	  driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("hi");
	  driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("test");
	  
	  //Call switchToTab() function to switch to 1st tab
	  switchToTab();
	  //perform required actions on tab 1.
	  String str = driver.findElement(By.xpath("//input[@id='Resultbox']")).getAttribute("value");
	  System.out.println("Sum result Is -> "+str);
	 } 
	 
	 public void switchToTab() {
	  //Switching between tabs using CTRL + tab keys.
	  driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
	  //Switch to current selected tab's content.
	  driver.switchTo().defaultContent();  
	 }

}
