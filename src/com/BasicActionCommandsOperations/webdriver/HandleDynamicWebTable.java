package com.BasicActionCommandsOperations.webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleDynamicWebTable {
 WebDriver driver = null;

 @Before
 public void setup() throws Exception {
  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
  driver = new FirefoxDriver();
  //driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  driver.get("http://only-testing-blog.blogspot.in/2014/05/form.html");
 }

 @After
 public void tearDown() throws Exception {
 // driver.quit();
 }
 
 @Test
 public void testHandleDynamicWebTable() {
	 
	 //To locate table.
	 WebElement myTable = driver.findElement(By.xpath(".//*[@id='post-body-8228718889842861683']/div[1]/table/tbody"));
	//To locate rows of table.
	 List<WebElement> rows_table = driver.findElements(By.tagName("tr"));
	  //To calculate no of rows In table.
	 int row_count = rows_table.size();
	 
	 //Loop will execute till the last row of table.
	 for(int row = 0; row<row_count; row++)
	 {
		//To locate columns(cells) of that specific row.
		 List<WebElement> columns_row =rows_table.get(row).findElements(By.tagName("td"));
		//To calculate no of columns(cells) In that specific row.
		 int columns_count = columns_row.size();
		 System.out.println("Number of cells In Row "+row+" are "+columns_count);
		 
		 //Loop will execute till the last cell of that specific row.
		 for(int column = 0; column<columns_count; column++)
		 {
			//To retrieve text from that specific cell
			 String celtext = columns_row.get(column).getText();
			 System.out.println("Cell Value Of row number "+row+" and column number "+column+" Is "+celtext);
			 
		 }
		 
		 System.out.println("----------------------------------");
		 
		 
	 }
	 
 }
}