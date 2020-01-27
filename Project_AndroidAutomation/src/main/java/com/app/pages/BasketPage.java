package com.app.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.app.generic.BasePage;
import com.app.generic.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class BasketPage extends BasePage{

	public BasketPage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Basket']")
	private WebElement basketIcon;
	
	@FindBy(id = "com.applications.homecentre:id/img_delete_product")
	private List<WebElement> removeBtns;
	
	public void removeFromProd() {
		MobileActionUtil.clickOnMobileElement("Basket", basketIcon);
		List<WebElement> removeElements=new ArrayList<>();
		for(WebElement remove:removeBtns) {
			removeElements.add(remove);
		}
		if(!removeElements.isEmpty()) {
		for(WebElement removeBtn:removeBtns) {
			MobileActionUtil.sleep(3);
			removeBtn.click();
		}
		}
	}
	

}
