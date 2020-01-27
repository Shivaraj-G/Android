package com.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.app.generic.BasePage;
import com.app.generic.BaseTest;
import com.app.generic.ExcelLibrary;
import com.app.generic.Init;
import com.app.generic.MobileActionUtil;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage extends BasePage{

	public LoginPage(AndroidDriver driver) {
		super(driver);
	}
	@FindBy(id = "com.applications.homecentre:id/etEmail")
	private WebElement emailTxt;
	
	@FindBy(id = "com.applications.homecentre:id/etPassword")
	private WebElement passwordTxt;
	
	@FindBy(id = "com.applications.homecentre:id/btnSignIn")
	private WebElement signInBtn;
	
	@FindBy(id = "com.applications.homecentre:id/my_account_user_name")
	private WebElement accountUserName;
	
	@FindBy(id = "com.applications.homecentre:id/sign_in")
	private WebElement signInAccBtn;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Sign Out']")
	private WebElement signOutBtn;
	
	@FindBy(xpath = "//android.widget.Toast[1]")
	private WebElement toastMessage;
	
	
	public void signInToApplication(String email, String password) throws InterruptedException {
		MobileActionUtil.SetText("Email", emailTxt, email);
		MobileActionUtil.SetText("Password", passwordTxt, password);
		MobileActionUtil.clickOnMobileElement("Signin Btn", signInBtn);
		String userName = accountUserName.getText();
		String firstName = userName.split("\\s")[1];
		String lastName = userName.split("\\s")[2];
		Assert.assertEquals(firstName+" "+lastName, "SHIVA RAJ");
	}
	
public void invalidLoginToApp(String email, String invalidPWD, String expErrMessage)  {	
		MobileActionUtil.SetText("Email", emailTxt, email);
		MobileActionUtil.SetText("Password", passwordTxt, invalidPWD);
		MobileActionUtil.clickOnMobileElement("Signin Btn", signInBtn);
		String errMessage = toastMessage.getText();
		System.out.println("Error:" + errMessage);
		Assert.assertEquals(errMessage, expErrMessage);
//		BaseTest.logger.log(Status.PASS, "With invalid login credentials device is dispyaing proper error message saying " + errMessage);
	}
	
	public void validLoginToApp(String email, String password)  {
		MobileActionUtil.clickOnMobileElement("SignInBtn", signInAccBtn);
		MobileActionUtil.SetText("Email", emailTxt, email);
		MobileActionUtil.SetText("Password", passwordTxt, password);
		MobileActionUtil.clickOnMobileElement("Signin Btn", signInBtn);
		String userName = accountUserName.getText();
		String firstName = userName.split("\\s")[1];
		String lastName = userName.split("\\s")[2];
		Assert.assertEquals(firstName+" "+lastName, "SHIVA RAJ");	
	}
	
	public void logout()  {
		driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".scrollable(true)).scrollIntoView("
                + "new UiSelector().text(\"Sign Out\"))");
		MobileActionUtil.clickOnMobileElement("SignOut", signOutBtn);
	}
	
	

}
