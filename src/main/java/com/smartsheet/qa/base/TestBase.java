package com.smartsheet.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.smartsheet.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver; //Initialize driver variable
	public static Properties prop; //Class variable
	
	//Constructor
	public TestBase() {
		
		//Read Properties
		try {
			prop = new Properties(); //Initialize prop variable
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/smartsheet/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//Initialization Method
	public static void initialization() {
		
		//Read browser
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			FileInputStream ipone = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/smartsheet/qa/config/chromedriver.exe");
			propone.load(ipone);
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
		
	}
	

}
