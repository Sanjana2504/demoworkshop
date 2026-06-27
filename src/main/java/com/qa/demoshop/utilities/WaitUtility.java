package com.qa.demoshop.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	public static WebElement checkElementIsVisible(WebDriver driver,By locater)
	{
		return new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.visibilityOfElementLocated(locater));
	}
	
	public static Boolean checkElementContainsText(WebDriver driver,By locator,String text)
	{
		return new WebDriverWait(driver,Duration.ofSeconds(10))
				.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}

}
