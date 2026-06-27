//23-05-2026

package com.qa.demoshop.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.demoshop.base.BasePage;
import com.qa.demoshop.dataproviders.RegisterDataProvider;
import com.qa.demoshop.utilities.FakeDataGenerator;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class RegisterTest extends BasePage {
	
	@Epic("e-commerce")
	
	//25-05-2026
	@Test(priority=0)
	@Story("Verify register")
	@Description("register page check")
	@Severity(SeverityLevel.CRITICAL)
	@Owner("Sanjana")
	//Allure report annotations to improve readability and to categorize test cases 
	public void verifyRegisterPage()
	{//to verify if we are in register page 
		home.clickregisterLink();
		//home--clcikregisterlinkmethod runs -wait utility-clciks link
		Assert.assertEquals(register.getregisterHeader(), "Register");
		//gets test from register page which gets from wait page 
		//Assert.fail();//30-to check screenshot
		System.out.println("====VERIFIED REGISTER PAGE====");
		//Assert.assertEquals(false, true);// to  check transformer
		
	}
	
	@Test(priority = 1
			)
	public void resgisterShopper()
	{
		//RegisterPagePOM--pageLayers
		
		home.clickregisterLink();
		//home -click reg link executes
		String rEmail="sanj"+RandomStringUtils.randomAlphanumeric(6)+"@gmail.com";
		//no dup emails allowed
		register.registerUser("MALE", "admin", "admin12", rEmail, "ad@1ADCCC2", "ad@1ADCCC2");
		//25-05-2026
		Assert.assertEquals(register.getSuccessMsg(), "Your registration completed");
		//Assert.fail();//30-to check screenshot and retries for allure report and listener 
		System.out.println("===="+register.getSuccessMsg()+"====");
		//passes all params n clicks register button 
		//gets success message for validation 
	}
	
	//27-05-20268
	
	@Test(
		    priority = 2,
		    dataProvider = "registerdata",
		   
		    dataProviderClass = RegisterDataProvider.class,
		    //register data in this class --so method will return all rows from excel 
		    //calls registerdataprovider
		    enabled=false
		)
		public void registerMultipleUsers(String gender,
		                            String firstname,
		                            String lastname,
		                            String email,
		                            String password,
		                            String confirmPassword)
		{
		    home.clickregisterLink();

		    register.registerUser(
		        gender,
		        firstname,
		        lastname,
		        email,
		        password,
		        confirmPassword
		    );
		    Assert.assertEquals(register.getSuccessMsg(), "Your registration completed");
		      
		 

		    System.out.println("====" + register.getSuccessMsg() + "====");
		}
	
	@Test(enabled=false)
	public void mouseHoveringOnComputer() throws InterruptedException
	{
		home.performMouseHoveringOnComputer();
	}
	
	//register with faker
	
	@Test(priority = 0, enabled=false)
	public void resgisterShopperfaker()
	{
		//RegisterPagePOM--pageLayers
		
		home.clickregisterLink();
		//String rEmail="sanj"+RandomStringUtils.randomAlphanumeric(6)+"@gmail.com";
		String pass=FakeDataGenerator.getPassword();
		register.registerUser(FakeDataGenerator.getGender(), 
				FakeDataGenerator.getFirstName(), FakeDataGenerator.getLastName(),
				FakeDataGenerator.getEmail(),pass ,pass );
		
		Assert.assertEquals(register.getSuccessMsg(), "Your registration completed");
		//Assert.fail();//30-to check screenshot
		System.out.println("===="+register.getSuccessMsg()+"====");
		
	}
	//all inbuilt methods 
	
	

}
