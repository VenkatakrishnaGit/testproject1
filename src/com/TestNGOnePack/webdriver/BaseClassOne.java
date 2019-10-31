package com.TestNGOnePack.webdriver;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClassOne {
	
	
	//Declared as public static to use same webdriver instance publicly
	public static WebDriver driver = null;
	
	@BeforeSuite
	public void setup() throws Exception { 
		  Logger log = Logger.getLogger("devpinoyLogger");
		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  log.info("Firefox browser Instance is Opend");
		  
		 //diver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		  log.info("Implicitly wait is applied to the Script");
		  driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
		  log.info("Application is Launched");
   } 
	
	
	//@AfterSuite annotation describes this method has to run after execution of all suites
    @AfterSuite
         public void tearDown() throws Exception { 
         driver.quit(); 
	}
    
    
	

}
