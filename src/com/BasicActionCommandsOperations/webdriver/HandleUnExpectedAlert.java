package com.BasicActionCommandsOperations.webdriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class HandleUnExpectedAlert {
 WebDriver driver = null;

 @Before
 public void setup() throws Exception {
  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
  driver = new FirefoxDriver();
  //driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  driver.get("http://only-testing-blog.blogspot.in/2014/06/alert_6.html");
 }

 @After
 public void tearDown() throws Exception {
  //driver.quit();
 }

 @Test
 public void Text() throws InterruptedException {
  //To handle unexpected alert on page load.
  try{   
   driver.switchTo().alert().dismiss();  
  }catch(Exception e){ 
   System.out.println("unexpected alert not present");   
  }
  
  driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("fname");
  driver.findElement(By.xpath("//input[@name='lname']")).sendKeys("lname");
  driver.findElement(By.xpath("//input[@type='submit']")).click();
 }
}
