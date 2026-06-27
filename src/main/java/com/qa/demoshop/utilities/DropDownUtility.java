//28-05-2026


package com.qa.demoshop.utilities;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtility {
	
	public static Select getSelect(WebElement element)
	{
		return new Select(element);
	}
	
	public static void selectByIndex(int index, WebElement element)
	{
		getSelect(element).selectByIndex(index);
	}
	
	public static void selectByVisibleText(WebElement element,String visibleText)
	{
		getSelect(element).selectByVisibleText(visibleText);
	}
	
	public static ArrayList<String> getAllOptions(WebElement element)
	{
		ArrayList<String> al=new ArrayList<String>();
		
		for(WebElement option : getSelect(element).getOptions())
		{
			al.add(option.getText());
		}
		return al;
		
	}

}
