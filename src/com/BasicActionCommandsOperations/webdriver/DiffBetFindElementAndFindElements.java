package com.BasicActionCommandsOperations.webdriver;

import java.util.List;

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


public class DiffBetFindElementAndFindElements {
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
 public void testDiffBetFindElementOrElements() {
	WebElement option = driver.findElement(By.xpath("//option[@id='country5']"));
	System.out.println(option.getAttribute("id")+" - "+option.getText());
	
	List <WebElement> options = driver.findElements(By.xpath("//option"));
	System.out.println(options.size());
	
	for(int i =0; i<=options.size(); i++) {
		String str = options.get(i).getAttribute("id")+" - "+options.get(i).getText();
		   System.out.println(str);
	}
	
 }
}