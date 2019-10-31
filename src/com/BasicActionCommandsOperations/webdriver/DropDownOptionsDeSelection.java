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


public class DropDownOptionsDeSelection {
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
 public void test () throws InterruptedException 
 {  
  driver.findElement(By.id("text1")).sendKeys("My First Name");

  Select listbox = new Select(driver.findElement(By.xpath("//select[@name='FromLB']")));
  listbox.selectByVisibleText("USA");
  listbox.selectByVisibleText("Russia");
  Thread.sleep(1000);
  
//To deselect by visible text
  listbox.deselectByVisibleText("Russia");
  Thread.sleep(1000);
  
  listbox.selectByValue("Japan");
  listbox.selectByValue("Mexico");
  Thread.sleep(1000);
  
//To deselect by value
  listbox.deselectByValue("Mexico");
  Thread.sleep(1000);
  
  listbox.selectByIndex(4);
  listbox.selectByIndex(5);
  Thread.sleep(1000);
  
//To deselect by index
  listbox.deselectByIndex(5);
  Thread.sleep(1000);

  driver.findElement(By.xpath("//input[@value='->']")).click();
  Thread.sleep(1000);
 }   
}