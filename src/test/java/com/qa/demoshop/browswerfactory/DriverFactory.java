package com.qa.demoshop.browswerfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;

//23-05-2026

public class DriverFactory { //this class to launch broswer with options
static ThreadLocal<WebDriver> threadLocal=new ThreadLocal<>();
//threadlocal is like a separate storage box for each thread//parallel excution will get overridden without this 

public static WebDriver getDriver() {
	return threadLocal.get();
	//this is inbuilt
	//think of threadlocal like a locker //set launches browswer--see below--it puts chromedriver iwth opts in locker
	//now get will give us what we stored in locker --it will return chrome driver object 
	//different threads can use this 
	//we created getdriver method so threadLocal.get() isnt weritten everywhere 
}
//gives driver stored for current thread 

//Thraed local only for parallel execution--to maintake sepearate driver for each thread so no browswer overrides another
public static WebDriver initDriver(String browserName, boolean headless)//26
{
	//from base page if browswer name is firefox and headless is false 
	//execute switch below 
	switch(browserName)
	{
	case "chrome" :  
		//26
		ChromeOptions chromeopts=BrowserSettings.getchromeOptions(headless);
		//value for headless will be substituted//go to broswer setting
		threadLocal.set(new ChromeDriver(chromeopts));//launches broswer with settings
		//and creates chromedriver with current thread
		//these two lines are advanced version of launching browswer
		//before wd d= new cd launches with default setting
		//here we prepare browswer settings pass settings and launch browswer
		//threadlocal used cause of parallel execution
		Reporter.log("== IT IS EXECUTING IN CHROME BROWSER==",true);//Logic of handling notification popus
		//threadLocal.set(new ChromeDriver());
	break;
	case "firefox" : 
		//26
		FirefoxOptions fireopts=BrowserSettings.getFirefoxOptions(headless);
		threadLocal.set(new FirefoxDriver(fireopts));
		Reporter.log("== IT IS EXECUTING IN FireFox BROWSER==",true);//true prints in report and console else only in report
		
		//threadLocal.set(new FirefoxDriver());
	break;
	case "edge" : 
		//26
		EdgeOptions edgeopts=BrowserSettings.getEdgeOptions(headless);
		threadLocal.set(new EdgeDriver(edgeopts));
		Reporter.log("== IT IS EXECUTING IN Edge BROWSER==",true);
		
		//threadLocal.set(new EdgeDriver());
	break;
	}
	return getDriver();
	//sset sets everything and get driver method has get which will allow access to all setting and this we are returning to base page where init driver is called
	//now refer to base page before maximize line
}
public static void quitDriver()
{
	getDriver().quit();//to close browswer--we need to turn off tv before throwing remote that is belwo statememts //removing object from memory 
	threadLocal.remove();//clear current thread box  or memory leak can happen//removing reference from memory
}

}
