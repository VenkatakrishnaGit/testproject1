package com.TestNGScripts.webdriver;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTestsExecution {
	private WebDriver driver = null;
	
	@BeforeClass
	//parameter value will retrieved from testng.xml file's <parameter> tag.
	@Parameters({"browser"})
	public void setUp(String browser) { ////Method will pass value of parameter.
		if(browser.equals("FFX")) {
			System.out.println("Test Starts Running In Firefox Browser.");
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();   
		}else if(browser.equals("CRM")) {////If value Is CRM then webdriver will open chrome Browser.
			System.out.println("Test Starts Running In Google chrome.");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\chromedriver_win32\\chromedriver.exe");
			driver  = new ChromeDriver();
			}else if(browser.equals("IE")) {//If value Is IE then webdriver will open IE Browser.
				System.out.println("Test Starts Running in InternetExplorer Browser.");
				String service = "C:\\Users\\VenkatakrishnaY\\Downloads\\IEDriverServer.exe";
				System.setProperty("webdriver.ie.driver", service);
				driver = new InternetExplorerDriver();
			}else if(browser.equals("SF")) {
				System.out.println("Test Starts Running in Safari Browser.");
				//System.setProperty("webdrver.safari.driver", "");
				driver = new SafariDriver();
			}
		
		driver.manage().window().maximize();
		 driver.get("http://only-testing-blog.blogspot.in/2014/05/login.html"); 
		
	}
	
	
	@Test
	public void verify_Title() {
		String title = driver.getTitle();
		Assert.assertEquals("Only Testing: LogIn",title);
		System.out.println("Title is Fine");
	}
	
	@Test
	public void verify_Message() {
		driver.findElement(By.xpath("//input[@name='userid']")).sendKeys("UID1");
		  driver.findElement(By.xpath("//input[@type='password']")).sendKeys("pass1");
		  driver.findElement(By.xpath("//input[@value='Login']")).click();
		  String alert = driver.switchTo().alert().getText();
		  driver.switchTo().alert().accept();
		  Assert.assertEquals("UserId Is : UID1  Password Is : pass1", alert);
		  System.out.println("Alert is fine");
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
