package com.qa.demoshop.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActionUtility {
	public static Actions getActions(WebDriver driver) {
		
		return new Actions(driver);
	}
public static void mouseHovering(WebDriver driver, WebElement element) {
		
		getActions(driver).moveToElement(element).perform();
	}

public static void doubleClick(WebDriver driver, WebElement element) {
	
	getActions(driver).doubleClick(element).perform();
}
public static void rightClick(WebDriver driver, WebElement element) {
	
	getActions(driver).contextClick(element).perform();
}
public static void dragAndDrop(WebDriver driver, WebElement srcElement, WebElement dstElement) {
	
	getActions(driver).dragAndDrop(srcElement,dstElement).perform();
}
}
