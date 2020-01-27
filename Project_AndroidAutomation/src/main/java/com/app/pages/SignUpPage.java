package com.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.app.generic.BasePage;
import com.app.generic.Init;
import com.app.generic.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class SignUpPage extends BasePage {

	public SignUpPage(AndroidDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath = "//android.widget.EditText[@text='Full Name']")
	private WebElement fullNameTxt;
	
	@FindBy(xpath = "//android.widget.EditText[@text='Email']")
	private WebElement emailTxt;
	
	@FindBy(xpath = "//android.widget.EditText[@text='Password']")
	private WebElement passwordTxt;
	
	@FindBy(id = "com.applications.homecentre:id/btnSignUp")
	private WebElement signUpBtn;
	
	@FindBy(id = "com.applications.homecentre:id/my_account_user_name")
	private WebElement accountUserName;
	
	@FindBy(xpath = "//android.widget.Toast[1]")
	private WebElement toastMessage;
	
	
public void signUpAccount(String fullName, String email, String password, String name) {
	MobileActionUtil.SetText("Full Name", fullNameTxt, fullName);
	MobileActionUtil.SetText("Email", emailTxt, email);
	MobileActionUtil.SetText("Password", passwordTxt, password);
	MobileActionUtil.clickOnMobileElement("Signup Btn", signUpBtn);
	String userName = accountUserName.getText();
	String firstName = userName.split("\\s")[1];
	String lastName = userName.split("\\s")[2];
	Assert.assertEquals(firstName+" "+lastName, name);
}

public void signUpAccountWithExistingAcc(String fullName, String email, String password,String expErrMessage) {
	MobileActionUtil.SetText("Full Name", fullNameTxt, fullName);
	MobileActionUtil.SetText("Email", emailTxt, email);
	MobileActionUtil.SetText("Password", passwordTxt, password);
	MobileActionUtil.clickOnMobileElement("Signup Btn", signUpBtn);
	String errMessage = toastMessage.getText();
	System.out.println("Error:" + errMessage);
	Assert.assertEquals(errMessage, expErrMessage);
}


}
