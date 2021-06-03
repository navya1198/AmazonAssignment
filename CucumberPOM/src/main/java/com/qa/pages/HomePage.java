package com.qa.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class HomePage extends TestBase{

	
	@FindBy(xpath="//a[@class='_1_3w1N']")
	WebElement loginButton;
	
	@FindBy(xpath="//div[@class='exehdJ']")
	WebElement moreLink;
	
	@FindBy(xpath="//a[@class='_3SkBxJ']")
	WebElement cartButton;
	
	@FindBy(xpath="///input[@name='q']")
	WebElement searchBar;
	
	

	public HomePage()
	{
		PageFactory.initElements(driver, this);
		//this.driver=driver;
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public Boolean verifySearchBarPresence()
	{
		return searchBar.isDisplayed();
	}
	
	public void mouseHoverOnMoreLink()
	{
		
		Actions action=new Actions(driver);
		action.moveToElement(moreLink).build().perform();
		
		
	}
	
}
