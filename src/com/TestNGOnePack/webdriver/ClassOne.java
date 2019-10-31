package com.TestNGOnePack.webdriver;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ClassOne extends com.TestNGOnePack.webdriver.BaseClassOne {

	@Test
	public void testmethodone() {
		String title = driver.getTitle();
		System.out.println("\nCurrent page title is : "+title);
		String workdir  = System.getProperty("user.dir");
		String Classpackname = this.getClass().getName();
		System.out.println("\n'"+workdir+" ->"+Classpackname+"-> testmethodone' has been executed successfully");
	}
	
	//Add testmethodtwo() here
	 @Test
	 public void testmethodtwo() {
	     driver.findElement(By.xpath("//input[@value='female']"));
	     String Workdir = System.getProperty("user.dir");
	     String Classpackname = this.getClass().getName();
	     System.out.print("\n'"+Workdir+" -> "+Classpackname+" -> testmethodtwo' has been executed successfully");
	  }
}
