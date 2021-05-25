package com.maven.AmazonAssignment;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.maven.BaseClass.BaseClass;

public class ReviewRC extends BaseClass {

	public ReviewRC(WebDriver driver) {
		this.driver=driver;
	}

	public void scrollVerticallyUntilTheVisibilityOfElement() {
		// TODO Auto-generated method stub
		WebElement lastElement = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Compare with similar items')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",lastElement);
	}

	public void getAllTheItemToCompare() throws InterruptedException {
		// TODO Auto-generated method stub
		List<WebElement> priceOfItems = driver.findElements(By.xpath("//span[@class='a-size-large a-color-price a-text-bold']"));
		List<String> priceOfEachItems =new ArrayList<String>();
		List<String> ratingOfEachItems =new ArrayList<String>();
		for(WebElement a:priceOfItems)
		{
		String prices=a.getText();
//		System.out.println(prices.replace("? ", "").split("\\."));
		System.out.println(prices.replaceAll("[^0-9]", ""));
		
		priceOfEachItems.add(prices.replaceAll("[^0-9]", ""));
		
		}
		//System.out.println();
		int j=7;
		for(int i=1; i<priceOfItems.size()+1;i++)
		{
			Actions action=new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//*[@id='HLCXComparisonTable']/tbody/tr[3]/td["+i+"]/span/span[1]/i"))).perform();
			Thread.sleep(2000);
			String text=driver.findElement(By.xpath("//*[@id='a-popover-content-"+j+"']/div/div/div/div[1]/span")).getText();
			j++;
		    System.out.println(text.replaceAll("\\s.*", ""));
		    ratingOfEachItems.add(text.replaceAll("\\s.*", ""));
		    
		}
		ArrayList<Integer> ratinInt =new ArrayList<Integer>();
		for(String s : priceOfEachItems) 
		{
			ratinInt.add(Integer.valueOf(s));
		}
		
		System.out.println(ratinInt);
		
		ArrayList<Float> ratingInt =new ArrayList<Float>();
		for(String s : ratingOfEachItems) 
		{
			ratingInt.add(Float.valueOf(s));
		}
		System.out.println(ratingInt);
		int a=ratinInt.get(0);
		Float b=ratingInt.get(0);
		for(int i=1; i<ratinInt.size(); i++)
		{
			
			if(a<=ratinInt.get(i) || b>=ratingInt.get(i))
			{
				System.out.println("--------ITEMS ---------");
				System.out.println("Rating of the Item: "+ratinInt.get(i));
				System.out.println("Price of the Item: "+ratingInt.get(i));
				String desc=driver.findElement(By.xpath("(//div[@class='a-row a-spacing-top-medium']//span)["+i+"]")).getText();
				String batteryPower=driver.findElement(By.xpath("//*[@id='HLCXComparisonTable']/tbody/tr[10]/td["+i+"]")).getText();
				String processorBrand=driver.findElement(By.xpath("//*[@id='HLCXComparisonTable']/tbody/tr[14]/td["+i+"]")).getText();
				System.out.println("Descripton of the Item: "+desc);
				System.out.println("Battery Power of the Item: "+batteryPower);
				System.out.println("Processor Brand of the Item: "+processorBrand);
			}
		}

}

	public void getFilteredReviews() {
		// TODO Auto-generated method stub
		
	}

	}
