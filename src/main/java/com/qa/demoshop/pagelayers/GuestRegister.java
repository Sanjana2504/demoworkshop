package com.qa.demoshop.pagelayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.demoshop.utilities.DropDownUtility;
import com.qa.demoshop.utilities.WaitUtility;

public class GuestRegister {
	
	private By BillingAddressHeader =By.xpath("//h2[.='Billing address']");
	private By countryDropdown=By.id("BillingNewAddress_CountryId");
	private By CheckoutGuestButton =By.xpath("//input[@value='Checkout as Guest']");
	private By FirstName=By.id("BillingNewAddress_FirstName");
	private By LastName=By.id("BillingNewAddress_LastName");
	private By Email=By.id("BillingNewAddress_Email");
	private By BillingNewAddress_City=By.id("BillingNewAddress_City");
	private By BillingNewAddress_Address1=By.id("BillingNewAddress_Address1");
	private By BillingNewAddress_ZipPostalCode=By.id("BillingNewAddress_ZipPostalCode");
	private By BillingNewAddress_PhoneNumber=By.id("BillingNewAddress_PhoneNumber");
	private By BillingAddressContinueButton=By.xpath("//div[@id='billing-buttons-container']/input[@title='Continue' and @value='Continue']");
	

	
	
	private WebDriver driver;
	

	public GuestRegister(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void CheckoutAsGuestButton(){
		WaitUtility.checkElementIsVisible(driver, CheckoutGuestButton).click();	
	}
	
	public void enterGuestBillingAddress(String firstName,String lastName,String email, String country,String city,String address1,String zipCode,String phoneNumber){
		WaitUtility.checkElementContainsText(driver, BillingAddressHeader,"Billing Address");
		DropDownUtility.selectByVisibleText(driver.findElement(countryDropdown), country);
		driver.findElement(FirstName).sendKeys(firstName);
		driver.findElement(LastName).sendKeys(lastName);
		driver.findElement(Email).sendKeys(email);	
		driver.findElement(BillingNewAddress_City).sendKeys(city);
		driver.findElement(BillingNewAddress_Address1).sendKeys(address1);
		driver.findElement(BillingNewAddress_ZipPostalCode).sendKeys(zipCode);
		driver.findElement(BillingNewAddress_PhoneNumber).sendKeys(phoneNumber);
		driver.findElement(BillingAddressContinueButton).click();
	}	
	
	
	
	
}
