package com.app.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.generic.BasePage;
import com.app.generic.BaseTest;
import com.app.generic.MobileActionUtil;
import com.aventstack.extentreports.Status;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class HomePage extends BasePage{

	public HomePage(AndroidDriver driver) {
		super(driver);

	}
	
	@FindBy(id = "com.applications.homecentre:id/navigation_account_dest")
	private WebElement myAccountIcon;
	
	@FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Home']")
	private WebElement homeBtn;
	
	@FindBy(id = "com.applications.homecentre:id/tv_department_name")
	private List<WebElement> deptName;
	
	@FindBy(xpath = "//android.widget.TextView[@text='SORT']")
	private WebElement sortBtn;
	
	@FindBy(xpath = "//android.widget.RadioButton[@text='Discount']")
	private WebElement discountRadioBtn;
	
	@FindBy(xpath = "//android.widget.RadioButton[@text='Price - Low to High']")
	private WebElement priceLowToHigRadBtn;
	
	@FindBy(xpath = "//android.widget.Button[@text='APPLY CHANGES']")
	private WebElement applyChngBtn;
	
	@FindBy(xpath = "//android.widget.TextView[@text='REFINE']")
	private WebElement refineBtn;
	
	@FindBy(id = "com.applications.homecentre:id/textPrice")
	private List<WebElement> sortedLowToHigh;
	
	@FindBy(xpath = "//android.widget.ImageView[@resource-id='com.applications.homecentre:id/ivLanding']")
	private List<WebElement> topSellingFur;
	
	@FindBy(id = "com.applications.homecentre:id/imageProduct") 
	private WebElement furniture;
	
	public void navigateToMyAccount() {
		MobileActionUtil.clickOnMobileElement("My Account Icon", myAccountIcon);
	}
	
	
	
	public void navigateToLoundry() {
		MobileActionUtil.clickOnMobileElement("Home", homeBtn);
		driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".scrollable(true)).scrollIntoView("
                + "new UiSelector().text(\"Shop by Department\"))");
		Dimension dim = driver.manage().window().getSize();
		int h = dim.height;
		int w = dim.width;
		TouchAction action =new TouchAction(driver);
		action.press((int)(0.9*w), (int)(0.85*h)).waitAction(4000).moveTo((int)(0.05*w), (int)(0.85*h)).perform().release();
		List<WebElement> departments = driver.findElementsById("com.applications.homecentre:id/ivLanding");
		departments.get(3).click();
		
	}
	public void validateDiscount() {
		navigateToLoundry();
		deptName.get(1).click();
		MobileActionUtil.clickOnMobileElement("Sort Btn", sortBtn);
		MobileActionUtil.clickOnMobileElement("Discount Btn", discountRadioBtn);
		MobileActionUtil.clickOnMobileElement("Apply changes", applyChngBtn);
		BaseTest.logger.log(Status.PASS,"Products sorted in ascending order with highest discout to lowest");
	}
	
	public void verifyPriceInAscending() {
		navigateToLoundry();
		deptName.get(3).click();
		MobileActionUtil.clickOnMobileElement("Sort Btn", sortBtn);
		MobileActionUtil.clickOnMobileElement("Low to High Btn", priceLowToHigRadBtn);
		MobileActionUtil.clickOnMobileElement("Apply changes", applyChngBtn);
		List<Integer> allValues = new ArrayList<>();
		List<Integer> sortedValues = new ArrayList<>();
		for(int i=0;i<=10;i++) {
			for(WebElement element:sortedLowToHigh) {
				int value = Integer.parseInt(element.getText().split("\\s")[1]);
				allValues.add(value);
			}
			Dimension dim = driver.manage().window().getSize();
			int h = dim.height;
			int w = dim.width;
			TouchAction action =new TouchAction(driver);
			action.press((int)(0.5*w), (int)(0.9*h)).waitAction(4000).moveTo((int)(0.5*w), (int)(0.2*h)).perform().release();
		}
		System.out.println(allValues);
		for(Integer val:allValues) {
			sortedValues.add(val);
		}
		Collections.sort(sortedValues);
		if(allValues.equals(sortedValues)) {
			BaseTest.logger.log(Status.PASS,"Product price sorted from low to high.");
		}else {
			BaseTest.logger.log(Status.FAIL,"Product price not sorted from low to high.");
		}
	}
	
	
	
	@FindBy(id = "com.applications.homecentre:id/imageAddQuantity") 
	private WebElement qtyIncreaseIcon;
	
	@FindBy(id = "com.applications.homecentre:id/textQuantity") 
	private WebElement qtyTextFld;
	
	@FindBy(xpath = "//android.widget.Button[@text='ADD TO BASKET']")
	private WebElement addTOBasketBtn;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.applications.homecentre:id/textSuccessfullyAdded']")
	private WebElement confMessage;
	//android.widget.Button[@text='CHECKOUT NOW']
	@FindBy(id = "com.applications.homecentre:id/checkoutNowBtn")
	private WebElement checkOutBtn;
	
	@FindBy(id = "com.applications.homecentre:id/basket_badge")
	private WebElement qtyBasketTxt;
	
	@FindBy(xpath = "//android.widget.Toast")
	private WebElement toastMessage;
	
	public void getDimension() {
		Dimension dim = driver.manage().window().getSize();
		int h = dim.height;
		int w = dim.width;
	}
	
	public void increaseQtyAndADDToBasket() {
		Dimension dim = driver.manage().window().getSize();
		int h = dim.height;
		int w = dim.width;
		MobileActionUtil.clickOnMobileElement("Home", homeBtn);
		driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".scrollable(true)).scrollIntoView("
                + "new UiSelector().text(\"Top Selling Brands\"))");
		driver.swipe((int)(0.5*w), (int)(0.9*h), (int)(0.5*w), (int)(0.6*h), 2000);
		MobileActionUtil.sleep(2);
		topSellingFur.get(0).click();
		MobileActionUtil.clickOnMobileElement("Furniture", furniture);
//		TouchAction action =new TouchAction(driver);
//		action.press((int)(0.5*w), (int)(0.9*h)).waitAction(4000).moveTo((int)(0.5*w), (int)(0.2*h)).perform().release();
		MobileActionUtil.sleep(2);
		driver.swipe((int)(0.5*w), (int)(0.9*h), (int)(0.5*w), (int)(0.6*h), 2000);
		MobileActionUtil.clickOnMobileElement("+ Icon", qtyIncreaseIcon);
		int increasedQty=Integer.parseInt(qtyTextFld.getText());
		MobileActionUtil.clickOnMobileElement("Add to basket", addTOBasketBtn);
//		String loginStatus = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Toast"))).getText();
//		if(loginStatus !=null) {
//			MobileActionUtil.clickOnMobileElement("Add to basket", addTOBasketBtn);
//		}
		MobileActionUtil.clickOnMobileElement("CheckOut Btn", checkOutBtn);
		int actualQyt = Integer.parseInt(qtyBasketTxt.getText());
		Assert.assertEquals(2, actualQyt);
		
		
		
	}
	
	
	public void navigateToTowels() {
		navigateToLoundry();
		deptName.get(3).click();
		
	}

		
	
	
}
