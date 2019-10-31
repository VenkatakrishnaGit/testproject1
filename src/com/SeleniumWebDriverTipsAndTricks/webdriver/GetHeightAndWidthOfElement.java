package com.SeleniumWebDriverTipsAndTricks.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetHeightAndWidthOfElement {
	
	WebDriver driver;
	 @BeforeTest
	 public void setup() throws Exception {
	 System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
	  driver =new FirefoxDriver();     
	  //driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://only-testing-blog.blogspot.in/2014/09/selectable.html");
	 }
	 
	 @Test
	 public void testGetHeightAndWidthOfElement() {
		 
		//Locate element for which you wants to get height and width.
		 WebElement image = driver.findElement(By.xpath("//img[@border='0']"));
		 int imageWidth = image.getSize().getWidth();
		 System.out.println("Image width Is "+imageWidth+" pixels");
		 //Get height of element.
		 int imageHeight = image.getSize().getHeight();
		 System.out.println("Image Height Is "+imageWidth+" pixels");
	 }
	 
	 @AfterTest
	 public void tearDown() {
		 driver.quit();
	}

}
