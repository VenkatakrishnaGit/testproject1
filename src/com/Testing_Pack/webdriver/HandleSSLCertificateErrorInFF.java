package com.Testing_Pack.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class HandleSSLCertificateErrorInFF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//to handle SSL sertificate in FF browser we need to create the Firefox Custom profile for that manually
		
		//Access firefox browser profile "certificateIssue" to use It In test.
		ProfilesIni f = new ProfilesIni();
		
		FirefoxProfile fp = f.getProfile("certificateIssue");
		fp.setAcceptUntrustedCertificates(true);
		fp.setAssumeUntrustedCertificateIssuer(false);
		
		WebDriver driver = new FirefoxDriver(fp);
		driver.get("site URL where certificate error");
		

	}

}
