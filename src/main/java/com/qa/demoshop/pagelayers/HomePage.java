package com.qa.demoshop.pagelayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.demoshop.utilities.MouseActionUtility;
import com.qa.demoshop.utilities.WaitUtility;

public class HomePage {
	

	private By registerlink=By.xpath("//a[@href='/register']");
	private By computerHeader=By.xpath("//div[@class='header-menu']/ul/li/a[@href='/computers']");
	private By shoppingCartLink=By.xpath("//span[.='Shopping cart']");
	private By booksTab=By.xpath("//ul[@class='top-menu']/li[1]/a[contains(.,'Books')]");
	private WebDriver driver;

	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}

	public void clickregisterLink() {
		WaitUtility.checkElementIsVisible(driver, registerlink).click();
		
	}
	
	//28-05-2026

	public void clickShoppingCartLink() {
		WaitUtility.checkElementIsVisible(driver, shoppingCartLink).click();
		
	}
	
	public void performMouseHoveringOnComputer()
	{
		MouseActionUtility.mouseHovering(driver, WaitUtility.checkElementIsVisible(driver, computerHeader));
	}

	//28-05-2026

	public void clickOnBooks() {
		WaitUtility.checkElementIsVisible(driver, booksTab).click();
	}
}
