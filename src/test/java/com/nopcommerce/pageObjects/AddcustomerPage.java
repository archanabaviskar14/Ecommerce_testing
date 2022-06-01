package com.nopcommerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddcustomerPage {
	
	WebDriver ldriver;
	
	public AddcustomerPage(WebDriver rdriver) 
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath="/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a/p")
	WebElement lnkCustomers_menu;
	
	@FindBy(xpath="/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p")
	WebElement lnkCustomers_menuitem;
	
	@FindBy(xpath="/html/body/div[3]/div[1]/form[1]/div/div/a")
	WebElement btnAddnew;
	
	@FindBy(name="Email")
	WebElement txtEmail;
	
	@FindBy(name="Password")
	WebElement txtPassword;
	
	@FindBy(name="FirstName")
	WebElement txtFirstName;
	
	@FindBy(name="LastName")
	WebElement txtLastName;
	
	@FindBy(id="Gender_Male")
	WebElement rdGenderMale;
	
	@FindBy(id="Gender_Female")
	WebElement rdGenderFemale;
	
	@FindBy(id="DateOfBirth")
	WebElement txtDob;
	
	@FindBy(xpath="//*[@id=\"Company\"]")
	WebElement txtCompanyName;
	
	@FindBy(name="IsTaxExempt")
	WebElement chkIsTaxExempt;
	
	@FindBy(xpath="//*[@id=\"customer-info\"]/div[2]/div[9]/div[2]/div/div[1]/div/div")
	WebElement txtNewsLetter;
	
	@FindBy(xpath="//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div")
	WebElement txtcustomerRoles;
	
	@FindBy(xpath="//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[1]")
	WebElement lstitemAdministrators;
	
	@FindBy(xpath="//*[@id=\"09480b90-82d8-4f53-b9a6-8268d603e0e2\"]")
	WebElement lstitemRegistered;
	
	@FindBy(xpath="//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[2]")
	WebElement lstitemForumModerators;
	
	@FindBy(xpath="//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[3]")
	WebElement lstitemGuests;
	
	@FindBy(xpath="//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[5]")
	WebElement lstitemVendors;
	
	@FindBy(xpath="//*[@id=\"VendorId\"]")
	WebElement drpmgrofVendors;
	
	@FindBy(xpath="//*[@id=\"AdminComment\"]")
	WebElement txtAdminComment;
	
	@FindBy(name="save")
	WebElement btnSave;
	
	public void clickOnCustomersMenu()
	{
		lnkCustomers_menu.click();
	}
	
	public void clickOnCustomersMenuItem()
	{
		lnkCustomers_menuitem.click();
	}
	
	public void clickOnAddNew()
	{
		btnAddnew.click();
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			rdGenderMale.click();
		}
		else if(gender.equals("Female"))
		{
			rdGenderFemale.click();
		}
		else
		{
			rdGenderMale.click();
		}
	}
	
	public void setDob(String dob)
	{
		txtDob.sendKeys(dob);
	}
	
	public void setCompanyName(String comname)
	{
		txtCompanyName.sendKeys(comname);
	}
	
	public void setIsTaxExtent()
	{
		chkIsTaxExempt.click();
	}
	
	public void setNewsLetter(String newsletter)
	{
		txtNewsLetter.sendKeys(newsletter);
	}
	
	public void setAdminComment(String admcomment)
	{
		txtAdminComment.sendKeys(admcomment);
	}
	
	public void clickOnSave()
	{
		btnSave.click();
	}
	
	public void setManagerOfVendor(String value)
	{
		//ldriver.findElement(By.xpath("//*[@id=\"VendorId\"]")).click();
		Select drp=new Select(drpmgrofVendors);
		drp.selectByVisibleText(value);
	}
	
	public void setCustomerRoles(String role) 
	{
		ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
	
		txtcustomerRoles.click();
					
		WebElement listitem;
		
		switch(role)
		{
		case "Administrators":
				listitem=lstitemAdministrators; break;
		case "Guests":
				listitem=lstitemGuests; break;
		case "Registered":
			listitem=lstitemRegistered; break;
		case "Vendors":
			listitem=lstitemVendors; break;
		default:
			listitem=lstitemGuests;
		}
					
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", listitem);
		
}
}
