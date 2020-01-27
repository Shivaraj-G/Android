package com.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.app.generic.BasePage;
import com.app.generic.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class AccountSettingsPage extends BasePage{

	public AccountSettingsPage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='CHANGE YOUR PASSWORD']")
	private WebElement chgPwdLink;
	
	@FindBy(xpath = "//android.widget.TextView[@text='EDIT YOUR INFORMATION']") 
	private WebElement editInfolnk;
	
	public void tapOnchngPwd() {
		MobileActionUtil.clickOnMobileElement("Change password link", chgPwdLink);
	}
	
	public void tapOnEditInfoLink() {
		MobileActionUtil.clickOnMobileElement("Edit link", editInfolnk);
	}

}
