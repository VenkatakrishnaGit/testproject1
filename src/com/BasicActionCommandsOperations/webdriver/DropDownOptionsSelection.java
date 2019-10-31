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


public class DropDownOptionsSelection {
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
 public void testSelectCommand() throws Exception {
	 driver.findElement(By.id("text1")).sendKeys("My First Name");
	
	/* //Selecting value from drop down using visible text
	 Select mydrpdwn = new Select(driver.findElement(By.id("Carlist")));
	  mydrpdwn.selectByVisibleText("Audi");  */
	 
	/* //Selecting value from drop down using index num
	 Select dd = new Select(driver.findElement(By.id("Carlist")));
	 dd.selectByIndex(3); */
	 
	/* //Select value from drop down using value
	 Select dd = new Select(driver.findElement(By.id("Carlist")));
	 dd.selectByValue("Audi Car");
	 
	  WebDriverWait wait = new WebDriverWait(driver, 15);
	  wait.until(ExpectedConditions.elementToBeClickable(By.id("text2"))); */
	 
	 
	 
	//Selecting value from drop down by value
	  Select listbox = new Select(driver.findElement(By.xpath("//select[@name='FromLB']")));
	  boolean lb =  listbox.isMultiple();
	  System.out.println("Listbox is Multiple: "+lb);
	  
	  listbox.selectByValue("Italy");
	  listbox.selectByValue("Mexico");
	  listbox.selectByValue("Spain");

	  driver.findElement(By.xpath("//input[@value='->']")).click();
	  WebDriverWait wait = new WebDriverWait(driver, 15);
	  wait.until(ExpectedConditions.elementToBeClickable(By.id("text2")));

	//Selecting value from drop down by index
	  listbox.selectByIndex(0);
	  listbox.selectByIndex(3);
	  driver.findElement(By.xpath("//input[@value='->']")).click();
	  Thread.sleep(2000);
	 
 }
}

