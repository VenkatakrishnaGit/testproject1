package com.TestNGThreePack.webdriver;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ClassTwo extends com.TestNGOnePack.webdriver.BaseClassOne{
	
	@Test
	  public void testmethodone() {
	  driver.navigate().to("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
	  String title = driver.getTitle();
	  System.out.print("\nCurrent page title is : "+title);
	  String Workdir = System.getProperty("user.dir");
	  String Classpackname = this.getClass().getName();
	  System.out.print("\n'"+Workdir+" -> "+Classpackname+" -> testmethodone' has been executed successfully");

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
