package com.app.generic;


import com.app.pages.AccountSettingsPage;
import com.app.pages.AddToWishlistPage;
import com.app.pages.BasketPage;
import com.app.pages.BathAndloundryPage;
import com.app.pages.ChangePwdPage;
import com.app.pages.EditInfoPage;
import com.app.pages.HomePage;
import com.app.pages.LoginPage;
import com.app.pages.MyAccount;
import com.app.pages.ReviewsPage;
import com.app.pages.SignUpPage;
import com.app.pages.SplashScreen;
import com.app.pages.WishListPage;

import io.appium.java_client.android.AndroidDriver;

public class Init {
	public  SplashScreen splashScreen;
	public  HomePage homePage;
	public  SignUpPage signUp;
	public  MyAccount myAccount;
	public LoginPage login;
	public AccountSettingsPage accSettingPage;
	public ChangePwdPage changePwdPage;
	public AddToWishlistPage addtoWishlist;
	public WishListPage removeFromWishList;
	public BasketPage basket;
	public EditInfoPage editPage;
	public BathAndloundryPage bathAndLoundry;
	public ReviewsPage reviewsPage;
	
public	Init(AndroidDriver driver) {
		splashScreen = new SplashScreen(driver);
		homePage = new HomePage(driver);
		signUp = new SignUpPage(driver);
		myAccount = new MyAccount(driver);
		login = new LoginPage(driver);
		accSettingPage = new AccountSettingsPage(driver);
		changePwdPage = new ChangePwdPage(driver);
		addtoWishlist = new AddToWishlistPage(driver);
		removeFromWishList = new WishListPage(driver);
		basket = new BasketPage(driver);
		editPage = new EditInfoPage(driver);
		bathAndLoundry = new BathAndloundryPage(driver);
		reviewsPage = new ReviewsPage(driver);
	}

}
