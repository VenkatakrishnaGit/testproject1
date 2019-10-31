package com.BasicActionCommandsOperations.webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class CreateAndUseCustomFirefoxProfile {
	
	WebDriver driver;
	
	@Before
	public void setUp() {
		//Create object of webdriver's inbuilt class ProfilesIni to access Its method getProfile.
		ProfilesIni fp = new ProfilesIni();
		 //Get access of newly created profile WebDriver_Profile.
		FirefoxProfile wbdrverprofile  = fp.getProfile("WebDriver_Profile");
		
		//Pass wbdrverprofile parameter to FirefoxDriver.
		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		  driver = new FirefoxDriver(wbdrverprofile);  
		
	}
	
	@Test
	 public void OpenURL(){
	  driver.get("http://only-testing-blog.blogspot.in/2014/05/login.html");  
	 }
	 
	 @After
	 public void CloseBrowser() {
	  driver.quit();  
	 }
	}


