package com.qa.demoshop.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.qa.demoshop.browswerfactory.DriverFactory;
import com.qa.demoshop.pagelayers.BooksPage;
import com.qa.demoshop.pagelayers.CheckoutPage;
import com.qa.demoshop.pagelayers.GuestRegister;
import com.qa.demoshop.pagelayers.HomePage;
import com.qa.demoshop.pagelayers.LogInPage;
import com.qa.demoshop.pagelayers.RegisterPage;
import com.qa.demoshop.pagelayers.ShoppingCartPage;
import com.qa.demoshop.pagelayers.ThankyouPage;
import com.qa.demoshop.utilities.PropertyUtility;

public class BasePage {
	WebDriver driver; // 22 --Web driver is an interface and driver is a refernce variable
	//its not local as its declared outside method
	//its a global variable as its default its accesible in this class n in this package only 
	//not outside
	//class is public means variable is not public
	public HomePage home;//23
	public RegisterPage register;//23
	public ShoppingCartPage cartPage;//28
	public BooksPage booksPage;//28
	public CheckoutPage checkout;//29
	public ThankyouPage thankyou;//30
	public GuestRegister guestregister;//01-06
	public LogInPage loginpage;//1-06
	//these are page object
	//they are public so all child class can use
	
	
	@Parameters("browser")//@browser is the name of the parameter, which is given in testng the names should match
	//this is for parallel execution ..browswer name is picked for testngparexescript n
	//n passed to setup string
	@BeforeMethod
	public void setUp(@Optional String browser) throws IOException {
		//optional so execution continues if value in parallel xml is not found 
	
		/*	driver=new ChromeDriver();//22
		driver.manage().window().maximize();//22
		driver.get("");//22 */
		
		//23-05-2026
		
		if(browser.isEmpty()) 
		{
			browser=PropertyUtility.getProperty("browserName");//and return p.getProperty(key)-returns chrome
		}
		//to load browswer from config file 
		//in propertyutility
		//fis opens path to config.properties and loads all content (k and v) to memory 
		//and return p.getProperty(key)
		driver=DriverFactory.initDriver
				(browser,Boolean.parseBoolean(PropertyUtility.getProperty("headless")));
		//browswer value fetched from config from above logic , and headless from config
		//now driver Factory init driver gets called 
		//headless value is coming from config.properties and browswer value either from parameter or config
		//everything is in string form from property file,we need false value from headless
		//flow for driverFactory--init driver
		//1.base page-->Driver Factory-->switch(browser)==chrome,firefox,edge-->browswer settings -->options created -->driver created 
		
		
		//after return getdriver() from driver factory --now driver is no longer null and all teh below lines execute
		driver.manage().window().maximize();
		driver.get(PropertyUtility.getProperty("testURL"));
		
		//base page provides driver to all pages as it has driver instance
		//so every test whic extends base page gets beolow accessand it avoids creating objects in every test
		
		//page object instances 
		//pass driver to nthem thru constructor 
		home=new HomePage(driver);//this conneccts to this.driver in home page pom
		register=new RegisterPage(driver);
		cartPage=new ShoppingCartPage(driver);//28
		booksPage=new BooksPage(driver);//28
		checkout=new CheckoutPage(driver);//29
		//here we demonstrate superkeyword 
		//so pass driver instance
		//go to checkout page
		thankyou=new ThankyouPage(driver);//30
		guestregister=new GuestRegister(driver);
		loginpage=new LogInPage(driver);
	}
	
	@AfterMethod
	public void tearDown()
	{
	//	driver.quit();22
		
		//23-05-2026
		
		DriverFactory.quitDriver();
	}
	//driver getss closed after every methiod

}
