package reusableComponents;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import testBase.DriverFactory;
import testBase.ExtentFactory;

public class ActionEngine {

	public void sendKeys_Custom(WebElement element, String valueToBeSent, String fieldName) {
		try {
			element.sendKeys(valueToBeSent);
			ExtentFactory.getInstance().getExtent().log(Status.PASS,
					fieldName + "==>Entered value as " + valueToBeSent);
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL,
					"value enter in field: " + fieldName + " is failed due to exception");
		}

	}

	public void click_Custom(WebElement element, String fieldName) {
		try {
			element.click();
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName + "==> clicked Successfully");
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Unable to click==> " + fieldName);
		}
	}

	public void assertEqualsString_custom(String expValue, String actualValue, String locatorName) {
		try {
			Assert.assertEquals(expValue, actualValue);
			ExtentFactory.getInstance().getExtent().log(Status.PASS,
					"String Assertion is successful on field" + locatorName + "Expected matches Actual Value");
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL,
					"String Assertion failed " + locatorName + "Expected didn't matches Actual Value");
		}
	}

	public void getText_Custom(WebElement element, String fieldName) {
		String text = "";
		try {
			text = element.getText();
			ExtentFactory.getInstance().getExtent().log(Status.PASS, text + "==>field name retrieved");
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, text + "==>Not able retrive field name");
		}
	}

	public void selectDropDownByVisibleText_custom(WebElement element, String fieldName, String ddValue,
			String valueOfDropdown) {
		try {
			Select select = new Select(element);
			if (valueOfDropdown.equalsIgnoreCase("SelectByvisibleText")) {
				select.selectByVisibleText(ddValue);
				ExtentFactory.getInstance().getExtent().log(Status.PASS,
						fieldName + "==> Dropdown value selected by Visible text");

			} else if (valueOfDropdown.equalsIgnoreCase("SelectByvalue")) {
				select.deselectByValue(ddValue);
				ExtentFactory.getInstance().getExtent().log(Status.PASS,
						fieldName + "==> Dropdown value selected by Value");
			} else {
				ExtentFactory.getInstance().getExtent().log(Status.WARNING, fieldName + "==> Check the Value sent");
			}
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, fieldName + "==> Dropdown value Exception");
		}
	}
	
	public void moveToElement_custom(WebElement element, String fieldName)
	{
		try {
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstances().getDriver();
			executor.executeScript("arguments[0].scrollIntoView(true);",element);
			Actions actions = new Actions(DriverFactory.getInstances().getDriver());
			actions.moveToElement(element).build().perform();
			ExtentFactory.getInstance().getExtent().log(Status.PASS,
					fieldName + "==>MouseHovered Successfully");
			
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.PASS,
					fieldName + "==>Unable to MouseHover on this field");
		}
	}
	
	public boolean isElementPresent_custom(WebElement element,String fieldName)
	{
		boolean flag=false;
		try {
			flag=element.isDisplayed();
			ExtentFactory.getInstance().getExtent().log(Status.PASS,
					fieldName + "==>Element displayed Successfully");
			
			return flag;
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL,
					fieldName + "==>Element is not displayed");
			
		}
		return flag;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
