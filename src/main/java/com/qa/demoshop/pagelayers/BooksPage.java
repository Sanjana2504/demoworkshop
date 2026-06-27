//28-05-2026

package com.qa.demoshop.pagelayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.demoshop.utilities.WaitUtility;

public class BooksPage {
	
	private By firstBook=By.xpath("(//input[@value='Add to cart'])[1]");
	private WebDriver driver;
	
	public BooksPage(WebDriver driver) {
		this.driver=driver;
	}
    public void clickAddToCartOfFirstProduct() {
    	WaitUtility.checkElementIsVisible(driver, firstBook).click();
    }
}
