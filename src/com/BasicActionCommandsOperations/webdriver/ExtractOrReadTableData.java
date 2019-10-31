package com.BasicActionCommandsOperations.webdriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExtractOrReadTableData { 
 
 WebDriver driver = null;
 @Before
    public void setup() throws Exception { 
         System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
         driver = new FirefoxDriver();
         //driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
         driver.get("http://only-testing-blog.blogspot.in/2013/09/test.html"); 
    } 
 
  @After
 public void tearDown() throws Exception { 
   driver.quit();
     } 
  
  @Test
  public void testExtractOrReadTable() {
	  
	  //Get num of row in a Table
	  int Row_Count = driver.findElements(By.xpath("//*[@id='post-body-6522850981930750493']/div[1]/table/tbody/tr")).size();
	  System.out.println("No of Rows:"+Row_Count);
	  
	  //Get num of Columns in a Table
	  int Column_count = driver.findElements(By.xpath("//*[@id='post-body-6522850981930750493']/div[1]/table/tbody/tr[1]/td")).size();
	  System.out.println("No of Columns:"+Column_count);
	  
	 /*  //divided xpath In three parts to pass Row_count and Col_count values.
	  String firstPart = "//*[@id='post-body-6522850981930750493']/div[1]/table/tbody/tr[";
	  String secondPart = "]/td[";
	  String thirdPart = "]"; 
	  
	  //Used for loop for no of rows
	  for(int i = 1; i<=Row_Count; i++)
	  {
		//Used for loop for number of columns.
		  for(int j = 1; j<=Column_count; j++ )
		  {
			  
			 // String finalXpath = "//*[@id='post-body-6522850981930750493']/div[1]/table/tbody/tr[i]/td[j]";
			//Prepared final xpath of specific cell as per values of i and j.
			  String finalXpath = firstPart+i+secondPart+j+thirdPart;
			  //Will retrieve value from located cell and print It.
			  String Table_Data = driver.findElement(By.xpath("finalXpath")).getText();
			  System.out.println(Table_Data +"  ");  */
	  
	 //divided xpath In three parts to pass Row_count and Col_count values.
	  String first_part = "//*[@id='post-body-6522850981930750493']/div[1]/table/tbody/tr[";
	  String second_part = "]/td[";
	  String third_part = "]";
	  
	  //Used for loop for number of rows.
	  for (int i=1; i<=Row_Count; i++){
	   //Used for loop for number of columns.
	   for(int j=1; j<=Column_count; j++){
	    //Prepared final xpath of specific cell as per values of i and j.
	    String final_xpath = first_part+i+second_part+j+third_part;
	    //Will retrieve value from located cell and print It.
	    String Table_data = driver.findElement(By.xpath(final_xpath)).getText();
	    System.out.print(Table_data +"  ");    
			  
		  }
		  
		  System.out.println("");
		  System.out.println("");
	  }
	
	  
  }
}
  
