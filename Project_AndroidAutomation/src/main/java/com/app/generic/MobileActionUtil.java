package com.app.generic;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class MobileActionUtil {
	public static AndroidDriver driver;
	WebDriverWait wait;
	public JavascriptExecutor jsExecutor;
	public Actions action;
	public static TouchAction act1;

//	public MobileActionUtil(AndroidDriver driver) {
//		this.driver = driver;
//	//	wait = new WebDriverWait(driver, ETO);
//		jsExecutor = (JavascriptExecutor) driver;
//		//action = new Actions(driver);
//	}

	public MobileActionUtil(AndroidDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 50);
		jsExecutor = (JavascriptExecutor) driver;
		action = new Actions(driver);
		TouchAction act1 = new TouchAction(driver);
	}
	
	public static void openNotifications() {
	driver.openNotifications();
	
	}

	public static void clickOnMobileElement(String elementName, WebElement element) {
		element.click();
	}

	public static void SetText(String elementName, WebElement element, String keysToSend) {
		try {
			element.sendKeys(keysToSend);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void clearAndSetText(String elementName, WebElement element, String keysToSend) {
		try {
			element.clear();
			element.sendKeys(keysToSend);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sleep(int sec) {

		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Description: This method is to long press on element upto 3 seconds then
	 * release
	 */
	public static void LongPressAction(WebElement element) throws IOException {

		try {

			act1.longPress(element).waitAction(3000).release().perform();
		} catch (Exception e) {

		}
	}
	
	
	public static void swipeRightToLeft(int value, double startX, double endX, AndroidDriver driver) throws Exception {
		try {
			
			for (int i = 1; i <= value; i++) {
				Dimension dSize = driver.manage().window().getSize();
				int startx = (int) (dSize.width * startX);
				int endx = (int) (dSize.width * endX);
				int starty = dSize.height / 2;
				driver.swipe(startx, starty, endx, starty, 1000);

			}
		} catch (Exception e) {

			throw e;
		}
	}

	/**
	 * Description: This method to scroll Right side based on device height and
	 * width
	 * 
	 * @param value
	 * @param startx
	 * @param endx
	 * @param driver
	 * @throws Exception
	 */
	public static void swipeLefToRight(int value, double startx, double endx, AndroidDriver driver) throws Exception {
		try {
			
			for (int i = 1; i <= value; i++) {
				Dimension dSize = driver.manage().window().getSize();
				int startX = (int) (dSize.width * startx);
				int endX = (int) (dSize.width * endx);
				int starty = dSize.height / 2;
				driver.swipe(startX, starty, endX, starty, 1000);
			}
		} catch (Exception e) {

			throw e;

		}
	}

	/**
	 * Description: This method to scroll Up side based on device height and
	 * width
	 * 
	 * @param value
	 * @param driver
	 * @param starty1
	 * @param endy1
	 * @throws Exception
	 */

	public static void swipeBottomToTop(int value, AndroidDriver driver, double starty1, double endy1) throws Exception {
		try {
			
			
			for (int i = 1; i <= value; i++) {
				Dimension dSize = driver.manage().window().getSize();
				int starty = (int) (dSize.height * starty1);
				int endy = ((int) (dSize.height * endy1));
				int startx = dSize.width / 2;
				driver.swipe(startx, starty, startx, endy, 1000);
			}
		} catch (Exception e) {

	
			throw e;
		}
	}
	
	
	
	
	
	

	/**
	 * Description: Scroll to an Element
	 */
	public static void scrollToElement(int maxScroll, double start, double end, String scrollType, WebElement element,
			AndroidDriver driver) throws Exception {

		while (maxScroll != 0) {
			try {
				if (element.isDisplayed()) {
					maxScroll++;
					break;
				}
			} catch (Exception e) {
				switch (scrollType.toUpperCase()) {
				case ("DOWN"):
					swipeTopToBottom(1, driver, start, end);
					break;

				case ("UP"):
					swipeBottomToTop(1, driver, start, end);
					break;

				case ("LEFT"):
					swipeRightToLeft(1, start, end, driver);
					break;

				case ("RIGHT"):
					swipeLefToRight(1, start, end, driver);
					break;

				default:
					break;

				}

			}
			maxScroll--;
		}
	}
	
	
	
	public static void swipeTopToBottom(int value, AndroidDriver driver, double starty1, double endy1) throws Exception {
		try {
			

			/*System.out.println("inside swipe");*/
			for (int i = 1; i <= value; i++) {
				Dimension dSize = driver.manage().window().getSize();
				int starty = (int) (dSize.height * starty1);
				int endy = (int) (dSize.height * endy1);
				int startx = dSize.width / 2;
				driver.swipe(startx, starty, startx, endy, 1000);
			}
		} catch (Exception e) {

			throw e;
		}
	}


	public static void tapOnElement(AndroidDriver driver, WebElement element) {
		try {
			Thread.sleep(3000);
			act1 = new TouchAction(driver);
			act1.press(element).release().perform();
		} catch (InterruptedException ie) {

		}
	}

	/**
	 * Description: this method Takes ScreenShots
	 * 
	 */
	public static String capture(String screenShotName) throws IOException {
		File source = driver.getScreenshotAs(OutputType.FILE);
		String dest = "./test-reports/Reports/ScreenShot" + screenShotName + ".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		return dest;
	}

	/**
	 * Description: this method hides keyboard
	 *
	 */
	public static void hideKeyboard() {
		try {
			driver.hideKeyboard();
			Thread.sleep(2000);
		} catch (Throwable e) {

		}
	}

	/**
	 * Description: Fetch text from element and return as string
	 * 
	 */

	public static String getText(WebElement elename, String elementName) {
		String eleText = null;
		eleText = elename.getText();
		return eleText;
	}

	/**
	 * 
	 * Description: This method to scroll left side based on device height and width
	 */

	public static void swipeRightToLeft(int value, double startX, double endX) throws Exception {
		try {
			Thread.sleep(1000);
			System.out.println("inside swipe");
			for (int i = 1; i <= value; i++) {
				Dimension dSize = driver.manage().window().getSize();
				int startx = (int) (dSize.width * startX);
				int endx = (int) (dSize.width * endX);
				int starty = dSize.height / 2;
				driver.swipe(startx, starty, endx, starty, 1000);

			}
		} catch (Exception e) {

		}
	}
	
	public static String formatDuration(final long millis) {
	      long seconds = (millis / 1000) % 60;
	      long minutes = (millis / (1000 * 60)) % 60;
	      long hours = millis / (1000 * 60 * 60);

	      StringBuilder b = new StringBuilder();
	      b.append(hours == 0 ? "00" : hours < 10 ? String.valueOf("0" + hours) :
	      String.valueOf(hours));
	      b.append(":");
	      b.append(minutes == 0 ? "00" : minutes < 10 ? String.valueOf("0" + minutes) :    
	      String.valueOf(minutes));
	      b.append(":");
	      b.append(seconds == 0 ? "00" : seconds < 10 ? String.valueOf("0" + seconds) :
	      String.valueOf(seconds));
	      return b.toString();
	}
	
}
