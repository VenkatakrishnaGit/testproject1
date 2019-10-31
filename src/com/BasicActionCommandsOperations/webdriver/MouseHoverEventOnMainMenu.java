package com.BasicActionCommandsOperations.webdriver;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MouseHoverEventOnMainMenu {
 WebDriver driver = null;
 
 @Before
 public void beforetest() {
  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
  driver = new FirefoxDriver();
  //driver.manage().window().maximize();
  driver.get("http://only-testing-blog.blogspot.in/p/mouse-hover.html");
 }
 
 @After
 public void aftertest() {
 // driver.quit();
  
 }
 
 @Test
 public void testMousehour() {
	 
	//Generate mouse hover event on main menu to click on sub menu
	 Actions a  = new Actions(driver);
	 WebElement e = driver.findElement(By.xpath("//div[@id='menu1']/div"));
	 a.moveToElement(e).moveToElement(driver.findElement(By.xpath("//div[@id='menu2choices']/a"))).click().perform();
	 
	 WebDriverWait wait = new WebDriverWait(driver, 15);
	 wait.until(ExpectedConditions.titleContains("Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay"))
	 
	 ;
	 
 }
}

