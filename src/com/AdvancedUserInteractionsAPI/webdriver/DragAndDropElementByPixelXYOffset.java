package com.AdvancedUserInteractionsAPI.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDropElementByPixelXYOffset {
	
	
	
WebDriver driver = null;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
       // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("http://only-testing-blog.blogspot.in/2014/09/drag-and-drop.html");
		
	}
	
	@AfterTest
	public void tearDown() {
		//driver.close();
		
	}
	
	@Test
	public void drabAndDropBy() throws Exception {
		//Locate element which you wants to drag.
		  WebElement dragElementFrom = driver.findElement(By.xpath("//div[@id='dragdiv']"));
		  
		//To drag and drop element by 100 pixel offset In horizontal direction X.
		 Actions a =  new Actions(driver);
				 a.dragAndDropBy(dragElementFrom, 100, 0).build().perform();
				 
				 //To generate alert after horizontal direction drag and drop.
				 JavascriptExecutor js = (JavascriptExecutor)driver;
				 js.executeScript("alert('Element Is drag and drop by 100 pixel offset In horizontal direction.');");
				 Thread.sleep(4000);
				 driver.switchTo().alert().accept();
				 
				//To drag and drop element by 100 pixel offset In Vertical direction Y.
				 a.dragAndDropBy(dragElementFrom, 0, 100).build().perform();
				//To generate alert after Vertical direction drag and drop.
				 js.executeScript("alert('Element Is drag and drop by 100 pixel offset In Vertical direction.')");
				 Thread.sleep(4000);
				 driver.switchTo().alert().accept();
				//To drag and drop element by -100 pixel offset In horizontal and -100 pixel offset In Vertical direction.
				 a.dragAndDropBy(dragElementFrom, -100, -100).build().perform();
				 
				//To generate alert after horizontal and vertical direction drag and drop.
				 js.executeScript("alert('Element Is drag and drop by -100 pixel offset In horizontal and -100 pixel offset In Vertical direction.')");
				 Thread.sleep(4000);
				 driver.switchTo().alert().accept();
				 
				 /*Alternatively you can use moveByOffset method of selenium WebDriver's Advanced User Interactions API 
				  * to move software web element by given pixel offset. Syntax Is as bellow. 
				  */
				 
				 new Actions(driver).clickAndHold(dragElementFrom).moveByOffset(100,100).release().perform();
				 
		  
	}

}
