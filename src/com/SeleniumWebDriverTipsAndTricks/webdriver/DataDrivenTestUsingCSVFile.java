package com.SeleniumWebDriverTipsAndTricks.webdriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

public class DataDrivenTestUsingCSVFile {
	String CSV_Path = "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\CSV jars\\CSV Pack\\CSV Pack\\Detail.csv";
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		  //driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  driver.get("http://only-testing-blog.blogspot.in/2014/05/form.html");
	}
   
	@Test
	public void testDataDrivenTestUsingCSVFile() throws IOException, InterruptedException {
		try {
		CSVReader r = new CSVReader(new FileReader(CSV_Path));
		String [] csvCell;
		//while loop will be executed till the last line In CSV.
		while((csvCell = r.readNext()) != null) {
			
			String FName = csvCell[0];
			String LName = csvCell[1];
			String Email = csvCell[2];
		    String Mob = csvCell[3];
		    String company = csvCell[4];
		    
		    driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys(FName);
		    driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys(LName);
		    driver.findElement(By.xpath("//input[@name='EmailID']")).sendKeys(Email);
		    driver.findElement(By.xpath("//input[@name='MobNo']")).sendKeys(Mob);
		    driver.findElement(By.xpath("//input[@name='Company']")).sendKeys(company);
		    driver.findElement(By.xpath("//input[@value='Submit']")).click();
		    
		    Thread.sleep(4000);
		    
		   Alert al =  driver.switchTo().alert();
		   String alText = al.getText();
		   System.out.println(alText);
		   al.accept();
			
		}
		}
		catch(StaleElementReferenceException  e) {
			
			e.toString();
			
			 System.out.println("Trying to recover from a stale element :" + e.getMessage());
		}
			
		
	}
}


