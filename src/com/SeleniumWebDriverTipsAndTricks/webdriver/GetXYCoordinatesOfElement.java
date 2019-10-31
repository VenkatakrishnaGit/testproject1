package com.SeleniumWebDriverTipsAndTricks.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetXYCoordinatesOfElement {

	
	WebDriver driver;
	 @BeforeTest
	 public void setup() throws Exception {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
	  driver =new FirefoxDriver();     
	 // driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://only-testing-blog.blogspot.in/2014/09/selectable.html");
	 }
	 
	 @Test
	 public void testGetCoordinatesOfElement() {
		 //Locate element for which you wants to retrieve x y coordinates.
		 WebElement image = driver.findElement(By.xpath("//img[@border='0']"));
		//Used points class to get x and y coordinates of element.
		 Point p = image.getLocation();
		 int xcord = p.getX();
		 System.out.println("Element's Position from left side Is "+xcord +" pixels.");
		 int ycord = p.getY();
		 System.out.println("Element's Position from top side Is "+ycord +" pixels.");
		 
		 
	 }
	 
	 @AfterTest
	 public void tearDown() {
		 driver.quit();
		 
	 }
}
