package com.Junitpack.webdriver;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class junittest2 {
	 WebDriver driver = null;
	
	@Before
	public  void setUP() {
		System.out.print("\nBrowser open");
		// set geckodriver path.
		// System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		 //initialize firefox driver.
		// driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\chromedriver_win32\\chromedriver.exe");
		driver  = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
		
	}
	
	@After
	public  void tearDown() {
		System.out.print("\nBrowser close");
		driver.quit();
		
	}
	//@Ignore
	@Test(timeout=2000)
	public void test1() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("junittest2 class-test1");
		 System.out.print("\njunittest2 class-test1 method is executed");
		 Thread.sleep(2000);
		
	}
	
	@Test
	public void test2() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("junittest2 class-test2");
		 Thread.sleep(2000);
		 System.out.print("\njunittest2 class-test2 method is executed");
	}

}
