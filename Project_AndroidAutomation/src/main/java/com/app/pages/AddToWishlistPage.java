package com.app.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.app.generic.BasePage;
import com.app.generic.BaseTest;
import com.app.generic.MobileActionUtil;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;

public class AddToWishlistPage extends BasePage{

	public AddToWishlistPage(AndroidDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='Furniture']")
	private WebElement furnitureLnk;
	
	@FindBy(xpath = "//android.widget.RadioButton[@text='Debit card']")
	private WebElement debitCardRadioBtn;
	
	@FindBy(id="com.applications.homecentre:id/ivLanding")
	private List<WebElement> shopByDepartment;
	
	@FindBy(id = "com.applications.homecentre:id/tv_department_name")
	private List<WebElement> department;
	
	@FindBy(id = "com.applications.homecentre:id/imageFavourite")
	private List<WebElement> favouriteSymb;
	
	@FindBy(id = "com.applications.homecentre:id/textProductName")
	private List<WebElement> productText;
	
	@FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Favourites']")
	private WebElement favButton;
	
//	Fav page elements
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.applications.homecentre:id/textFavProductName']")
	private List<WebElement> wishlistProds;
	
	@FindBy(id = "com.applications.homecentre:id/imageFavRemove")
	private List<WebElement> removeBtn;
	
	@FindBy(xpath = "//android.widget.Button[@text='OK']")
	private WebElement okBtn;
	
	@FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Home']")
	private WebElement homeBtn;
	
	
	public void wishList() throws InterruptedException {
		MobileActionUtil.clickOnMobileElement("Home", homeBtn);
		driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".scrollable(true)).scrollIntoView("
                + "new UiSelector().text(\"Shop by Department\"))");
		shopByDepartment.get(1).click();
		department.get(1).click();
		favouriteSymb.get(0).click();
	}
	
	
	
	public void addToWishList() throws InterruptedException {
		driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".scrollable(true)).scrollIntoView("
                + "new UiSelector().text(\"Shop by Department\"))");
		shopByDepartment.get(0).click();
		department.get(2).click();
		String expectedText = productText.get(0).getText();
		System.out.println(expectedText);
		favouriteSymb.get(0).click();	
		MobileActionUtil.clickOnMobileElement("Fav Button", favButton);
		List<String> listProds = new ArrayList<>();
			for(WebElement prod:wishlistProds) {
				listProds.add(prod.getText());
			}
			if(listProds.contains(expectedText)) {
				BaseTest.log.info("Pass");
				//BaseTest.logger.log(Status.PASS,"Product is added to wishlist Sccessfully and listed in wishlist page.");
			}else {
				BaseTest.log.info("Fail");
				//BaseTest.logger.log(Status.FAIL,"Product is not added to wishlist.");
			}	
			removeBtn.get(0).click();	
			MobileActionUtil.clickOnMobileElement("OkBtn", okBtn);
			
	}

}
