package com.mytestpack.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class chromebrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	  /**  System.setProperty("webdriver.chrome.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		//Maximize the Browser
		driver.manage().window().maximize();**/
		
		String service = "C:\\Users\\VenkatakrishnaY\\Downloads\\IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver", service);
		WebDriver driver  = new InternetExplorerDriver();
		
		
		
		//Implicitly wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//launch the Application
		driver.get("http://www.google.com");
		if(driver.findElement(By.name("q")).isEnabled()) {
			System.out.println("Google search text box Is enabled.");
			driver.findElement(By.name("q")).sendKeys("Webdriver Test Successfull");
			WebElement e = driver.findElement(By.name("q"));
			
			//If we dont have Click or submit button while extracting data then we can press Enter/Return key on Keyboard  
			
			//e.sendKeys(Keys.RETURN);
			e.sendKeys(Keys.ENTER);
			System.out.println("Google search completed.");
		}else {
			System.out.println("Google search test box Is Not enabled.");
		}
		
		driver.close();

	}

}
