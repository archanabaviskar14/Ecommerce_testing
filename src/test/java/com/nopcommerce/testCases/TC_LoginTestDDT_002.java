package com.nopcommerce.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.loginPage;
import com.nopcommerce.utilities.XLUtils;

public class TC_LoginTestDDT_002 extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginTest(String user,String pwd) throws IOException, InterruptedException
	{
		
		driver.get(baseURL);
		driver.manage().window().maximize(); 
		
		loginPage lp = new loginPage(driver);
				
		lp.setUserName(user);
		logger.info("User provided"); //logger msg
		
		lp.setPassword(pwd);
		logger.info("Password provided");//logger msg
		
		lp.clickLogin();
		logger.info("Login in Clicked");//logger msg
		
		Thread.sleep(2000);
		
		if (driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			lp.clickLogout();
			Assert.assertTrue(true);
			logger.info("Login Passed");//logger msg
					
		}
		else
		{
			captureScreen(driver,"TC_LoginTest_002");
			logger.info("Login Failed");//logger msg
			Assert.assertTrue(false);
		}

	}
	
	@DataProvider(name="LoginData")
	public String[][] getdata() throws IOException
	{
//String path="C:\\Users\\RavindraBaviskar\\eclipse-workspace\\nopCommerceV2\\src\\test\\java\\com\\nopcommerce\\testData\\LoginData.xlsx";
		String path=System.getProperty("user.dir")+"/src/test/java/com/nopcommerce/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
		
	


}
