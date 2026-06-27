package com.qa.demoshop.listeners;


import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.demoshop.browswerfactory.DriverFactory;
import com.qa.demoshop.utilities.*;

public class AllureListener implements ITestListener {
	
	public void onTestFailure(ITestResult result)
	{
	     ScreenshotUtility.attachScreenshot(DriverFactory.getDriver());
	}

}
