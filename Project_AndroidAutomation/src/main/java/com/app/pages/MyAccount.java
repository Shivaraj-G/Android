package com.app.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.app.generic.BasePage;
import com.app.generic.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class MyAccount extends BasePage{

	public MyAccount(AndroidDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//android.widget.Button[@text='Sign up']")
	private WebElement signUpBtn;
	
	@FindBy(id = "com.applications.homecentre:id/my_account_user_name")
	private WebElement accountUserName;
	
	@FindBy(id = "com.applications.homecentre:id/sign_in")
	private WebElement signInBtn;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Account Settings']")
	private WebElement accSettingsBtn;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Payment']")
	private WebElement paymentBtn;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Reviews']")
	private WebElement reviewsBtn;
	
	
	public void signUp() {
		MobileActionUtil.clickOnMobileElement("SignUp", signUpBtn);
	}
	
	public void signIn() {
		MobileActionUtil.clickOnMobileElement("SignIn", signInBtn);
	}
	
	public void clickOnAccSettings() {
		MobileActionUtil.clickOnMobileElement("Acc settings btn", accSettingsBtn);
	}
	
	public void clickOnAdressBook() {
		MobileActionUtil.clickOnMobileElement("Address Btn", paymentBtn);
	}
	
	public void clickOnReviewBtn() {
		MobileActionUtil.clickOnMobileElement("Reviews Btn", reviewsBtn);
	}

}
