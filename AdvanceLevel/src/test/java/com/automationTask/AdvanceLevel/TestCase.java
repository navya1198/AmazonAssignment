package com.automationTask.AdvanceLevel;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.SignInPageObjects;
import reusableComponents.ExcelOperations;
import testBase.DriverFactory;
import testBase.ExtentFactory;
import testBase.TestBase;


public class TestCase extends TestBase{

	SignInPageObjects signIn = new SignInPageObjects();
	
	ExcelOperations excel = new ExcelOperations("TestData");
	
	@Test(dataProvider="TestData")
	public void TestCase1(Object obj1)
	{
		HashMap<String,String> testData =(HashMap<String,String>) obj1;
		
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: "+testData);
		
		signIn.login(testData.get("UserName"),testData.get("Password") );
		/*System.out.println("Fist :"+ Thread.currentThread().getId());
		System.out.println("first");*/
		
		
	}
	@Test
	public void TestCase2()
	{
		signIn.login("manjumsc", "password1");
		System.out.println("Second :"+ Thread.currentThread().getId());
		System.out.println("Second");
	}
	@Test
	public void TestCase3()
	{
		signIn.login("manjumsc", "password1");
		System.out.println("Third :"+ Thread.currentThread().getId());
		System.out.println("Third");
	}
	@Test
	public void TestCase4()
	{
		signIn.login("manjumsc", "password1");
		String errTxt=DriverFactory.getInstances().getDriver().findElement(By.xpath("//div[@id='error-for-username']")).getText();
		System.out.println(errTxt);
		Assert.assertEquals("Please enter a valid usernme",errTxt);
		System.out.println("Fourth :"+ Thread.currentThread().getId());
		System.out.println("Fourth");
	}
	
	
	@DataProvider(name="TestData")
	public Object[][] testDataSupplier() 
	{
		Object[][] obj =new Object[excel.getRowCount()][1];
		for(int i=1; i<=excel.getRowCount(); i++)
		{
			HashMap<String, String> testData = excel.getTestDataInMap(i);
			obj[i-1][0]=testData;
		}
		return obj;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
