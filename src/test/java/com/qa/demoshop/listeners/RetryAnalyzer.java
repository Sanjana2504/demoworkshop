package com.qa.demoshop.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	
	int count=0;
	int max_retry=3;
	public boolean retry(ITestResult result){
		if(count<max_retry)
		{
			count++;
			return true;
		}
		return false;
		
	}
	

}
 