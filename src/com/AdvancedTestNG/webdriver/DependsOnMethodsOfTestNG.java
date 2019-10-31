package com.AdvancedTestNG.webdriver;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethodsOfTestNG {
	
	//This Is Independent method so It will be executed.
	@Test(priority = 1)
	public void Login() {
		System.out.println("Login Test Code");
		//Bellow give assertion will fail to fail Login() method Intentionally.
		Assert.assertTrue(5>6, "Condition is False");
	}
	//This method Is depends on Login method.
    //This method's execution will be skipped from execution because Login() method will fail.
	@Test(priority = 2, dependsOnMethods= {"Login"})
	public void checkMail() {
		System.out.println("Check Mail Code");
		
		
	}
	
	@Test(priority = 3, dependsOnMethods= {"Login","checkMail"})
	public void LogOut() {
		System.out.println("Logout Test Code");
	}
	
	//This Is Independent method so It will be executed.
    @Test(priority=4)
    public void checkLogInValidations() {
  System.out.println("checkLogInValidations Test code.");   
	

}
}
