package com.AdvancedUserInteractionsAPI.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MoveJQuerySlider {
	
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
	public void testMoveJQuerySlider() throws Exception {
		
		//Locate slider pointer.
		WebElement dragElementFrom  = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[1]/div/div/div/div[1]/div/div/div/div[1]/div[2]/div[1]/div[1]/span"));
		 //To Move jQuery slider by 100 pixel offset using dragAndDropBy method of Actions class.
		Actions a = new Actions(driver);
		a.dragAndDropBy(dragElementFrom, 100, 0).build().perform();
		Thread.sleep(4000);
		//After 5 seconds, This will Move jQuery slider by 100 pixel offset using the combination of clickAndHold, moveByOffset and release methods of Actions class.
		a.clickAndHold(dragElementFrom).moveByOffset(100, 0).release().perform();
	}

}
