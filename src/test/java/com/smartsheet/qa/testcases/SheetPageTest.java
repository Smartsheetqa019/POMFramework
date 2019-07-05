package com.smartsheet.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.smartsheet.qa.base.TestBase;
import com.smartsheet.qa.pages.LoginPage;
import com.smartsheet.qa.pages.SheetPage;

public class SheetPageTest extends TestBase {	//Inherit common properties from TestBase class
	LoginPage loginPage;
	SheetPage sheetPage;
	
	public SheetPageTest(){
		super(); //Call Parent class constructor
	}
	
	@BeforeMethod
	public void setUp() {
		initialization(); //Call Initialize method
		loginPage = new LoginPage();
		sheetPage = loginPage.login(prop.getProperty("loginEmail"), prop.getProperty("loginPassword"));
	}
	
	//Validate Adding Text/Number Column in a sheet
	@Test(priority=1)
	public void addcolumnTest() throws InterruptedException{
		sheetPage.addColumn(prop.getProperty("columnheading"));	
	}
	
	//Validate Remove Text/Number Column test case
	@Test(priority=2)
	public void removecolumnTest() throws InterruptedException {
		sheetPage.deleteColumn();
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
