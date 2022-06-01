package com.nopcommerce.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddcustomerPage;
import com.nopcommerce.pageObjects.loginPage;

public class TC_AddCustomerTest_003 extends BaseClass{


	@Test
	public void AddNewCustomer() throws IOException
	{
		driver.get(baseURL);
		
		driver.manage().window().maximize();
		
		logger.info("URL opened");
		
		loginPage lp=new loginPage(driver);
		lp.clickLogin();
		
		AddcustomerPage addcust=new AddcustomerPage(driver);
		
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		addcust.clickOnAddNew();
		
		String email = randomestring() + "@gmail.com";
		addcust.setEmail(email);
		logger.info("email entered");
		
		//addcust.setEmail("");
		addcust.setPassword("test123");
		logger.info("password entered");
		
		addcust.setFirstName("Pavan");
		logger.info("fname entered");
		addcust.setLastName("Kumar");
		logger.info("lname entered");
		
		addcust.setGender("Male");
		logger.info("gender selected");
		
		
		addcust.setDob("7/05/1985"); // Format: D/MM/YYY
		logger.info("date entered");
		
		addcust.setCompanyName("busyQA");
		logger.info("companyname entered");
		addcust.setIsTaxExtent();
		logger.info("taxextent clicked");
		
		//addcust.setNewsLetter("abcde");
		//logger.info("newsletter entered");
		
		//Registered - default
		//The customer cannot be in both 'Guests' and 'Registered' customer roles
		//Add the customer to 'Guests' or 'Registered' customer role
		
		addcust.setCustomerRoles("Guests");
		logger.info("role selected");
		//addcust.setManagerOfVendor("Vendor 2");
		//logger.info("manager set");
		
		
		addcust.setAdminComment("This is for testing.........");
		logger.info("comment added");
	
		addcust.clickOnSave();
		
		logger.info("clicked on save");
		logger.info("validation started....");
				
		//String msg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
		
		String msg = driver.findElement(By.tagName("body")).getText();
			
		
		if(msg.contains("The new customer has been added successfully"))
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else
		{
			captureScreen(driver,"AddNewCustomer");
			Assert.assertTrue(false);
		}
				
	}
	
				
	
}
