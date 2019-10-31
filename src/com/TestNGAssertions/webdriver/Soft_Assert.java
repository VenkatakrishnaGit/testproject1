package com.TestNGAssertions.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Soft_Assert {
	
	//Created object of testng SoftAssert class to use It's Properties.
	SoftAssert sa = new SoftAssert();
	String ActualText;
	WebDriver driver = null;
	
	@BeforeClass
	public void setUp() {
	
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		  driver = new FirefoxDriver();
		 //driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		
	}
	
	@Test
	//In this method, If any assertion fails then execution will be aborted.
	public void  hard_assert_text() {
		
		ActualText = driver.findElement(By.xpath("//h2/span")).getText();
		//Text on expected side Is written Incorrect intentionally to get fail this assertion.
		Assert.assertEquals(ActualText, "Tuesday, 01 January 2014", "1st assert failed.");
		   System.out.println("Hard Assertion -> 1st pagetext assertion executed.");
		   
		   Assert.assertEquals(ActualText, "Tuesday, 28 January 2014", "2nd assert failed.");
		   System.out.println("Hard Assertion -> 2nd pagetext assertion executed.");   
		   
		   driver.findElement(By.xpath("//input[@value='Show Me Alert']")).click();
		   String Alert_text = driver.switchTo().alert().getText();
		   driver.switchTo().alert().accept();
		   
		   Assert.assertEquals(Alert_text, "Hi.. is alert message!", "Alert Is InCorrect");
		   System.out.println("Hard Assertion -> 1st alert assertion executed.");
		   
		   Assert.assertEquals(Alert_text, "Hi.. This is alert message!", "Alert Is Correct");
		   System.out.println("Hard Assertion -> 2nd alert assertion executed.");   
	}
	
	@Test
	 //In this method, Test execution will not abort even If any assertion fail. Full Test will be executed.
	public void soft_assert_text() {
		 ActualText = driver.findElement(By.xpath("//h2/span")).getText();
		//Text on expected side Is written Incorrect intentionally to get fail this assertion.
		 sa.assertEquals(ActualText, "Tuesday, 01 January 2014", "1st assert failed.");
		   System.out.println("Soft Assertion -> 1st pagetext assertion executed.");
		   
		   sa.assertEquals(ActualText, "Tuesday, 28 January 2014", "2nd assert failed.");
		   System.out.println("Soft Assertion -> 2nd pagetext assertion executed."); 
		   
		   driver.findElement(By.xpath("//input[@value='Show Me Alert']")).click();
		   String Alert_text = driver.switchTo().alert().getText();
		   driver.switchTo().alert().accept();
		   
		 //Alert expected text Is written Incorrect intentionally to get fail this assertion.
		   sa.assertEquals(Alert_text, "Hi.. is alert message!", "Alert Is InCorrect");
		   System.out.println("Soft Assertion -> 1st alert assertion executed.");
		   
		   sa.assertEquals(Alert_text, "Hi.. This is alert message!", "Alert Is Correct");
		   System.out.println("Soft Assertion -> 2nd alert assertion executed.");
		   
		   sa.assertAll();
		   
		   
		 }
	
	@Test
	public void wait_and_click()
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='submitButton']")));
		   driver.findElement(By.xpath("//input[@id='submitButton']")).click();	
	}
	
	
}
