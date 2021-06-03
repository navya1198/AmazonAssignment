package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	//create webdriver object for goven browser
	public WebDriver createBrowserInstance(String browser)
	{
		WebDriver driver=null;
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			/*WebDriverManager.chromedriver().version("89.0").setup();
			driver=new ChromeDriver();*/
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//LatestDriver//chromedriver.exe");
	        driver=new ChromeDriver();
			//WebDriverManager.chromedriver().version("88.0").setup();
			/*ChromeOptions options=new ChromeOptions();
			options.addArguments("--incognito");*/
		
		}
		else
		{
			WebDriverManager.firefoxdriver().version("88.0").setup();
			driver=new FirefoxDriver();
			FirefoxOptions firefoxOtions=new FirefoxOptions();
			firefoxOtions.addArguments("-private");
		}
		return driver;
	}
	
}
