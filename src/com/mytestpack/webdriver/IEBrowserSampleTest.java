package com.mytestpack.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;


public class IEBrowserSampleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//set path of IE driver.exe
		/**System.setProperty("webdriver.ie.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\IEDriverServer.exe");
		WebDriver driver  = new InternetExplorerDriver();**/
		
		String service = "C:\\Users\\VenkatakrishnaY\\Downloads\\IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver", service);
		WebDriver driver  = new InternetExplorerDriver();
	
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		// Load sample calc test URL.
		  driver.get("http://only-testing-blog.blogspot.com/2014/04/calc.html");
		  
		  //challenges in IE
		  
		  //The path to the driver executable must be set by the webdriver.ie.driver
		  
		  //Protected Mode settings are not the same for all zones.
		  
		  //Unexpected error Browser zoom level
		  
		  //SendKeys types character very slow when running script in IE browser
		  
		  //Untrusted SSL certificate error in IE browser
		  
		  //SendKeys types character very slow when running script in IE browser
		  
		// Execute sample calc test.
		  driver.findElement(By.xpath("//input[@id='1']")).click();
		  driver.findElement(By.xpath("//input[@id='plus']")).click();
		  driver.findElement(By.xpath("//input[@id='6']")).click();
		  driver.findElement(By.xpath("//input[@id='equals']")).click();
		  String result = driver.findElement(By.xpath("//input[@id='Resultbox']")).getAttribute("value");
		  System.out.println("Calc test result Is : " + result);
		 // driver.close();
		 

	}

}
