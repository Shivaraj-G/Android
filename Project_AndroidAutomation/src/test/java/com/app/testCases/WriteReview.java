package com.app.testCases;

import org.testng.annotations.Test;

import com.app.generic.BaseTest;
import com.app.generic.Generic;
import com.app.generic.Init;

public class WriteReview extends BaseTest{
	
	@Test
	public void validateDiscountInAscending() throws InterruptedException {
		Generic.logMessage(com.app.generic.LogStatus.INFO, "--------------------------------------------------");
		Generic.logMessage(com.app.generic.LogStatus.INFO, " Test Case Name : Sort Price From Low TO High ");
		Generic.logMessage(com.app.generic.LogStatus.INFO, "--------------------------------------------------");
		String description = ExcelLibrary.getExcelData(XLPath, "commentData", 1, 0);
	    String title = ExcelLibrary.getExcelData(XLPath, "commentData", 1, 1);
		 Init initialize = new Init(driver);
		 initialize.splashScreen.startShopping();
		 initialize.homePage.navigateToTowels();
		 initialize.bathAndLoundry.writeReview(description, title);
		 initialize.homePage.navigateToMyAccount();
		 initialize.myAccount.clickOnReviewBtn();
		 initialize.reviewsPage.verifyReview(title, description);
		 initialize.reviewsPage.deleteReview();
	}

}
