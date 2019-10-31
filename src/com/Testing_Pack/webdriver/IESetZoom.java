package com.Testing_Pack.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IESetZoom {
 public static void main(String[] args) throws Exception {

  // Set path of IEDriverServer.exe
  // Note : IEDriverServer.exe should be In D: drive.
  System.setProperty("webdriver.ie.driver", "C:\\Users\\VenkatakrishnaY\\Downloads\\IEDriverServer.exe");

  // Set desired capabilities to Ignore IEDriver zoom level settings and disable native events.
  DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
  caps.setCapability("EnableNativeEvents", false);
  caps.setCapability("ignoreZoomSetting", true);

  // Initialize InternetExplorerDriver Instance using new capability.
  WebDriver driver = new InternetExplorerDriver(caps);
  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

  // Press CTRL + 0 keys of keyboard to set IEDriver Instance zoom level to 100%.
  driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));

  // Load sample calc test URL
  driver.get("http://only-testing-blog.blogspot.in/2014/04/calc.html");

  // Execute sample calc test.
  driver.findElement(By.xpath("//input[@id='1']")).click();
  driver.findElement(By.xpath("//input[@id='plus']")).click();
  driver.findElement(By.xpath("//input[@id='6']")).click();
  driver.findElement(By.xpath("//input[@id='equals']")).click();
  String result = driver.findElement(By.xpath("//input[@id='Resultbox']")).getAttribute("value");
  Thread.sleep(5000);
  System.out.println("Calc test result Is : " + result);
  driver.close();
 }
}