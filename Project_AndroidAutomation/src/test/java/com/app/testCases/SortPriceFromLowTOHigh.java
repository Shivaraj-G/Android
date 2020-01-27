package com.app.testCases;

import org.testng.annotations.Test;

import com.app.generic.BaseTest;
import com.app.generic.Generic;
import com.app.generic.Init;
import com.app.generic.MobileActionUtil;

public class SortPriceFromLowTOHigh extends BaseTest{
	
	@Test
	public void validateDiscountInAscending() {
		Generic.logMessage(com.app.generic.LogStatus.INFO, "--------------------------------------------------");
		Generic.logMessage(com.app.generic.LogStatus.INFO, " Test Case Name : Sort Price From Low TO High ");
		Generic.logMessage(com.app.generic.LogStatus.INFO, "--------------------------------------------------");
		 Init initialize = new Init(driver);
//		 initialize.splashScreen.startShopping();
		 initialize.homePage.verifyPriceInAscending();
	}

}
