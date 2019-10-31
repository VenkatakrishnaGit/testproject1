package com.AdvancedUserInteractionsAPI.webdriver;

import java.util.List;
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

public class SelectjQuerySelectableItems {
	
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
	public void testSelectItemsJquery() {
		//Prepare list of selectable Items
		List <WebElement> selectableItems = driver.findElements(By.xpath("//ol[@id='selectable']/*"));
		
		//Build the select Item action.
		Actions toSelect = new Actions(driver);
		toSelect.clickAndHold(selectableItems.get(2)).clickAndHold(selectableItems.get(5)).click();
		
		 //Perform action.
        Action selectItems = toSelect.build();
        selectItems.perform();
		
		
	}

}
