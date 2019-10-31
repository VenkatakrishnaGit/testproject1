package com.SeleniumWebDriverTipsAndTricks.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReadingPieChartToolTipValue {
	WebDriver driver;
	 
	 @BeforeTest
	 public void setup() throws Exception {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\Lib Folder\\geckodriver-v0.20.0-win64\\geckodriver.exe");
	  driver = new FirefoxDriver();
	 // driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.get("http://yuilibrary.com/yui/docs/charts/charts-pie.html");
	 }
	 
	 @Test
	 public void pieChart(){
	  //Locate pie chart elements based on different colors.
	  WebElement VioleteColor = driver.findElement(By.xpath("//*[contains(@class,'yui3-svgSvgPieSlice')][@fill='#66007f']"));
	  WebElement GreenColor = driver.findElement(By.xpath("//*[contains(@class,'yui3-svgSvgPieSlice')][@fill='#295454']"));
	  WebElement GreyColor = driver.findElement(By.xpath("//*[contains(@class,'yui3-svgSvgPieSlice')][@fill='#e8cdb7']"));
	  WebElement LightVioleteColor = driver.findElement(By.xpath("//*[contains(@class,'yui3-svgSvgPieSlice')][@fill='#996ab2']"));
	  WebElement BrownColor = driver.findElement(By.xpath("//*[contains(@class,'yui3-svgSvgPieSlice')][@fill='#a86f41']"));
	  
	  //locate tooltip pie chart.
	  WebElement ToolTip = driver.findElement(By.xpath("//div[contains(@id,'_tooltip')]"));

	  //Click on pie chart parts and get tooltip values.
	  System.out.println("-X-X-X-X-X-X-X-X- Violete Part -X-X-X-X-X-X-X-X-");
	  VioleteColor.click();  
	  System.out.println(ToolTip.getText());
	  System.out.println();  
	  
	  System.out.println("-X-X-X-X-X-X-X-X- Grey Part -X-X-X-X-X-X-X-X-");
	  GreyColor.click();
	  System.out.println(ToolTip.getText());
	  System.out.println();
	  
	  System.out.println("-X-X-X-X-X-X-X-X- Light Violete Part -X-X-X-X-X-X-X-X-");
	  LightVioleteColor.click();
	  System.out.println(ToolTip.getText());
	  System.out.println();
	  
	  System.out.println("-X-X-X-X-X-X-X-X- Green Part -X-X-X-X-X-X-X-X-");
	  GreenColor.click();
	  System.out.println(ToolTip.getText());
	  System.out.println();
	  
	  System.out.println("-X-X-X-X-X-X-X-X- Brown Part -X-X-X-X-X-X-X-X-");
	  BrownColor.click();
	  System.out.println(ToolTip.getText());  
	 }

}
