package com.AdvancedTestNG.webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGexpectedExceptionsAttribute { 
 
 WebDriver driver; 

 @BeforeTest
 public void setup() throws Exception {
  System.out.println("In @BeforeTest Of Test_One.");
  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
  driver =new FirefoxDriver();     
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.get("http://only-testing-blog.blogspot.in/2014/04/calc.html");
 }
 
 @Test(expectedExceptions = NoSuchElementException.class)
 public void testCaseOne_Test_One() {
	 System.out.println("Executing testCaseOne_Test_One.");
	  //This element Is not available on page so It will throw NoSuchElementException.
	  driver.findElement(By.xpath("//input[@id='10']")).click();
	  driver.findElement(By.xpath("//input[@id='plus']")).click();
	  driver.findElement(By.xpath("//input[@id='6']")).click();
	  driver.findElement(By.xpath("//input[@id='equals']")).click();
	  String Result = driver.findElement(By.xpath("//input[@id='Resultbox']")).getAttribute("value");
	  System.out.println("Result of testCaseOne_Test_One = "+Result);
	 
 }
}