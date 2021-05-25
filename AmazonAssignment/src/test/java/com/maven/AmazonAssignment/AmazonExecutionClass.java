package com.maven.AmazonAssignment;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.maven.BaseClass.BaseClass;

public class AmazonExecutionClass extends BaseClass {

	
ReviewRC rc;
	
	@Test
	public void composeEmail() throws InterruptedException, IOException
	{
		
		ReviewRC rc=new ReviewRC(driver);
		driver.manage().window().maximize();
		driver.getTitle();
		rc.scrollVerticallyUntilTheVisibilityOfElement();
		rc.getAllTheItemToCompare();
		driver.close();
		//rc.comparingSimilarItems();
	}
	

	@Test
	public void getReviewsDetails() throws InterruptedException, IOException
	{
		driver.get("https://www.amazon.in/Samsung-Galaxy-Storage-Additional-Exchange/product-reviews/B07X8V5YKR/ref=cm_cr_dp_d_show_all_btm?ie=UTF8&reviewerType=all_reviews");
		ReviewRC rc=new ReviewRC(driver);
		driver.manage().window().maximize();
		driver.getTitle();
		rc.getFilteredReviews();
		
		
		//rc.comparingSimilarItems();
	}
}
