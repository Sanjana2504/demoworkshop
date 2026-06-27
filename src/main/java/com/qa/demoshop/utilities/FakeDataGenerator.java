package com.qa.demoshop.utilities;

import com.github.javafaker.Faker;

public class FakeDataGenerator {
	
	static Faker faker= new Faker();
	
	public static String getFirstName()
	{
		return faker.name().firstName();
	}
	public static String getLastName()
	{
		return faker.name().lastName();
	}
	public static String getEmail()
	{
		return faker.internet().emailAddress();
	}
	public static String getPassword()
	{
		return faker.internet().password(6,10,true,true);
	}
	public static String getGender()
	{
		int number=Integer.parseInt(faker.number().digits(1));
		if(number>5)
		{
			return "MALE";
		}
		
		return "FEMALE";
	}
	
	

}
