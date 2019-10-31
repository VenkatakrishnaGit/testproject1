package com.BasicActionCommandsOperations.webdriver;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadingFontPropertiesbyGetCSSValue { 
WebDriver driver = null;
 
    @Before
    public void setup() throws Exception {  
  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
  driver = new FirefoxDriver();
         //driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         driver.get("http://only-testing-blog.blogspot.in/2014/05/login.html");
    }
 
 @Test
 public void readFontProperty(){
  //Locate text string element to read It's font properties.
  WebElement text = driver.findElement(By.xpath("//h1[contains(.,'Example Login Page')]"));
  
  //Read font-size property and print It In console.
  String fontSize = text.getCssValue("font-size");
  System.out.println("Font Size -> "+fontSize);
  
  //Read color property and print It In console.
  String fontColor = text.getCssValue("color");
  System.out.println("Font Color -> "+fontColor);
  
  //Read font-family property and print It In console.
  String fontFamily = text.getCssValue("font-family");
  System.out.println("Font Family -> "+fontFamily);
  
  //Read text-align property and print It In console.
  String fonttxtAlign = text.getCssValue("text-align");
  System.out.println("Font Text Alignment -> "+fonttxtAlign);
 }
 
 @Test
 public void tearDown() {
	 driver.close();
 }
}
