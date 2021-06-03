package com.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.base.Verify;
import com.qa.util.TestBase;

public class LoginPage extends TestBase{

	LoginPage log;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	WebElement loginButton;
	
	@FindBy(xpath="//input[@class='_2IX_2- VJZDxU']")
	WebElement email;
	
	@FindBy(xpath="//input[@class='_2IX_2- _3mctLh VJZDxU']")
	WebElement password;
	

	@FindBy(xpath="//div[@class='_3oBhRa col col-2-5 _4H6HH5']")
	WebElement image;
	
	//Initializing the Page Objects
	//this means intialize all webelements
	public LoginPage(WebDriver driver)
	{
	    PageFactory.initElements(driver, this);
	  //  this.driver=driver;
	}
	
	public String validatePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateImage()
	{
		return image.isDisplayed();
			
	}
	
	public HomePage loginHomePage(String username, String password) throws InterruptedException
	{
		//super.initialization();
		log = new LoginPage(driver);
		Thread.sleep(4000);
		System.out.println(username);
		System.out.println(password);
		
		
		email.sendKeys(username);
		email.sendKeys(password);
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginButton);
		return new HomePage();
		
		
		
	}
	
}
