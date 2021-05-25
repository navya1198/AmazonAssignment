package com.maven.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	
	@BeforeTest
	public WebDriver setupDriver() throws IOException
	{
		
		driver=new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
		prop=new Properties();
		FileInputStream file=new FileInputStream("C://AutomationFrameworkHeaderAndFooter//AmazonAssignment//config.properties");
		prop.load(file);
		
		driver.get(prop.getProperty("url"));
		return driver;
	}

   
	static String getData(String row, String col) throws FilloException {
		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection(
				"C:\\ECOMM_ONE_CLICK\\practise\\src\\test\\java\\com\\practise\\testdata\\eVMITestData.xlsx");
		String val = "";
		String strQuery = "Select * from CMI_TESTDATA where Role = " + "'" + row + "'";
		Recordset recordset = connection.executeQuery(strQuery);
		
		while (recordset.next()) {
			System.out.println(recordset.getField(col));
			val = recordset.getField(col);

		}
		return val;

	}
}
