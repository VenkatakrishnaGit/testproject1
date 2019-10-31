package com.SeleniumWebDriverTipsAndTricks.webdriver;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CaptureElementScreenshot {

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
	 public void captureScreenShot() throws IOException {
		//Locate Image element to capture screenshot.
	        WebElement image = driver.findElement(By.xpath("//img[@border='0']"));
	      //Call captureElementScreenshot function to capture screenshot of element.
	        captureElementScreenshot(image);
	 }
	 
	 public void captureElementScreenshot(WebElement e) throws IOException {
		 
		//Capture entire page screenshot as buffer.
		  //Used TakesScreenshot, OutputType Interface of selenium and File class of java to capture screenshot of entire page.
	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    
	  //Used selenium getSize() method to get height and width of element.
	    //Retrieve width of element.
	    int imgWidth = e.getSize().getWidth();
	  //Retrieve height of element.
	    int ImageHeight = e.getSize().getHeight(); 
	    
	    //Used selenium Point class to get x y coordinates of Image element.
	    //get location(x y coordinates) of the element.
	    Point p = e.getLocation();
	    int xcord = p.getX();
	    int ycord = p.getY();
	    
	  //Reading full image screenshot.
	    BufferedImage img = ImageIO.read(scrFile);
	    
	  //cut Image using height, width and x y coordinates parameters.
	    BufferedImage dest = img.getSubimage(imgWidth, ImageHeight, xcord, ycord);
	    ImageIO.write(dest, "png", scrFile);
	    
	    //Used FileUtils class of apache.commons.io.
	    //save Image screenshot In D: drive.
	    FileUtils.copyFile(scrFile, new  File("C:\\Users\\VenkatakrishnaY\\Desktop\\SeleniumScren\\Screenshot.png"));
	 }
	 
	 @AfterTest
	 public void tearDown() {
		 driver.quit();
	}
	 
	 
}
