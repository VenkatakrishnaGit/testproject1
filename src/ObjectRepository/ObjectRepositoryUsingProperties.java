package ObjectRepository;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ObjectRepositoryUsingProperties {
 WebDriver driver = null;
 
 @Before
  public void openbrowser() throws IOException { 
	 
  //Logger log = Logger.getLogger("ObjectRepositoryUsingProperties");
   Logger log  = Logger.getLogger("devpinoyLogger");
   
   
   System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
   driver = new FirefoxDriver();
   log.info("Firefox browser Instance is opend");
   
   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
   log.info("Implicitly wait is applied to the Script");
   //driver.manage().window().maximize();
   driver.get("http://only-testing-blog.blogspot.in/2014/04/calc.html"); 
   log.info("Application is Launched");
  }
 
 @After
  public void closebrowser() { 
	 
	// Logger log = Logger.getLogger("ObjectRepositoryUsingProperties");
	 Logger log  = Logger.getLogger("devpinoyLogger");
	 
     driver.quit();
     log.info("Browse is closed");
  }  
 
 @Test
 public void testCalbyORP() throws IOException {
	 //for Logs
	// Logger log = Logger.getLogger("ObjectRepositoryUsingProperties");
	 Logger log  = Logger.getLogger("devpinoyLogger");
	 
	 //Create Object for Properties file
	 Properties obj = new Properties();
	 log.info("Object created for Properties file");
	 
	 //Create Object of FileInputStream Class. Pass file path.
	FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\ObjectRepository\\objects.properties");
	log.info("Created Object of FileInputStream Class. Pass file path.");
	//Pass object reference objfile to load method of Properties object.
	 obj.load(objfile);
	 log.info("Passed object reference objfile to load method of Properties object.");
	 
	//Sum operation on calculator.
	//Accessing element locators of all web elements using obj.getProperty(key)
	 log.info("Sum operation on calculator.");
	 log.info("Accessing element locators of all web elements using obj.getProperty(key)");
	 
	 driver.findElement(By.id(obj.getProperty("eight"))).click();
	 log.info("eight is entered");
	 driver.findElement(By.id(obj.getProperty("plus"))).click();
	 log.info("Plus is entered");
	 driver.findElement(By.id(obj.getProperty("four"))).click();
	 log.info("Four is entered");
	  driver.findElement(By.id(obj.getProperty("equalsto"))).click();
	  log.info("Equal symbol is Pressed");
	  
	  String i = driver.findElement(By.id(obj.getProperty("result"))).getAttribute("value");
	  System.out.println(obj.getProperty("eight")+" + "+obj.getProperty("four")+" = "+i);
	  log.info("result displayed for Addition Operation ");
	  
	  driver.findElement(By.id(obj.getProperty("result"))).clear();
	  log.info("Cleared the Screen");
	  
	//Subtraction operation on calculator.
	//Accessing element locators of all web elements using obj.getProperty(key)
	  log.info("Subtraction operation on calculator.");
	  log.info("Accessing element locators of all web elements using obj.getProperty(key)");
	  
	  driver.findElement(By.id(obj.getProperty("nine"))).click();
	  log.info("Nine is entered");
	  driver.findElement(By.id(obj.getProperty("minus"))).click();
	  log.info("Minus is entered");
	 // driver.findElement(By.id(obj.getProperty("three"))).click();
	  driver.findElement(By.xpath(obj.getProperty("three"))).click();
	  log.info("Three is entered");
	  driver.findElement(By.id(obj.getProperty("equalsto"))).click();
	  log.info("Equal symbol is Pressed");
	  String j = driver.findElement(By.id(obj.getProperty("result"))).getAttribute("value");
	  System.out.println(obj.getProperty("nine")+" - "+obj.getProperty("three")+" = "+j);
	  log.info("result displayed for Subtraction Operation");
	 
	 
	 
 }
	 
 }
 
