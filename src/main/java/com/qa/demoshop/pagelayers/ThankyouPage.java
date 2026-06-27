package com.qa.demoshop.pagelayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.demoshop.utilities.WaitUtility;

public class ThankyouPage extends BrowserInitialization {
	

	private By successMessage=By.xpath("//div[@class='title']");
	
	public ThankyouPage(WebDriver driver) {
		super(driver);
	}
	
	public String getSuccessMessage()
	{
		return WaitUtility.checkElementIsVisible(driver, successMessage).getText();
	}

}
