package com.AdvancedUserInteractionsAPI.webdriver;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DownloadAndSaveImageByRobotandActionsCls {
	
	WebDriver driver;
	 @BeforeTest
	 public void setup() throws Exception {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
	  driver =new FirefoxDriver();     
	 // driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://only-testing-blog.blogspot.in/2014/09/selectable.html");
	 }
	 
	 @AfterTest
	 public void tearDown() {
		 //driver.close();
	 }
	 
	 @Test
	 public void testDownloadAndSaveImageByRobotandActionsCls() throws Exception {
		 
		  // JavascriptExecutor jse = (JavascriptExecutor)driver;
			//jse.executeScript("window.scrollBy(0,750)", "");
		 
		 //Locate Image
		 WebElement image = driver.findElement(By.xpath("//img[@border='0']"));
		 //Right Click on the image by using contextClick() method
		 Actions a  = new Actions(driver);
		 a.contextClick(image).build().perform();
		//To perform press Ctrl + v keyboard button action.
		 a.sendKeys(Keys.CONTROL, "v").build().perform();
		 Thread.sleep(4000);
		 
		 //Using Robot Class
		 Robot r = new Robot();
		 //To Press D key
		 r.keyPress(KeyEvent.VK_D);
		 
		// To press : key.
		 r.keyPress(KeyEvent.VK_SHIFT);
		 r.keyPress(KeyEvent.VK_SEMICOLON);
		 r.keyRelease(KeyEvent.VK_SHIFT);
		// To press \ key.
		 r.keyPress(KeyEvent.VK_BACK_SLASH);
		 
		// To press "test" key one by one.
		 r.keyPress(KeyEvent.VK_T);
		 r.keyPress(KeyEvent.VK_E);
		 r.keyPress(KeyEvent.VK_S);
		 r.keyPress(KeyEvent.VK_T);
		 
		  // To press Save button.
		 r.keyPress(KeyEvent.VK_ENTER);
		 
		 
		 
		
		 
	 }
	 

}
