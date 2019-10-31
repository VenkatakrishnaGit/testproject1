package com.SeleniumWebDriverTipsAndTricks.webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ZoomInAndZoomOutPage {
 WebDriver driver;
 
 @BeforeTest
 public void setup() throws Exception {
	 System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
  driver = new FirefoxDriver();
  //driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.get("http://google.com/"); 
 }
 
 @Test
 public void getScrollStatus() throws InterruptedException {
	//Call zooming functions to zoom in and out page.
	 zoomIn();
	 zoomOut();
	 zoomOut();
	 set100();
	 
 }
 public void zoomIn() throws InterruptedException {
	 for(int i = 0; i<4; i++) {
		 driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
	 }
	 Thread.sleep(5000);
 }
	 
 
 public void zoomOut() throws InterruptedException {
	 driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT)); 
	 Thread.sleep(5000);
 }
 
 
 public void set100() {
	 driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0")); 
 }
}
