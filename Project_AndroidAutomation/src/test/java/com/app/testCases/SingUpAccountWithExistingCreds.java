package com.app.testCases;

import org.testng.annotations.Test;

import com.app.generic.BaseTest;
import com.app.generic.Generic;
import com.app.generic.Init;

public class SingUpAccountWithExistingCreds extends BaseTest{
	
	@Test
	public void homeTest() throws InterruptedException  {
		
		Generic.logMessage(com.app.generic.LogStatus.INFO, "--------------------------------------------------");
		Generic.logMessage(com.app.generic.LogStatus.INFO, " Test Case Name : Sign Up to existing account ");
		Generic.logMessage(com.app.generic.LogStatus.INFO, "--------------------------------------------------");
		Thread.sleep(5000);
		String fullName = ExcelLibrary.getExcelData(XLPath, "signup", 1, 0);
		String email = ExcelLibrary.getExcelData(XLPath, "signup", 1, 1);
		String password = ExcelLibrary.getExcelData(XLPath, "signup", 1, 2);
		String expErrMessage = ExcelLibrary.getExcelData(XLPath, "signup", 1, 4);
		System.out.println(expErrMessage);
	    Init it = new Init(driver);
	    it.splashScreen.startShopping();
	    it.homePage.navigateToMyAccount();
	    it.myAccount.signUp();
	    it.signUp.signUpAccountWithExistingAcc(fullName, email, password,expErrMessage);
	   

		
		
}

}
