package com.app.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.app.generic.BasePage;
import com.app.generic.BaseTest;
import com.app.generic.MobileActionUtil;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;

public class ReviewsPage extends BasePage{

	public ReviewsPage(AndroidDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "com.applications.homecentre:id/text_review_title")
	private List<WebElement> allTitles; 
	
	@FindBy(id = "com.applications.homecentre:id/text_comment")
	private List<WebElement> allDescriptions; 
	
	@FindBy(xpath = "//android.widget.TextView[@text='DELETE']")
	private List<WebElement> allDeleteBtn;
	
	@FindBy(id = "android:id/button1")
	private WebElement okBtn;
	

	public void deleteReview() throws InterruptedException {
		for(int i=0;i<allDeleteBtn.size();i++) {
			allDeleteBtn.get(i).click();
			MobileActionUtil.clickOnMobileElement("Ok Btn", okBtn);
		}
		
	}
	
	
	public void verifyReview(String expectedTitle, String expectedDescription) {
		List<String> titleList = new ArrayList<String>();
		for(WebElement title:allTitles) {
			titleList.add(title.getText());
		}
		List<String> descriptionList = new ArrayList<String>();
		for(WebElement description:allDescriptions) {
			descriptionList.add(description.getText());
		}
		if(titleList.contains(expectedTitle) && descriptionList.contains(expectedDescription)) {
//			BaseTest.logger.log(Status.PASS, "The review is added successfully.");
			System.out.println("The review is added successfully.");
		} else {
//			BaseTest.logger.log(Status.FAIL, "The review is not added.");
			System.out.println("The review is not added.");
		}
		
	}

}
