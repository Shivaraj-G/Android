package com.app.testCases;

import org.testng.annotations.Test;

import com.app.generic.BaseTest;
import com.app.generic.Generic;
import com.app.generic.Init;

public class AddToBasketAndIncreaseQTY extends BaseTest{
	@Test
	public void validateDiscountInAscending() throws InterruptedException {
		Generic.logMessage(com.app.generic.LogStatus.INFO, "--------------------------------------------------");
		Generic.logMessage(com.app.generic.LogStatus.INFO, " Test Case Name : Sort Price From Low TO High ");
		Generic.logMessage(com.app.generic.LogStatus.INFO, "--------------------------------------------------");
		 Init initialize = new Init(driver);
		 initialize.splashScreen.startShopping();
		 initialize.basket.removeFromProd();
		 initialize.homePage.increaseQtyAndADDToBasket();
	}

}
