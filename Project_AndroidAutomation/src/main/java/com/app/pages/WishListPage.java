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

public class WishListPage extends BasePage{

	public WishListPage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//	Fav page elements
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.applications.homecentre:id/textFavProductName']")
	private List<WebElement> wishlistProds;
	
	@FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Favourites']")
	private WebElement favButton;
	
	@FindBy(id = "com.applications.homecentre:id/imageFavRemove")
	private List<WebElement> removeBtn;
	
	@FindBy(xpath = "//android.widget.Button[@text='OK']")
	private WebElement okBtn;
	
	
	
	public void verifyWishListProd() throws InterruptedException {
		MobileActionUtil.clickOnMobileElement("Fav Btn", favButton);
		String expectedText=wishlistProds.get(0).getText();
		removeBtn.get(0).click();
		MobileActionUtil.clickOnMobileElement("Ok Btn", okBtn);
		List<String> listProds = new ArrayList<>();
			for(WebElement prod:wishlistProds) {
				listProds.add(prod.getText());
			}
//			for(String text:listProds) {
//				System.out.println(text);
//			}
			if(!listProds.contains(expectedText)) {
				BaseTest.log.info("Pass");
				BaseTest.logger.log(Status.PASS,"Product is removed Sccessfully from wishlist page.");
			}else {
				BaseTest.log.info("Fail");
				BaseTest.logger.log(Status.FAIL,"Product is not removed from wishlist page.");
			}
	}
}
