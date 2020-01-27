package com.app.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.app.generic.BaseTest;
import com.app.generic.Generic;
import com.app.generic.Init;
import com.app.generic.MobileActionUtil;

public class ModifyPasswordTest extends BaseTest{
	
	@Test
	public void loginToApp() throws InterruptedException  {
		Generic.logMessage(com.app.generic.LogStatus.INFO, "--------------------------------------------------");
		Generic.logMessage(com.app.generic.LogStatus.INFO, " Test Case Name : Modify the Password ");
		Generic.logMessage(com.app.generic.LogStatus.INFO, "--------------------------------------------------");
		String email = ExcelLibrary.getExcelData(XLPath, "sheet01", 1, 0);
	    String password = ExcelLibrary.getExcelData(XLPath, "sheet01", 1, 1);
	    String newPwd = RandomStringUtils.randomAlphabetic(8);
	    System.out.println(newPwd);
	    Init initialize = new Init(driver);
//	    initialize.splashScreen.startShopping();
	    initialize.homePage.navigateToMyAccount();
	    initialize.myAccount.signIn();
	    initialize.login.signInToApplication(email, password);
	    initialize.myAccount.clickOnAccSettings();
	    initialize.accSettingPage.tapOnchngPwd();
	    initialize.changePwdPage.changePwd(password, newPwd);
	    ExcelLibrary.setExcelData(XLPath, "sheet01", 1, 1, newPwd);
	    String modifiedPassword = ExcelLibrary.getExcelData(XLPath, "sheet01", 1, 1);
	    System.out.println(modifiedPassword);
	    initialize.login.validLoginToApp(email,modifiedPassword);
	    initialize.login.logout();
		
		
}

}
