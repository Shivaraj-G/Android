package com.app.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.app.generic.BasePage;
import com.app.generic.MobileActionUtil;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class BathAndloundryPage extends BasePage{

	public BathAndloundryPage(AndroidDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "com.applications.homecentre:id/imageProduct")
	private List<WebElement> products;
	
	@FindBy(xpath = "//android.widget.TextView[@text='WRITE A REVIEW']")
	private WebElement writeReviewBtn;
	
	@FindBy(id = "com.applications.homecentre:id/rating")
	private WebElement fiveStarRatingbar;

	@FindBy(id = "com.applications.homecentre:id/review")
	private WebElement commentTxtField;
	
	@FindBy(id="com.applications.homecentre:id/review_title")
	private WebElement titleTxtField;
	
	@FindBy(id="com.applications.homecentre:id/btn_review_save")
	private WebElement commentSaveBtn;
	
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	private WebElement backButton;
	
//	public void getDimension() {
//		Dimension dim = driver.manage().window().getSize();
//		int h = dim.height;
//		int w = dim.width;
//	}
	
	public void writeReview(String comment, String title) {
		Dimension dim = driver.manage().window().getSize();
		int h = dim.height;
		int w = dim.width;
		products.get(0).click();
		driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".scrollable(true)).scrollIntoView("
                + "new UiSelector().text(\"What do you think about this product?\"))");
		TouchAction action = new TouchAction(driver);
		action.press((int)(0.5*w), (int)(0.9*h)).waitAction(2000).moveTo((int)(0.5*w), (int)(0.2*h)).release().perform();
		MobileActionUtil.clickOnMobileElement("Write review button", writeReviewBtn);
		
		//Locate fiveStarRatingbar.
		  //Get start point of fiveStarRatingbar.
		  int startX = fiveStarRatingbar.getLocation().getX();
		  System.out.println(startX);
		  //Get end point of fiveStarRatingbar.
		  int endX = fiveStarRatingbar.getSize().getWidth();
		  System.out.println(endX);
		  //Get vertical location of fiveStarRatingbar.
		  int yAxis = fiveStarRatingbar.getLocation().getY();
		  
		  //Set fiveStarRatingbar tap position to set Rating = 4 star.
		  //You can use endX * 0.2 for 1 star, endX * 0.4 for 2 star, endX * 0.6 for 3 star, endX * 0.8 for 4 star, endX * 1 for 5 star.
		  int tapAt = (int) (endX * 1.0);  
		  //Set fiveStarRatingbar to Rating = 4 star using TouchAction class.
		  TouchAction act=new TouchAction(driver);  
		  act.press(tapAt,yAxis).release().perform();
		  MobileActionUtil.SetText("Comment text field", commentTxtField, comment);
		  MobileActionUtil.SetText("Title text field", titleTxtField, title);
		  MobileActionUtil.clickOnMobileElement("Comment save button", commentSaveBtn);
		  MobileActionUtil.clickOnMobileElement("Back button", backButton);
		  
	}
	

}
