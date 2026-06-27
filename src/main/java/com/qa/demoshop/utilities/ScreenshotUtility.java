package com.qa.demoshop.utilities;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import io.qameta.allure.Allure;

public class ScreenshotUtility {
	
	public static File captureScreenshot(WebDriver driver, String name) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File temp=ts.getScreenshotAs(OutputType.FILE);
		String dateTime=LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss"));
		File perm=new File("./src/test/resources/Screenshot/"+name+"_"+dateTime+".png");
		FileHandler.copy(temp,perm);
		return perm;
		
	}
	
	public static void attachScreenshot(WebDriver driver)
	{
		byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		
		Allure.addAttachment("failure screenshot", new ByteArrayInputStream(screenshot));
	}

}
