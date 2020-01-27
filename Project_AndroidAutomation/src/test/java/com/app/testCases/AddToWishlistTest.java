package com.app.testCases;

import org.testng.annotations.Test;

import com.app.generic.BaseTest;
import com.app.generic.Generic;
import com.app.generic.Init;

public class AddToWishlistTest extends BaseTest{

	@Test
	private void addToWishlist() throws InterruptedException {
		Generic.logMessage(com.app.generic.LogStatus.INFO, "--------------------------------------------------");
		Generic.logMessage(com.app.generic.LogStatus.INFO, " Test Case Name : Adding product to wishlist ");
		Generic.logMessage(com.app.generic.LogStatus.INFO, "--------------------------------------------------");

	    Init initialize = new Init(driver);
	    initialize.splashScreen.startShopping();
	    initialize.addtoWishlist.addToWishList();
	    
	}
	
	
	
	

}
