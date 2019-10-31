package com.BasicActionCommandsOperations.webdriver;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ExtractingAllTextFields {
 WebDriver driver;
 
 @Before
 public void StartBrowser() {
  System.setProperty("webdriver.gecko.driver","C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
  driver = new FirefoxDriver();
 }
 
 @After
 public void tearDown() {
	 driver.close();
 }
 
 @Test
 public void testExtractAllTextFeilds() throws Exception {
	 try {
	 driver.get("http://only-testing-blog.blogspot.in/2014/05/login.html");
	 //find all input fields where type = text or password and store them In array list txtfields.
	 List <WebElement> tb = driver.findElements(By.xpath("//input[@type='text' or @type='password']"));
	  //for loop to send text In all text box one by one
	 for(int i = 0; i<=tb.size(); i++) {
		 tb.get(i).sendKeys("Text"+(i+1));
	 }
	 Thread.sleep(4000);
 }
	 catch(Exception e) {
		 System.out.println("error "+e);
	 }
		 
	 }
 
 
}