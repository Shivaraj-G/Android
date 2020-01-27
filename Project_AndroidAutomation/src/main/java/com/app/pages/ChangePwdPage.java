package com.app.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.app.generic.BasePage;
import com.app.generic.BaseTest;
import com.app.generic.ExcelLibrary;
import com.app.generic.MobileActionUtil;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;

public class ChangePwdPage extends BasePage{

	public ChangePwdPage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='SAVE']") 
	private WebElement saveBtn;
	
	@FindBy(xpath = "//android.widget.EditText[@text='Old Password']")
	private WebElement oldPwdTxt;
	
	@FindBy(xpath = "//android.widget.EditText[@text='New Password']")
	private WebElement newPwdTxt;
	
	public void changePwd(String oldPwd, String newPwd) throws InterruptedException {
		String oldpwd = oldPwd;
		String newPassword = newPwd;
		MobileActionUtil.SetText("Old Password Text", oldPwdTxt, oldpwd);
		MobileActionUtil.SetText("New Password Text", newPwdTxt, newPassword);
		MobileActionUtil.clickOnMobileElement("Save button", saveBtn);	
//		BaseTest.logger.log(Status.PASS, "Password changed successfully");
	}
	

}
