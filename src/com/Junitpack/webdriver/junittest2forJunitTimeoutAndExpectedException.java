package com.Junitpack.webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class junittest2forJunitTimeoutAndExpectedException {
 
 WebDriver driver = null;
 
@Before
public void setup () {
 // set geckodriver path.
 System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
 //initialize firefox driver.
 driver = new FirefoxDriver();
// driver.manage().window().maximize();
 driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
}

@After
public void aftertest() {
 driver.quit(); 
}

 
@Test(timeout=5000)
public void test1() throws InterruptedException{  
driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("junittest2 class-test1");
System.out.print("\njunittest2 class-test1 executed before sleep");
Thread.sleep(5000);
System.out.print("\njunittest2 class-test1 executed after sleep");
}

@Test(expected = NullPointerException.class)
public void exceptiontest1() {
    throw new NullPointerException();
}

@Test()
public void exceptiontest2() {
 throw new NullPointerException();
}
}