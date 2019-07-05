package com.smartsheet.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.smartsheet.qa.base.TestBase;


//Objective of this calss is to identify elements on login page and perform required actions
public class LoginPage extends TestBase {	//Inherit common properties from TestBase class
	
	//PageFactory - Object Repository:
	@FindBy(name="loginEmail")
	WebElement loginEmail;
	
	@FindBy(name="loginPassword")
	WebElement loginPassword;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	//Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public SheetPage login(String un, String pwd){
		loginEmail.sendKeys(un);
		loginBtn.click();
		loginPassword.sendKeys(pwd);
		loginBtn.click();
		return new SheetPage();
		
	}

}
