
//28-05-2026
package com.qa.demoshop.pagelayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.demoshop.utilities.DropDownUtility;
import com.qa.demoshop.utilities.WaitUtility;

public class ShoppingCartPage {
private By countryDropDown=By.id("CountryId");
private By checkout=By.id("checkout");
private By termsOfService=By.id("termsofservice");
private WebDriver driver;

public ShoppingCartPage(WebDriver driver) {
	this.driver=driver;
}

public void SelectCountryByVisibleText(String countryName) {
	DropDownUtility.selectByVisibleText(WaitUtility.checkElementIsVisible(driver, countryDropDown), countryName);
}
public void clickOnCheckOut(){
	WaitUtility.checkElementIsVisible(driver, checkout).click();
}

public void clickTermsOfService() {
	WaitUtility.checkElementIsVisible(driver, termsOfService).click();
}

}
