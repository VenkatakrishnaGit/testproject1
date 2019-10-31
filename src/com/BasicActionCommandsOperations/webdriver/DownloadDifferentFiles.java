package com.BasicActionCommandsOperations.webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadDifferentFiles {
	
	WebDriver driver;
	
	@Before
	public void setUp() {
		//Create object of FirefoxProfile in built class to access Its properties.
		FirefoxProfile fp = new FirefoxProfile();
		//Set Location to store files after downloading.
		fp.setPreference("browser.download.dir", "C:\\Users\\VenkatakrishnaY\\Desktop\\SeleniumScren");
		fp.setPreference("browser.download.folderList", 2);
		//Set Preference to not show file download confirmation dialogue using MIME types Of different file extension types.
		
		fp.setPreference("browser.helperApps.neverAsk.saveToDisk", 
				"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;" ////MIME types Of MS Excel File.
				+"application/pdf;" //MIME types Of PDF File
						+"application/vnd.openxmlformats-officedocument.wordprocessingml.document;" ////MIME types Of doc file
				+ "text/plain;" ////MIME types Of text file
				+ "text/csv");  ////MIME types Of CSV File
		fp.setPreference("browser.download.manager.showWhenStarting", false);
		fp.setPreference("pdfjs.disabled", true);
		
		//Pass fp parameter In webdriver to use preferences to download file.
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		  driver = new FirefoxDriver(fp); 
		  
}
	
	@Test
	public void doenloadfiles() throws Exception {
		driver.get("http://only-testing-blog.blogspot.in/2014/05/login.html");
		  //Download Text File
		  driver.findElement(By.xpath("//a[contains(.,'Download Text File')]")).click();
		  Thread.sleep(5000);//To wait till file gets downloaded.
		                //Download PDF File
		  driver.findElement(By.xpath("//a[contains(.,'Download PDF File')]")).click();
		  Thread.sleep(5000);
		                //Download CSV File
		  driver.findElement(By.xpath("//a[contains(.,'Download CSV File')]")).click();
		  Thread.sleep(5000);
		                //Download Excel File
		  driver.findElement(By.xpath("//a[contains(.,'Download Excel File')]")).click();
		  Thread.sleep(5000);
		                //Download Doc File
		  driver.findElement(By.xpath("//a[contains(.,'Download Doc File')]")).click();
		  Thread.sleep(5000);  
		 }
		 
		 @After
		 public void CloseBrowser() {  
		  driver.quit();  
		 }
		

	}


