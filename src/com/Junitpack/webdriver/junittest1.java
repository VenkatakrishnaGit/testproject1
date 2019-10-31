package com.Junitpack.webdriver;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class junittest1 {
	
	 WebDriver driver = null;

	 @Test
	 public void test() throws InterruptedException {
	  // set geckodriver path.
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
	  //initialize firefox driver.
	  driver = new FirefoxDriver();
	 // driver.manage().window().maximize();
	  driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
	  driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("junittest1 executed");
	  Thread.sleep(2000);
	  System.out.print("junittest1 class is executed");
	  driver.quit();
	 }

}
