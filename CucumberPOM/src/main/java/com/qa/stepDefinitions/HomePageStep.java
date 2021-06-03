package com.qa.stepDefinitions;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.pages.LoginPage;
import com.qa.util.TestBase;

import cucumber.runtime.Timeout;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStep extends TestBase{

LoginPage loginPage=new LoginPage(driver);

		@Given("Open the browser")
		public void login_page_is_displayed() {
		   TestBase.initialization();
		}
		
		@When("^\"(.*)\" and \"(.*)\" is entered$")
		public void username_and_password_is_entered(String username, String password) throws InterruptedException{
		 
			WebDriverWait wait=new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='_1_3w1N']")))).click();
			
			//driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
			
		  loginPage.loginHomePage(username, password);
		}
		@Then("click on LoginPage")
		public void click_on_login_page() {
		    
		}
		@Then("Error message should be displayed")
		public void error_message_should_be_displayed() {
		    
		}



}
