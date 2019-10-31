package com.SeleniumWebDriverAdvancedTutorials.webdriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteSpecificOrAllCookies {
	
	DeleteSpecificOrAllCookiesData data = new DeleteSpecificOrAllCookiesData();

	@BeforeTest
	 public void setup() throws Exception {
		 System.setProperty(Messages.getString("DeleteSpecificOrAllCookies.0"), Messages.getString("DeleteSpecificOrAllCookies.1")); //$NON-NLS-1$ //$NON-NLS-2$
	  data.driver = new FirefoxDriver();
	 // driver.manage().window().maximize();
	  data.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  data.driver.get(Messages.getString("DeleteSpecificOrAllCookies.2")); //$NON-NLS-1$
	 }
	 
	 public WebDriver getDriver() {
		return data.driver;
	}

	public void setDriver(WebDriver driver) {
		this.data.driver = driver;
	}

	@Test
	 public void deleteCookie(){
	  
	  //Add 2 test cookies for your domain.
	  Cookie cookie1 = new Cookie(Messages.getString("DeleteSpecificOrAllCookies.3"), Messages.getString("DeleteSpecificOrAllCookies.4")); //$NON-NLS-1$ //$NON-NLS-2$
	  Cookie cookie2 = new Cookie(Messages.getString("DeleteSpecificOrAllCookies.5"), Messages.getString("DeleteSpecificOrAllCookies.6")); //$NON-NLS-1$ //$NON-NLS-2$
	  data.driver.manage().addCookie(cookie1);
	  data.driver.manage().addCookie(cookie2);
	  
	  //Get and print all cookies for google domain after adding cookies manually.
	  Set<Cookie> totalCookies1 = data.driver.manage().getCookies();
	  System.out.println(Messages.getString("DeleteSpecificOrAllCookies.7") +totalCookies1.size()); //$NON-NLS-1$
	  
	  for (Cookie currentCookie : totalCookies1) {
	      System.out.println(String.format(Messages.getString("DeleteSpecificOrAllCookies.8"), Messages.getString("DeleteSpecificOrAllCookies.9")+currentCookie.getDomain(), Messages.getString("DeleteSpecificOrAllCookies.10")+currentCookie.getName(), Messages.getString("DeleteSpecificOrAllCookies.11")+currentCookie.getValue())); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	  }
	  
	  //Deleting specific testCookie2 cookie.
	  System.out.println();
	  data.driver.manage().deleteCookieNamed(Messages.getString("DeleteSpecificOrAllCookies.12")); //$NON-NLS-1$
	  
	  //Get and print all cookies for google domain after deleting cookie manually.
	  Set<Cookie> totalCookies2 = data.driver.manage().getCookies();
	  System.out.println(Messages.getString("DeleteSpecificOrAllCookies.13") +totalCookies2.size()); //$NON-NLS-1$
	  
	  for (Cookie currentCookie : totalCookies2) {
	      System.out.println(String.format(Messages.getString("DeleteSpecificOrAllCookies.14"), Messages.getString("DeleteSpecificOrAllCookies.15")+currentCookie.getDomain(), Messages.getString("DeleteSpecificOrAllCookies.16")+currentCookie.getName(), Messages.getString("DeleteSpecificOrAllCookies.17")+currentCookie.getValue())); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	  } 
	  
	  //Deleting all cookies.
	  System.out.println();
	  data.driver.manage().deleteAllCookies();
	  
	  //Print number of cookies after deleting all cookies.
	  Set<Cookie> totalCookies3 = data.driver.manage().getCookies();
	  System.out.println(Messages.getString("DeleteSpecificOrAllCookies.18") +totalCookies3.size()); //$NON-NLS-1$
	 }

	public void close() {
		data.driver.close();
	}

	public WebElement findElement(By arg0) {
		return data.driver.findElement(arg0);
	}

	public List<WebElement> findElements(By arg0) {
		return data.driver.findElements(arg0);
	}

	public void get(String arg0) {
		data.driver.get(arg0);
	}

	public String getCurrentUrl() {
		return data.driver.getCurrentUrl();
	}

	public String getPageSource() {
		return data.driver.getPageSource();
	}

	public String getTitle() {
		return data.driver.getTitle();
	}

	public String getWindowHandle() {
		return data.driver.getWindowHandle();
	}

	public Set<String> getWindowHandles() {
		return data.driver.getWindowHandles();
	}

	public Options manage() {
		return data.driver.manage();
	}

	public Navigation navigate() {
		return data.driver.navigate();
	}

	public void quit() {
		data.driver.quit();
	}

	public TargetLocator switchTo() {
		return data.driver.switchTo();
	}

}
