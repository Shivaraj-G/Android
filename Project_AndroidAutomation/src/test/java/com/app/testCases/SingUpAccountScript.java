package com.app.testCases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.app.generic.BaseTest;
import com.app.generic.Generic;
import com.app.generic.Init;

public class SingUpAccountScript extends BaseTest{
	@Test
	public void homeTest() throws InterruptedException  {
		
		Generic.logMessage(com.app.generic.LogStatus.INFO, "--------------------------------------------------");
		Generic.logMessage(com.app.generic.LogStatus.INFO, " Test Case Name : Sign Up Account ");
		Generic.logMessage(com.app.generic.LogStatus.INFO, "--------------------------------------------------");
		Thread.sleep(5000);
		String fullName = ExcelLibrary.getExcelData(XLPath, "signup", 1, 0);
		String email = ExcelLibrary.getExcelData(XLPath, "signup", 1, 1);
		String password = ExcelLibrary.getExcelData(XLPath, "signup", 1, 2);
		String userName = ExcelLibrary.getExcelData(XLPath, "signup", 1, 3);
	    Init it = new Init(driver);
	    it.splashScreen.startShopping();
	    it.homePage.navigateToMyAccount();
	    it.myAccount.signUp();
	    it.signUp.signUpAccount(fullName, email, password,userName);
	   

		
		
}
	
	

}
