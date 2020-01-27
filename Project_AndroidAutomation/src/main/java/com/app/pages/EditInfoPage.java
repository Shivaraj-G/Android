package com.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.app.generic.BasePage;
import com.app.generic.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class EditInfoPage extends BasePage{

	public EditInfoPage(AndroidDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "com.applications.homecentre:id/edit_change_firstname")
	private WebElement firstName;
	
	@FindBy(id = "com.applications.homecentre:id/edit_change_lastname")
	private WebElement lastName;
	
	@FindBy(id = "com.applications.homecentre:id/action_save")
	private WebElement saveBtn;
	
	
	public void editPersonalInfo() {
		MobileActionUtil.clearAndSetText("FirstName", firstName, "Ravi");
		
	}
	

}
