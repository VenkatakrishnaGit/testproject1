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


public class VerificationCommands {
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
  driver.quit();
  
 }
 
 @Test
 public void testElementPrest()
 {
	 for(int i=1; i<6; i++)
	 {
		 String Xpath = "//input[@id='text"+i+"']";
		 boolean iselementPresent = driver.findElements(By.xpath(Xpath)).size()!=0;
		 if(iselementPresent == true)
		 {
			 System.out.println("\nTargeted TextBox"+i+" Is Present On The Page");
		 }
		 else
		 {
			 System.out.println("\nTargeted Text Box"+i+" Is Not Present On The Page");
		 }
	 }
 }
 @Test
 public void testElementDisplayed() {
	 
	 WebElement e = driver.findElement(By.xpath("//*[@id=\"text2\"]"));
	 if(e.isDisplayed())
	 {
		 System.out.println("Text box is Displayed");
	 }
	 else
	 {
		 System.out.println("Text box is not Displayed");
	 }
 }
 
 @Test
 public void testElementEnabled() {
	 WebElement e = driver.findElement(By.xpath("//*[@id=\"text2\"]"));
	 if(e.isEnabled())
	 {
		 System.out.println("Text box is Enabled");
	 }
	 else
	 {
		 System.out.println("Text box is not Enabled");
	 }
 }
	 
	 @Test
	 public void testSelected() {
		 WebElement e = driver.findElement(By.xpath("//*[@id=\"text2\"]"));
		 if(e.isSelected())
		 {
			 System.out.println("Text box is Selected");
		 }
		 else
		 {
			 System.out.println("Text box is not Selected");
		 }
	 
 }
 
}

