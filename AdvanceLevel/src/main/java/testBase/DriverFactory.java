package testBase;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	//Design Pattern - represents best practises
	//sigleton design pattern - only one instance exist ever, provides global access to that instances by creating getInstances method
	//factory design pattern - 

	//private constructors so that no one else can create abject of this class
	private DriverFactory()
	{
		
	}
	
	private static DriverFactory instance = new DriverFactory();
	
	
	//global access provider
	public static DriverFactory getInstances()
	{
		return instance;
		
	}
	
	//factory design pattern --> define separate factory methods for creating object and create object by calling method
	ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	
	public WebDriver getDriver()
	{
		return driver.get(); 
	}
	public void setDriver(WebDriver driverParm)
	{
		driver.set(driverParm);
	}
	
	public void closeBrowser()
	{
		driver.get().close();
		driver.remove();
	}
}
