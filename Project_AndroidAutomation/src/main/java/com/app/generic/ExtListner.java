package com.app.generic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;


public class ExtListner implements ITestListener {
	
	
	/*
	 * Description: On Test Starts Create a report based on @Test Method Name
	 */
	
	
	public void onTestStart(ITestResult result) {
		BaseTest.logger = BaseTest.ex.createTest(result.getName());

	}

	/* 
	 * Description: On Test Success Write Status Passed to Extent Report
	 */
	public void onTestSuccess(ITestResult result ) {
		String timeStamp =new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot t = (TakesScreenshot) BaseTest.driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src,
					new File("./ScreenShotPass//"
							+ result.getName() + timeStamp+".png"));
			BaseTest.logger.log(Status.PASS,
					"ScreenShotPass" + BaseTest.logger.addScreenCaptureFromPath(
							"D://Shiv//AndroidProject//Project_AndroidAutomation//ScreenShotPass/"
									+ result.getName() + timeStamp+".png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		
	}
	}

	/*
	 * Description: On Test Failure Write Status Failed to Extent Report With Label
	 * RED
	 */
	public void onTestFailure(ITestResult result) {
		BaseTest.logger = BaseTest.ex.createTest(result.getName());
		TakesScreenshot t = (TakesScreenshot) BaseTest.driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src,
					new File("./ScreenShotFail//"
							+ result.getName() + ".png"));
			BaseTest.logger.log(Status.FAIL,
					"ScreenShotFail" + BaseTest.logger.addScreenCaptureFromPath(
							"D://Shiv//AndroidProject//Project_AndroidAutomation//ScreenShotFail/"
									+ result.getName() + ".png"));
			BaseTest.logger.log(Status.FAIL, result.getThrowable());
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	/* 
	 * Description: On Test Skipped Write Status Skipped to Extent Report With Label
	 * YELLOW
	 */
	public void onTestSkipped(ITestResult result) {
		BaseTest.logger = BaseTest.ex.createTest(result.getName());
		TakesScreenshot t = (TakesScreenshot) BaseTest.driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src,
					new File("./ScreenShotSkip//"
							+ result.getName() + ".png"));
			BaseTest.logger.log(Status.SKIP,
					"ScreenShotSkip" + BaseTest.logger.addScreenCaptureFromPath(
							"D://AndroidProject//ScreenShotSkip"
									+ result.getName() + ".png"));
			BaseTest.logger.log(Status.SKIP, result.getThrowable());
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}
	
	
	
	
	
	
	
//	public void onTestStart(ITestResult result) {
//        BaseTest.logger = BaseTest.ex.createTest(result.getName());
//
//    }
//
//    /*
//     * 
//     *
//     * Description: On Test Success Write Status Passed to Extent Report
//     */
//    public void onTestSuccess(ITestResult result ) {
//        String timeStamp =new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//        TakesScreenshot t = (TakesScreenshot) BaseTest.driver;
//        File src = t.getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(src,
//                    new File("./ScreenShotPass//"
//                            + result.getName() + timeStamp+".png"));
//            BaseTest.logger.log(Status.PASS,
//                    "ScreenShotPass" + BaseTest.logger.addScreenCaptureFromPath(
//                            "D://Kunal//KK_Appium_Max//ScreenShotPass/"
//                                    + result.getName() + timeStamp+".png"));
//            
//        } catch (IOException e) {
//            e.printStackTrace();
//        
//    }
//    }
//
//    /*
//     * 
//     *
//     * Description: On Test Failure Write Status Failed to Extent Report With Label
//     * RED
//     */
//    public void onTestFailure(ITestResult result) {
//        BaseTest.logger = BaseTest.ex.createTest(result.getName());
//        TakesScreenshot t = (TakesScreenshot) BaseTest.driver;
//        File src = t.getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(src,
//                    new File("./ScreenShotFail//"
//                            + result.getName() + ".png"));
//            BaseTest.logger.log(Status.FAIL,
//                    "ScreenShotFail" + BaseTest.logger.addScreenCaptureFromPath(
//                            "D://Kunal//KK_Appium_Max//ScreenShotFail/"
//                                    + result.getName() + ".png"));
//            BaseTest.logger.log(Status.FAIL, result.getThrowable());
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }
//
//    }
//
//    /*
//     * 
//     *
//     * Description: On Test Skipped Write Status Skipped to Extent Report With Label
//     * YELLOW
//     */
//    public void onTestSkipped(ITestResult result) {
//        BaseTest.logger = BaseTest.ex.createTest(result.getName());
//        TakesScreenshot t = (TakesScreenshot) BaseTest.driver;
//        File src = t.getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(src,
//                    new File("./ScreenShotSkip//"
//                            + result.getName() + ".png"));
//            BaseTest.logger.log(Status.SKIP,
//                    "ScreenShotSkip" + BaseTest.logger.addScreenCaptureFromPath(
//                            "D://AndroidProject//ScreenShotSkip"
//                                    + result.getName() + ".png"));
//            BaseTest.logger.log(Status.SKIP, result.getThrowable());
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }
//
//    }
//
//    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//        // TODO Auto-generated method stub
//
//    }
//
//    public void onStart(ITestContext context) {
//        
//
//    }
//
//    public void onFinish(ITestContext context) {
//        // TODO Auto-generated method stub
//
//    }
//	
}





