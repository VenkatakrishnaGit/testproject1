package com.AdvancedTestNG.webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGTimeoutTest {
 
 WebDriver driver; 

 @BeforeTest
 public void setup() throws Exception {
  System.out.println("In @BeforeTest Of Test_One.");
  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
  driver =new FirefoxDriver();     
  //driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.get("http://only-testing-blog.blogspot.in/2014/04/calc.html");
 }
 
 @Test
 public void timeoutTestOne() throws InterruptedException {
  System.out.println("Executing timeoutTestOne.");
  //Wait for 5 seconds.
  Thread.sleep(5000);
  driver.findElement(By.xpath("//input[@id='2']")).click();
  driver.findElement(By.xpath("//input[@id='plus']")).click();
  driver.findElement(By.xpath("//input[@id='6']")).click();
  driver.findElement(By.xpath("//input[@id='equals']")).click();
  String Result = driver.findElement(By.xpath("//input[@id='Resultbox']")).getAttribute("value");
  System.out.println("Result of timeoutTestOne = "+Result);
 }
 
 @Test
 public void timeoutTestTwo() throws InterruptedException {
  System.out.println("Executing timeoutTestTwo.");
  //Wait for 1 second.
  Thread.sleep(1000);
  driver.findElement(By.xpath("//input[@id='Resultbox']")).clear();
  driver.findElement(By.xpath("//input[@id='3']")).click();
  driver.findElement(By.xpath("//input[@id='plus']")).click();
  driver.findElement(By.xpath("//input[@id='7']")).click();
  driver.findElement(By.xpath("//input[@id='equals']")).click();
  String Result = driver.findElement(By.xpath("//input[@id='Resultbox']")).getAttribute("value");
  System.out.println("Result of timeoutTestTwo = "+Result);
 }
 
 @AfterTest
 public void tearDown() {
	 driver.quit();
 }
}
