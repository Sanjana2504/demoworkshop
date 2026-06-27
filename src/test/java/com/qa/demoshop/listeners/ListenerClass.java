package com.qa.demoshop.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.qa.demoshop.browswerfactory.DriverFactory;
import com.qa.demoshop.utilities.ScreenshotUtility;

public class ListenerClass implements ITestListener {
	
	public void onStart(ITestContext context)
	{
	Reporter.log("===EXECUTION STARTED===",true);
	}
	public void onTestStart(ITestResult result)
	{
	Reporter.log("==="+result.getName()+"EXECUTION STARTED====",true);
	}
	public void onTestSuccess(ITestResult result)
	{
	Reporter.log("==="+result.getName()+"PASSED===",true);
	}
	public void onTestFailure(ITestResult result)
	{
		//30-05-2026
		try {
			ScreenshotUtility.captureScreenshot(DriverFactory.getDriver(), result.getName());
		}
		catch(IOException e){
			e.printStackTrace();
			
		}
	Reporter.log("==="+result.getName()+"FAILED===",true);
	}
	public void onTestSkipped(ITestResult result)
	{
	Reporter.log("==="+result.getName()+"SKIPPED===",true);
	}
	public void onFinish(ITestResult contexT)
	{
	Reporter.log("===EXECUTION FINISHED===",true);
	}

}
