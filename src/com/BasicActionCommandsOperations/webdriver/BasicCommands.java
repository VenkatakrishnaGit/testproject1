package com.BasicActionCommandsOperations.webdriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasicCommands { 
 
 WebDriver driver = null;
 
 @Before
 public void beforetest() {

  // set geckodriver path.
 System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
 //To open Firefox browser
 driver = new FirefoxDriver();

 //To Maximize Browser Window
 // driver.manage().window().maximize();

 //To Open URL In browser
  driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
  
  //Get page title in selenium webdriver
  String pageTitle = driver.getTitle();
  System.out.println("The Title of the WebPage : "+pageTitle);
  
  //Get Current Page URL In Selenium WebDriver
  String CPURL = driver.getCurrentUrl();
  System.out.println("The Current Page URL is : "+CPURL);
  
  //Get Page source
  String pageSource = driver.getPageSource();
  //System.out.println("The Page Source : "+pageSource);
  
  //Get Current Window
  String gwh = driver.getWindowHandle();
  System.out.println("The Current Window : "+gwh);
  
  
  
 }
 
 @After
 public void aftertest() {
  //driver.quit();
  
 }
 
 @Test
 public void test() throws Exception 
  {
   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
 //Locating element by className and store its text to variable datentime
   String  datentime = driver.findElement(By.className("date-header")).getText();
   
   
   
   //To check the Element is Enabled or not
   boolean elementEnable = driver.findElement(By.name("fname")).isEnabled();
   
   if(elementEnable == true) {
   System.out.println("Element is Enabled: "+elementEnable);
   }
   else{
	   System.out.println("Element is not Enabled");
   }
   //To check the Element is Displayed or Not
   boolean elementDisabled = driver.findElement(By.name("fname")).isDisplayed();
   System.out.println("Element is Displayed: "+elementDisabled);
   
   //To check the Element is Selected or Not
   boolean elementSelected = driver.findElement(By.name("fname")).isSelected();
   System.out.println("Element is Selected: "+elementSelected);
   
   
   
   String CurrentURL = driver.getCurrentUrl();
   System.out.println("My Current URL Is  : "+CurrentURL);
   
   //Get and store domain name in variable
   JavascriptExecutor javascript = (JavascriptExecutor) driver;
   String DomainUsingJS=(String)javascript.executeScript("return document.domain");  
   System.out.println("My Current URL Domain Name Is  : "+DomainUsingJS);
   
   //Generating Alert Using Javascript Executor
   JavascriptExecutor js = (JavascriptExecutor)driver;
   js.executeScript("alert('Test Execution is started now....');");
   Thread.sleep(5000);
   //To click on OK button in Popup
   driver.switchTo().alert().accept();
   
   
  
   
   
   System.out.print(datentime);
  }
}
