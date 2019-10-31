package com.AdvancedTestNG.webdriver;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviderRepository1 { 
 
 //Pass Method name In BothCaseData method.
 @DataProvider(name="BothData")
 public static Object[][] BothCaseData(Method mtd){
  
  Object detail[][] = null;
  
  //If method name = LogIn, Use this data.
  if(mtd.getName().equalsIgnoreCase("LogIn")){
   
   detail = new Object[3][2];
   detail[0][0]="UserName1";
   detail[0][1]="Password1";
  
   detail[1][0]="UserName2";
   detail[1][1]="Password2";
  
   detail[2][0]="UserName3";
   detail[2][1]="Password3";
  }
  //If method name = Submit, Use this data.
  else if(mtd.getName().equalsIgnoreCase("Submit")){
   
   detail = new Object[3][5];
   detail[0][0]="fName1";
   detail[0][1]="lname1";
   detail[0][2]="email1@youraccount.com";
   detail[0][3]="mobno1";
   detail[0][4]="company1";  
   
   detail[1][0]="fName2";
   detail[1][1]="lname2";
   detail[1][2]="email2@youraccount.com";
   detail[1][3]="mobno2";
   detail[1][4]="company2";
   
   detail[2][0]="fName3";
   detail[2][1]="lname3";
   detail[2][2]="email3@youraccount.com";
   detail[2][3]="mobno3";
   detail[2][4]="company3";
  }
  
  return detail;
 } 
}
