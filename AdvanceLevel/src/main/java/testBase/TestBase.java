package testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import reusableComponents.ActionEngine;
import reusableComponents.PropertiesOperations;

public class TestBase extends ActionEngine{

	BrowserFactory bf = new BrowserFactory();

	@BeforeMethod
	public void LaunchApplication() throws Exception {
		String browser = PropertiesOperations.getPropertyValueByKey("browser");
		String url=PropertiesOperations.getPropertyValueByKey("url"); 

		//String url = "https://www.mscdirect.com";

		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * System.getProperty("user.dir") + "//LatestDriver//chromedriver.exe");
		 * WebDriver driver=new ChromeDriver();
		 */
		// WebDriver driver=DriverFactory.getInstances().getDriver();

		DriverFactory.getInstances().setDriver(bf.createBrowserInstance(browser));
		WebDriver driver = DriverFactory.getInstances().getDriver();
		// WebDriver driverInstance=bf.createBrowserInstance(browser);

		/*
		 * WebDriverManager.chromedriver().version("88.0").setup(); WebDriver
		 * driver=new ChromeDriver();
		 */

		driver.get("https://www.linkedin.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.getInstances().closeBrowser();
	}

}
