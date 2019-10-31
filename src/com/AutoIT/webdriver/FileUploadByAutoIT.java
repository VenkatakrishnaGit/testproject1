package com.AutoIT.webdriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUploadByAutoIT {
 WebDriver driver;
 
 @BeforeTest
 public void setup() throws Exception {
  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
  driver =new FirefoxDriver();     
 // driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
 }
 
 @Test
 public void testUploadFilebyAutoIT() throws Exception {
	 //Click on the browse button
	 driver.findElement(By.name("img")).click(); 
	//To execute autoIt script .exe file which Is located at C:\Users\VenkatakrishnaY\Downloads\AutoIT Softwares location.
	 Runtime.getRuntime().exec("C:\\Users\\VenkatakrishnaY\\Downloads\\AutoIT Softwares\\Script To Upload File.exe");
 }
 
 @AfterTest
 public void tearDown() {
	 driver.quit();
}
}