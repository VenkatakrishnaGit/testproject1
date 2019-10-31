package com.AutoIT.webdriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileDownloadbyAutoIT {
 WebDriver driver;
 
 @BeforeTest
 public void setup() throws Exception {
  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
  driver =new FirefoxDriver();     
 // driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.get("http://only-testing-blog.blogspot.in/2014/05/login.html");
 }
 
 @Test
 public void testDownloadFilebyAutoIT() throws Exception {
	 
	//Click on Download Text File link to download file.
	 driver.findElement(By.xpath("//a[contains(.,'Download Text File')]")).click();
	//Execute Script To Download File.exe file to run AutoIt script. File location C:\Users\VenkatakrishnaY\Downloads\AutoIT Softwares location.
	 Runtime.getRuntime().exec("C:\\Users\\VenkatakrishnaY\\Downloads\\AutoIT Softwares\\Script To Download File.exe");
	 
 }
 
 @AfterTest
 public void tearDown() {
	 driver.quit();
}
}
