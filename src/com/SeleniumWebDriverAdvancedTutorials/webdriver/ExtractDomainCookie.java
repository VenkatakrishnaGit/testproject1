package com.SeleniumWebDriverAdvancedTutorials.webdriver;


	
	import java.util.Set;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.Cookie;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class ExtractDomainCookie {
	 WebDriver driver;
	 
	 @BeforeTest
	 public void setup() throws Exception {
		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
	  driver = new FirefoxDriver();
	 // driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.get("http://www.google.com");
	 }
	 
	 @Test
	 public void testExtractDomainCookie() {
		//Get and extract all cookies of google domain and print cookie parameters. 
		 Set <Cookie> totalCookies  = driver.manage().getCookies();
		 System.out.println("Total no of Cookies : "+totalCookies.size());
		 
		 for(Cookie currentCookie : totalCookies) {
			 System.out.println(String.format("%s -> %s -> %s -> %s", "Domain Name : "+currentCookie.getDomain(), "Cookie Name : "+currentCookie.getName(), "Cookie Value : "+currentCookie.getValue(), "Cookie Expiry : "+currentCookie.getExpiry()));
		 }
		 
		 
	 }

}
