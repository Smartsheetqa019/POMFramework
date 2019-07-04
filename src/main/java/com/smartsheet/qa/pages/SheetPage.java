package com.smartsheet.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.smartsheet.qa.base.TestBase;

public class SheetPage extends TestBase {
	
	@FindBy(xpath="//div[text()='Primary Column']")
	WebElement column;
	
	@FindBy(xpath="//td[text()='Insert Column Right']")
	WebElement addcolumn;
	
	@FindBy(xpath="//div[@class='clsFloatingForm clsLargeDropShadow']//input[@type='text']")
	WebElement columnheading;
	
	@FindBy(xpath="//span[text()='OK']")
	WebElement okbtn;
	
	@FindBy(xpath="//div[text()='Column2']")
	WebElement existingcolumn;
	
	@FindBy(xpath="//td[text()='Delete Column']")
	WebElement removecolumn;
	
	
	public SheetPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void addColumn(String colname) throws InterruptedException{
		column.click();
		Actions action = new Actions(driver);
		action.contextClick(column).perform();
		addcolumn.click();
		Thread.sleep(3000);
		columnheading.sendKeys(colname);
		Thread.sleep(3000);
		okbtn.click();
		Thread.sleep(3000);
	}
	
	public void deleteColumn() throws InterruptedException {
		existingcolumn.click();
		Actions action = new Actions(driver);
		action.contextClick(existingcolumn).perform();
		Thread.sleep(3000);
		removecolumn.click();
		Thread.sleep(3000);
	}
	
	
}
	
	
	