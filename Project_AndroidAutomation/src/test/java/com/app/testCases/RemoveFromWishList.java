package com.app.testCases;

import org.testng.annotations.Test;

import com.app.generic.BaseTest;
import com.app.generic.Generic;
import com.app.generic.Init;

public class RemoveFromWishList extends BaseTest{
	

	@Test
	private void addToWishlist() throws InterruptedException {
		Generic.logMessage(com.app.generic.LogStatus.INFO, "--------------------------------------------------");
		Generic.logMessage(com.app.generic.LogStatus.INFO, " Test Case Name : Remove product from wishlist ");
		Generic.logMessage(com.app.generic.LogStatus.INFO, "--------------------------------------------------");
	    Init initialize = new Init(driver);
	    initialize.addtoWishlist.wishList();
	    initialize.removeFromWishList.verifyWishListProd();
	    
	}

}
