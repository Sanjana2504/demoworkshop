package com.qa.demoshop.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.demoshop.base.BasePage;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;



public class CheckOutTest extends BasePage {
	
	static Logger log=LogManager.getLogger(CheckOutTest.class);
	
	
	
	//28-05-2026
	@Test
	@Epic("e-commerce")
	@Story("valid checout")
	@Feature("checkout")
	@Description("user valid checkout")
	@Owner("Sanjana")
	public void checkoutProduct()
	{
		String rEmail="Sanju"+RandomStringUtils.randomAlphanumeric(6)+"@gmail.com";
		home.clickregisterLink();
		register.registerUser("Female", "Sanju", "Ram", rEmail, "A@admin787", "A@admin787");
		//System.out.println("===[ REGISTERED ]===");
		log.info("USER REGISTERED");
		Allure.step("USER REGISTERED");
		//29-05-2026
		home.clickOnBooks();
		booksPage.clickAddToCartOfFirstProduct();
		log.info("PRODUCT ADDED");
		Allure.step("PRODUCT ADDED");
		home.clickShoppingCartLink();
		cartPage.SelectCountryByVisibleText("India");
		cartPage.clickTermsOfService();
		cartPage.clickOnCheckOut();
		log.info("CHECKED OUT");
		Allure.step("CHECKED OUT");
		checkout.enterBillingAddress("India", "Bangalore", "Rajaji", "560010", "9866756564");
		log.info("ADDRESS ADDED");
		Allure.step("ADDRESS ADDED");
		checkout.ShippingAddressContinueButton();
		checkout.clickOnShippingMethodContinue();
		log.info("SHIPPING METHOD ADDED");
		Allure.step("SHIPPING METHOD ADDED");
		checkout.clickOnPaymentMethodContinue();
		log.info("PAYMENT METHOD ADDED");
		Allure.step("PAYMENT METHOD ADDED");
		checkout.paymentInformationContinueButton();
		log.info("PAYMENT INFORMATION ADDED");
		checkout.ConfirmOrderButton();
		log.info(" ORDER IS CONFIRMED");
		Allure.step("ORDER IS CONFIRMED");//this you can add in method(here confirmorderbutton) to avoid repetation of this everywhere and to make it print everytime the method is called.
		Assert.assertEquals(thankyou.getSuccessMessage(), "Your order has been successfully processed!");
		//System.out.println("===[ ORDER IS CONFIRMED ]===");
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
