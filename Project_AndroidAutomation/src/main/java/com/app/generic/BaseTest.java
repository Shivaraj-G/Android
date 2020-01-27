package com.app.generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;



public class BaseTest implements AutoConstants {
	public static ExtentHtmlReporter extent;
	public static ExtentTest test;
	public static ExtentTest logger;
	public static ExtentReports ex;
	public static AndroidDriver driver;
	public MobileActionUtil mobileActionUtil;
	public final static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public ExcelLibrary ExcelLibrary = new ExcelLibrary();
	public DesiredCapabilities capabilities = new DesiredCapabilities();

	@BeforeSuite
	public void extentReport() throws MalformedURLException {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		extent = new ExtentHtmlReporter("./Reports/report" + timeStamp + ".html");
		ex = new ExtentReports();
		ex.attachReporter(extent);
		extent.config().setDocumentTitle("AlphaReport");
		extent.config().setReportName("Smoke Test DashBord");

		capabilities.setCapability("deviceName", DEVICE_NAME);
		capabilities.setCapability("platformName", PLATFORM_NAME);
		capabilities.setCapability("platformVersion", PLATFORM_VERSION);
		capabilities.setCapability("automationName", AUTOMATION_NAME);
		capabilities.setCapability("appPackage", APP_PACKAGE);
		capabilities.setCapability("appActivity", APP_ACTIVITY);
//		capabilities.setCapability("app", "D:\\Shiv\\Apk\\Homecentre_com.applications.homecentre.apk");
		capabilities.setCapability("fullReset", false);
		capabilities.setCapability("noReset", false);
		capabilities.setCapability("appWaitDuration", 180000);
		capabilities.setCapability("newCommandTimeout", 180000);
		
			driver = new AndroidDriver(new URL(URL), capabilities);
			driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			

		} 

	@AfterSuite
	public void afterMethod() {
		/*try {
			if (driver != null) {
				System.out.println("Closing the Application");
				driver.quit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		ex.flush();
	}

	/*
	 * @AfterTest public void generateReport() {
	 * 
	 * ex.flush(); }
	 */
}
