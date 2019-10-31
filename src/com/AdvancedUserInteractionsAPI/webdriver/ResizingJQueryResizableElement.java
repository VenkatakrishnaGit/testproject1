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

public class ResizingJQueryResizableElement {
WebDriver driver = null;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
       // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("http://only-testing-blog.blogspot.in/2014/09/selectable.html");
		
	}
	
	@AfterTest
	public void tearDown() {
		//driver.close();
		
	}
	
	@Test
	public void testResizingJQueryResizableElement() throws Exception {
		
		//Locate resizable element's bottom-right corner.
		WebElement resizeElement = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
		//To resize jQuery resizable element by 250 pixel X,Y offset using dragAndDropBy method of Actions class.
		Actions a = new Actions(driver);
		a.dragAndDropBy(resizeElement, 250, 250).build().perform();
		Thread.sleep(4000);
		//After 5 seconds, This will resize jQuery resizable element by -100 pixel X,Y offset using the combination of clickAndHold, moveByOffset and release methods of Actions class.
		a.clickAndHold(resizeElement).moveByOffset(-100, -100).build().perform();
		
		
		
		
	}

}
