package com.Testing_Pack.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class mytestclass {
	public static void main(String[] args) {
		
		//set gecko driver path
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		//Initilize firefox driver object to open firefox driver
		WebDriver driver = new FirefoxDriver();
		
		//open URL in browser
		driver.get("http://only-testing-blog.blogspot.in");
		//get the Current page URL of Application
		String i =driver.getCurrentUrl();
		System.out.println(i);
		//Close the Browser
		driver.close();
	}

}
