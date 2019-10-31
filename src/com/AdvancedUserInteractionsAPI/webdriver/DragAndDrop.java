package com.AdvancedUserInteractionsAPI.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDrop {
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
	public void testDragAndDrop() {
		
		//Locate element which u wants to drag
		WebElement dragElement = driver.findElement(By.xpath("//div[@id='dragdiv']"));
		//Locate element which u wants to drop
		WebElement dropelement = driver.findElement(By.xpath("//div[@id='dropdiv']"));
		
		//Use Actions class and Its members of WebDriver API to perform drag and drop operation.
		Actions a = new Actions(driver);
		
		//One Way
		//a.clickAndHold(dragElement).moveToElement(dropelement).release().build().perform();
		
		//Second way
		a.dragAndDrop(dragElement, dropelement).build().perform();
		
		
		
		
		
		
		
	}

}
