package com.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.app.generic.BasePage;
import com.app.generic.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class SplashScreen extends BasePage{

	public SplashScreen(AndroidDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "com.applications.homecentre:id/startShoppingBtn")
	private WebElement startShoppingBtn;
	
	public void startShopping() {
		
	try {
		MobileActionUtil.clickOnMobileElement("Start shopping button", startShoppingBtn);
	} catch (Exception e) {
		System.out.println("Element is not displayed");
	}
	
	}

}
