package com.qa.demoshop.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.demoshop.base.BasePage;
import com.qa.demoshop.pagelayers.GuestRegister;

public class GuestWoRegister extends BasePage {
	
	//28-05-2026
		@Test
		public void guestCheckout()
		{
   String ranEmail="Sanju"+RandomStringUtils.randomAlphanumeric(6)+"@gmail.com";
	home.clickOnBooks();
	booksPage.clickAddToCartOfFirstProduct();
	home.clickShoppingCartLink();
	cartPage.SelectCountryByVisibleText("India");
	cartPage.clickTermsOfService();
	cartPage.clickOnCheckOut();
	guestregister.CheckoutAsGuestButton();
	guestregister.enterGuestBillingAddress("Sanjana", "Ramesh", ranEmail,"India", "Ban", "Raj", "560010", "7349236565");
	checkout.ShippingAddressContinueButton();
	checkout.clickOnShippingMethodContinue();
	checkout.clickOnPaymentMethodContinue();
	checkout.paymentInformationContinueButton();
	checkout.ConfirmOrderButton();
	Assert.assertEquals(thankyou.getSuccessMessage(), "Your order has been successfully processed!");
	System.out.println("===[ ORDER IS CONFIRMED ]===");	
	}
	
	

}
