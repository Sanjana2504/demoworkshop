package com.qa.demoshop.browswerfactory;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;

public class BrowserSettings {
	public static ChromeOptions getchromeOptions(boolean headless)
	{
		//method receives headless value from driverfactory
		ChromeOptions opts=new ChromeOptions();
		if(headless)
			//false condition fails
			//if true 
		{
			opts.addArguments("--headless");
			Reporter.log("== THIS IS EXECUTING IN HEADLESS MODE",true);//handling notification popus logic 
		}
		return opts;//returns chrome options object--false
		//
	}
	public static FirefoxOptions getFirefoxOptions(boolean headless)
	{
		FirefoxOptions opts=new FirefoxOptions();
		if(headless)
		{
			opts.addArguments("--headless");
			Reporter.log("== THIS IS EXECUTING IN HEADLESS MODE",true);
			
		}
		return opts;
	}
	public static EdgeOptions getEdgeOptions(boolean headless)
	{
		EdgeOptions opts=new EdgeOptions();
		if(headless)
		{
			opts.addArguments("--headless");
			Reporter.log("== THIS IS EXECUTING IN HEADLESS MODE",true);
			
		}
		return opts;
	}

}
