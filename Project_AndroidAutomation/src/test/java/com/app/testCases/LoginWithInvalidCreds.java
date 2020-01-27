package com.app.testCases;

import org.testng.annotations.Test;

import com.app.generic.BaseTest;
import com.app.generic.Generic;
import com.app.generic.Init;

public class LoginWithInvalidCreds extends BaseTest {

	@Test 
	public void loginTest() throws InterruptedException {
		Generic.logMessage(com.app.generic.LogStatus.INFO, "--------------------------------------------------");
		Generic.logMessage(com.app.generic.LogStatus.INFO, " Test Case Name : Sign In To Application with invalid credentials");
		Generic.logMessage(com.app.generic.LogStatus.INFO, "--------------------------------------------------");
		String email = ExcelLibrary.getExcelData(XLPath, "sheet01", 1, 0);
	    String password = ExcelLibrary.getExcelData(XLPath, "sheet01", 1, 2);
	    String expErrMessage = ExcelLibrary.getExcelData(XLPath, "sheet02", 1, 1);
	    Init initialize = new Init(driver);
	    initialize.splashScreen.startShopping();
	    initialize.homePage.navigateToMyAccount();
	    initialize.myAccount.signIn();
	    initialize.login.invalidLoginToApp(email, password,expErrMessage);
	}

}
