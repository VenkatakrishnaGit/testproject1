package com.SeleniumWebDriverTipsAndTricks.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScrollDownAndUpWebPageUsingJE {
	WebDriver driver;
	 @BeforeTest
	 public void setup() throws Exception {
		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
	  driver =new FirefoxDriver();     
	 // driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://only-testing-blog.blogspot.in");
	 }
	 
	 @Test(priority=1)
	 public void Scroll_Page() throws InterruptedException {
		//To scroll down web page by 600 pixels In x(vertical) direction.  
		  //You can y parameter to scroll page In horizontal direction.
		 JavascriptExecutor js  = (JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0, 1600)", "");
		 
		 Thread.sleep(3000);
		  
		  //To scroll up web page by 300 pixels In x(vertical) direction.
		  js.executeScript("window.scrollBy(0,-300)", "");
	 }
	 
	 @Test(priority=2)
	 public void ScrollDownToBottomOfPage() {
		//Scroll down to bottom of the page
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
	 }
	 
	 @Test(priority=3)
	 public void Scrolltoelement() {
		 
		//Scroll till element
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 WebElement e = driver.findElement(By.xpath("//div[@id='dragdiv']"));
		 js.executeScript("arguments[0].scrollIntoView(true);", "element");
	 }

}
