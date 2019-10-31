package com.BasicActionCommandsOperations.webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GetOrExtractAllLinksFromWebPage {
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
 public void testExtractAllLinks() {
	 try {
		List <WebElement> no = driver.findElements(By.tagName("a"));
		int noOflinks = no.size();
		System.out.println(noOflinks);
		for(WebElement pageLinks : no) {
			String linksText = pageLinks.getText();
			String link = pageLinks.getAttribute("value");
			
			System.out.println(linksText+" ->");
			System.out.println(link);
		}
	 }catch(Exception e){
		 System.out.println("error "+e);
	 }
		 
	 
 
 }
}
