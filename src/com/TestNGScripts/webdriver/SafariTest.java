package com.TestNGScripts.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new SafariDriver();
		driver.get("https://www.google.co.in/#spf=1569585504090");
		
	}

}
