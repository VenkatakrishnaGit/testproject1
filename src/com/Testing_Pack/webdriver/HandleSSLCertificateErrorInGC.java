package com.Testing_Pack.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HandleSSLCertificateErrorInGC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Set chrome browser's capabilities to to accept SSL certificate on runtime.
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver(cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Enter the URL of site where you facing SSL error.
		driver.get("Site URL");

	}

}
