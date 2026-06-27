package com.qa.demoshop.pagelayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.demoshop.utilities.DropDownUtility;
import com.qa.demoshop.utilities.WaitUtility;

public class CheckoutPage extends BrowserInitialization
{
	
	private By BillingAddressHeader =By.xpath("//h2[.='Billing address']");
	private By countryDropdown=By.id("BillingNewAddress_CountryId");
	private By BillingNewAddress_City=By.id("BillingNewAddress_City");
	private By BillingNewAddress_Address1=By.id("BillingNewAddress_Address1");
	private By BillingNewAddress_ZipPostalCode=By.id("BillingNewAddress_ZipPostalCode");
	private By BillingNewAddress_PhoneNumber=By.id("BillingNewAddress_PhoneNumber");
	private By BillingAddressContinueButton=By.xpath("//div[@id='billing-buttons-container']/input[@title='Continue' and @value='Continue']");
	private By ShippingAddressContinueButton=By.xpath("//input[@onclick='Shipping.save()']");
	private By ShippingMethodContinueButton=By.xpath("//input[@onclick='ShippingMethod.save()']");
	private By PaymentMethodContinueButton=By.xpath("//input[@onclick='PaymentMethod.save()']");
	private By PaymentInformationContinueButton=By.xpath("//input[@onclick='PaymentInfo.save()']");
	private By ConfirmOrderButton=By.xpath("//input[@onclick='ConfirmOrder.save()']");
	
	public CheckoutPage(WebDriver driver){
		super(driver);
	}
	public void enterBillingAddress(String country,String city,String address1,String zipCode,String phoneNumber){
		WaitUtility.checkElementContainsText(driver, BillingAddressHeader,"Billing Address");
		DropDownUtility.selectByVisibleText(driver.findElement(countryDropdown), country);
		driver.findElement(BillingNewAddress_City).sendKeys(city);
		driver.findElement(BillingNewAddress_Address1).sendKeys(address1);
		driver.findElement(BillingNewAddress_ZipPostalCode).sendKeys(zipCode);
		driver.findElement(BillingNewAddress_PhoneNumber).sendKeys(phoneNumber);
		driver.findElement(BillingAddressContinueButton).click();
	}	
	public void ShippingAddressContinueButton(){
		WaitUtility.checkElementIsVisible(driver, ShippingAddressContinueButton).click();
	}
	
	public void clickOnShippingMethodContinue(){
		WaitUtility.checkElementIsVisible(driver, ShippingMethodContinueButton).click();
	}
	public void clickOnPaymentMethodContinue(){
		WaitUtility.checkElementIsVisible(driver, PaymentMethodContinueButton).click();	
	}
	public void paymentInformationContinueButton(){
		WaitUtility.checkElementIsVisible(driver, PaymentInformationContinueButton).click();	
	}
	public void ConfirmOrderButton(){
		WaitUtility.checkElementIsVisible(driver, ConfirmOrderButton).click();	
	}
}
