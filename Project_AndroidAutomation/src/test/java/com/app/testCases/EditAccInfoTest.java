package com.app.testCases;

import org.testng.annotations.Test;

import com.app.generic.BaseTest;
import com.app.generic.Generic;
import com.app.generic.Init;
import com.aventstack.extentreports.Status;


public class EditAccInfoTest extends BaseTest{
	
	@Test
	public void editAccInfo() throws InterruptedException {
		Generic.logMessage(com.app.generic.LogStatus.INFO, "--------------------------------------------------");
		Generic.logMessage(com.app.generic.LogStatus.INFO, " Test Case Name : Edit users personal information ");
		Generic.logMessage(com.app.generic.LogStatus.INFO, "--------------------------------------------------");
		Init initialize = new Init(driver);
		initialize.splashScreen.startShopping();
		initialize.homePage.navigateToMyAccount();
		initialize.myAccount.clickOnAccSettings();
		initialize.accSettingPage.tapOnEditInfoLink();
		initialize.editPage.editPersonalInfo();
		BaseTest.logger.log(Status.PASS, "Personal information updated successfully.");
	}

}
