package com.qa.demoshop.pagelayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.demoshop.utilities.WaitUtility;

public class LogInPage {
	
private WebDriver driver;
private By LoginLink=By.xpath("//a[@href='/login']");
private By LoginButton=By.xpath("//input[@value='Log in']");
	
	public LogInPage(WebDriver driver) {
		this.driver=driver;
	}
	
	  public void LoginLinkClick() {
	    	WaitUtility.checkElementIsVisible(driver, LoginLink).click();
	    }
	
	  public void LoginButtonClick() {
	    	WaitUtility.checkElementIsVisible(driver, LoginButton).click();
	    }

}
