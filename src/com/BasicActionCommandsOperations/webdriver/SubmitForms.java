package com.BasicActionCommandsOperations.webdriver;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SubmitForms {
 
WebDriver driver = null;
 
 
  @Before
  public void setup() throws Exception {
	  Logger log = Logger.getLogger("devpinoyLogger");
  // set geckodriver path.
  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
  //initialize firefox driver.
  driver = new FirefoxDriver();
   log.info("Firefox browser Instance is opend");
        // driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
         log.info("Implicitly wait is Applied to the Script");
         driver.get("http://only-testing-blog.blogspot.in/2014/05/form.html"); 
         log.info("Application is launched");
  } 
 
  @After
  public void tearDown() throws Exception { 
	  Logger log = Logger.getLogger("devpinoyLogger");
       driver.quit();
       log.debug("Browser Instance is Closed");
     } 
  
  @Test
  public void LogIn_Test(){
	Logger log = Logger.getLogger("devpinoyLogger");
   driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("MyFName");
   log.debug("First name is Entered");
   driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("MyLName");
   log.debug("Last name is Entered");
   driver.findElement(By.xpath("//input[@name='EmailID']")).sendKeys("My Email ID");
   log.debug("Email is Entered");
   driver.findElement(By.xpath("//input[@name='MobNo']")).sendKeys("My Mob No.");
   log.debug("Mobile Number is Entered");
   driver.findElement(By.xpath("//input[@name='Company']")).sendKeys("My Comp Name");
   log.debug("Company name is Entered");
   //To submit form.
   //You can use any other Input field's(First Name, Last Name etc.) xpath too In bellow given syntax.
   driver.findElement(By.xpath("//input[@name='Company']")).submit();
   log.debug("Form is submitted");
   String alrt = driver.switchTo().alert().getText();
   log.debug("Alert text is Printed");
   driver.switchTo().alert().accept();
   log.debug("Clicked on OK button in Alert");
   System.out.println(alrt);
   
  }
}