package com.SeleniumWebDriverTipsAndTricks.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SetAndGetWindowPositionAndSize {
	WebDriver driver;
	 @BeforeTest
	 public void setup() throws Exception {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
	  driver =new FirefoxDriver();     
	 // driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  
	  //driver.get("http://only-testing-blog.blogspot.in/2015/01/table-with-checkbox.html");
	 }
	 
	 @Test(priority=1)
	 public void setGetWindowSize() {
		 //WebDriver setSize method used to set window size width = 300 and height = 500.
		 driver.manage().window().setSize(new Dimension(300, 500));
		//WebDriver getSize method used to get window width and height.
		 System.out.println("Window Width is--->"+driver.manage().window().getSize().getWidth());
		 System.out.println("Window Height is---->"+driver.manage().window().getSize().getHeight());
	 }
	 
	 @Test(priority=2)
	 public void setGetWindowPosition() {
		 //WebDriver setPosition method used to set window position x coordinate = 50 and y coordinate = 100.
	     driver.manage().window().setPosition(new Point(50, 200));
	   //WebDriver getPosition method used to get window position x,y coordinates.
	     System.out.println("Window Position X Coordinates Is "+driver.manage().window().getPosition().getX());
	     System.out.println("Window Position Y Coordinates Is "+driver.manage().window().getPosition().getY());
	     
	 }
	 
	 

}
