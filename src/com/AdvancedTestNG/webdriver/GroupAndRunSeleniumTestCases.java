package com.AdvancedTestNG.webdriver;

import org.testng.annotations.Test;

public class GroupAndRunSeleniumTestCases {
	
	//"check-mail" group test method.
	@Test(groups= {"check-mail"},priority=0)
	public void login() {
		System.out.println("Log in");
	}
	
	//Do not have any group.
	@Test
	public void viewNews() {
		System.out.println("Viewing News");
	}
	
	//"check-mail" group test method.
	@Test(groups= {"check-mail"},priority=1)
	public void checkMail() {
		System.out.println("Checking Mails");
	}
	
	//"check-mail" group test method.
	@Test(groups= {"check-mail"},priority=2)
    public void logout() {
		System.out.println("Logout");
	}
	

}
