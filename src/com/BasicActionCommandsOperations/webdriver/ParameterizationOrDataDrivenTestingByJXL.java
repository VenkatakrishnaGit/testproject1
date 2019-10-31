package com.BasicActionCommandsOperations.webdriver;


import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ParameterizationOrDataDrivenTestingByJXL {
 WebDriver driver = null;
 
 @Before
 public void beforetest() {
  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
  driver = new FirefoxDriver();
 // driver.manage().window().maximize();
  driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
 }
 
 @After
 public void aftertest() {
  driver.quit();
  
  
 }
 
 @Test
 public void testParameterizationByJXL() throws IOException, BiffException, InterruptedException {
	//Open MyDataSheet.xls file from given location. 
	 FileInputStream fis = new FileInputStream("C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\MyDataSheet.xls");
	//Access first data sheet. getSheet(0) describes first sheet.
	 Workbook wb = Workbook.getWorkbook(fis);
	 Sheet s = wb.getSheet(0);
	 
	 //Read data from the first data sheet of xls file and store it in array.
	 String testData[][] = new String[s.getRows()][s.getColumns()];
	 
	//To enable Last Name text box.
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 String toEnable = "document.getElementsByName('lname')[0].removeAttribute('disabled');";
	 js.executeScript(toEnable);
	 
	//Type data in first name and last name text box from array.
	 
	 for(int i=0;i<s.getRows();i++)
	  {
	   for (int j=0;j<s.getColumns();j++)
	   {
	    testData[i][j] = s.getCell(j,i).getContents();
	    if(j%2==0)
	    {
	     driver.findElement(By.xpath("//input[@name='fname']")).sendKeys(testData[i][j]);
	    }
	    else
	    {
	     driver.findElement(By.xpath("//input[@name='lname']")).sendKeys(testData[i][j]);
	    }
	   }
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//input[@name='fname']")).clear();
	   driver.findElement(By.xpath("//input[@name='lname']")).clear();
	  }
	  Thread.sleep(1000);
 }
}