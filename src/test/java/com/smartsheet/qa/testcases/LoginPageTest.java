package com.smartsheet.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.smartsheet.qa.base.TestBase;
import com.smartsheet.qa.pages.LoginPage;
import com.smartsheet.qa.pages.SheetPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	SheetPage sheetPage;
	
	public LoginPageTest(){
		super(); //Super class constructor will be called
	}
	
	@BeforeMethod
	public void setUp() {
		initialization(); //Call Initialize method
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginTest() {
		sheetPage = loginPage.login(prop.getProperty("loginEmail"), prop.getProperty("loginPassword"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
