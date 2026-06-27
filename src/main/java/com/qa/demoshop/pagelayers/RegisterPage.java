package com.qa.demoshop.pagelayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.demoshop.utilities.WaitUtility;

public class RegisterPage {
	//stores all resgistration related locators and actions
	//encapsuilates registration process in registerUser()
	//accepts dynamic test data thru method and param
	//uses wait utility for sunchro
	//provides methods for valiodation in test classes
	private By gender_male=By.id("gender-male");
	private By gender_female=By.id("gender-female");
	private By firstname_TF=By.id("FirstName");
	private By lastname_TF=By.id("LastName");
	private By email_TF=By.id("Email");
	private By password_TF=By.id("Password");
	private By Confirmpassword_TF=By.id("ConfirmPassword");
	private By registerButton_=By.id("register-button");
	private By successMsg=By.xpath("//div[@class='result']");//25-05-2026
	private By registerHeader=By.xpath("//div[@class='page-title']/h1");//25-05-2026
	//encapsulation is followed by class--outside world doessent know how registration happens 
	//it only knows register.registerUser()--eg for encapsuation
	private WebDriver driver;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public void registerUser(String gender, String firstname, String lastname, String email, String password, String confirmPassword) {
		if(gender.equalsIgnoreCase("Male"))
		{
		WaitUtility.checkElementIsVisible(driver, gender_male).click();
		}
		
		else if(gender.equalsIgnoreCase("Female"))
		{
			WaitUtility.checkElementIsVisible(driver, gender_female).click();
		}
		driver.findElement(firstname_TF).sendKeys(firstname);
		//left side--is private By firstname_tF
		//right side is string parameter--String firstname 
		//first finds the textfield and then types ssanjana
		driver.findElement(lastname_TF).sendKeys(lastname);
		//explicitly locating elements 
		//go to wait utility for second way 
		driver.findElement(email_TF).sendKeys(email);
		driver.findElement(password_TF).sendKeys(password);
		driver.findElement(Confirmpassword_TF).sendKeys(confirmPassword);
		driver.findElement(registerButton_).click();		
	}
	//this is a method template and value come from resgister test(dataprovider/excel/registerUser()   
	//this method is reussable )
	    
	    //25-05-2026
	    public String getSuccessMsg() {
	    	return WaitUtility.checkElementIsVisible(driver,successMsg).getText();
	    }
	    //this waits first till success messsage is visible 
	    //returns webelement
	    //calss getTest()
	    //returns string so later is RegisterTest for Assert the actual 
	    //result can be compared with expectsed
	    //25-05-2026
	    public String getregisterHeader() {
	    	return WaitUtility.checkElementIsVisible(driver, registerHeader).getText();
	    }
}
