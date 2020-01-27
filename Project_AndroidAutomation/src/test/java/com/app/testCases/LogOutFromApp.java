package com.app.testCases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.app.generic.BaseTest;
import com.app.generic.Generic;
import com.app.generic.Init;

public class LogOutFromApp extends BaseTest {
	
	@Test
	public void login() throws InterruptedException {
		Generic.logMessage(com.app.generic.LogStatus.INFO, "--------------------------------------------------");
		Generic.logMessage(com.app.generic.LogStatus.INFO, " Test Case Name : Singh In To Application ");
		Generic.logMessage(com.app.generic.LogStatus.INFO, "--------------------------------------------------");
		String email = ExcelLibrary.getExcelData(XLPath, "sheet01", 1, 0);
	    String password = ExcelLibrary.getExcelData(XLPath, "sheet01", 1, 1);
	    Init initialize = new Init(driver);
	    driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
	    initialize.splashScreen.startShopping();
	    initialize.homePage.navigateToMyAccount();
	    initialize.myAccount.signIn();
	    initialize.login.signInToApplication(email, password);
	    initialize.login.logout();
	}

}
