package com.qa.demoshop.utilities;

import java.io.FileInputStream; 
import java.io.IOException;
import java.util.Properties;

import com.qa.demoshop.applicationconstants.DataHandlingConstants;

public class PropertyUtility {
	public static String getProperty(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(DataHandlingConstants.ConfigPropertyPath);
		Properties p=new Properties();
		p.load(fis);
		return p.getProperty(key);
	}

}
