package com.nopcommerce.testCases;

import java.io.IOException;

import org.apache.log4j.spi.LoggerRepository;
import org.junit.Assert;
import org.testng.annotations.Test;
import com.nopcommerce.pageObjects.loginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void login() throws InterruptedException, IOException
	{
		driver.get(baseURL);
		driver.manage().window().maximize(); 
		
		loginPage lp = new loginPage(driver);
		
		//lp.setUserName(username);
		logger.info("User provided"); //logger msg
		
		//lp.setPassword(password);
		logger.info("Password provided");//logger msg
		
		
		lp.clickLogin();
		logger.info("Login in Clicked");//logger msg
		
		Thread.sleep(2000);
		
		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			lp.clickLogout();
			Assert.assertTrue(true);
			logger.info("Login Passed");//logger msg
			
		} else {
			captureScreen(driver,"TC_LoginTest_001");
			logger.info("Login Failed");//logger msg
			Assert.assertTrue(false);
		}

		
	}
	
	

}

