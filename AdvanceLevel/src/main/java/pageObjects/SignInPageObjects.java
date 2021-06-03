package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;
import testBase.DriverFactory;
import testBase.TestBase;

public class SignInPageObjects extends TestBase
{

	/*@FindBy(xpath="(//a[contains(text(),'Sign In')])[1]")
	WebElement signInLink;
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="userLoginButton")
	WebElement loginButton;
	
	public SignInPageObjects(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		//this keyword represent present class instances
	}*/
	
	
	By username = By.id("username");
	By password = By.id("password");
	By signInLink = By.xpath("//button[@class='btn__primary--large from__button--floating']");
	
	
	public void login(String usernameData,String pwd)
	{
		//DriverFactory.getInstances().getDriver().findElement(signInLink);
		
		sendKeys_Custom(DriverFactory.getInstances().getDriver().findElement(username),usernameData, "usernameField");
		sendKeys_Custom(DriverFactory.getInstances().getDriver().findElement(password),pwd, "passwordField");
		click_Custom(DriverFactory.getInstances().getDriver().findElement(signInLink), "sigInButtonFields");
		
		
	}
}
