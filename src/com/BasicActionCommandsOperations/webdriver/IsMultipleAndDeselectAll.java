package com.BasicActionCommandsOperations.webdriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class IsMultipleAndDeselectAll {
 WebDriver driver = null;
 
 @Before
 public void beforetest() {
  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
  driver = new FirefoxDriver();
  //driver.manage().window().maximize();
  driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
 }
 
 @After
 public void aftertest() {
  //driver.quit();
  
 }
 
 @Test
 public void testDD() throws Exception {
	 Select listbox = new Select(driver.findElement(By.xpath("//select[@name='FromLB']")));
	 
	 if(listbox.isMultiple())
	 {
		 System.out.print("Multiple selections is supported");
		   listbox.selectByVisibleText("USA");
		   listbox.selectByValue("Russia");
		   listbox.selectByIndex(5);
		   Thread.sleep(3000);
		   
		   //To deselect all selected options.
		   listbox.deselectAll();
		   Thread.sleep(5000);
	 }
	 else
	 {
		 System.out.print("Not supported multiple selections");
	 }
 }
}