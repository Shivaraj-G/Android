package com.app.testCases;

import org.testng.annotations.Test;

import com.app.generic.BaseTest;
import com.app.generic.Generic;
import com.app.generic.Init;

public class LogInToApp extends BaseTest {
	
	@Test
	public void loginToApp() throws InterruptedException  {
		
		Generic.logMessage(com.app.generic.LogStatus.INFO, "--------------------------------------------------");
		Generic.logMessage(com.app.generic.LogStatus.INFO, " Test Case Name : Sign In To Application ");
		Generic.logMessage(com.app.generic.LogStatus.INFO, "--------------------------------------------------");
		String email = ExcelLibrary.getExcelData(XLPath, "sheet01", 1, 0);
	    String password = ExcelLibrary.getExcelData(XLPath, "sheet01", 1, 1);
	    Init initialize = new Init(driver);
	    initialize.splashScreen.startShopping();
	    initialize.homePage.navigateToMyAccount();
	    initialize.myAccount.signIn();
	    initialize.login.signInToApplication(email, password);
	    initialize.login.logout();
}

}
