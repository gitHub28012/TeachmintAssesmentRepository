package org.schoolmanagementautomation.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 import org.schoolmanagement.element_repository.TeachmintSchoolManagementHomePage;
import org.schoolmanagement.element_repository.TeachmintSchoolManagementLoginPage;
import org.schoolmanagementautomation.generic_utilities.InitObjects;
import org.schoolmanagementautomation.generic_utilities.ReadTestData;
import org.schoolmanagementautomation.generic_utilities.ReadTestData.ReadPropertyFileDataException;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BaseTest extends InitObjects{
	
	

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void browserSetup (@Optional("noValue") String browserName) throws InvalidBrowserException, ReadPropertyFileDataException
	{
		 initClass= new InitObjects();
		 readTestData = initClass.getReadTestData();
		
		 
			if (browserName.equalsIgnoreCase("noValue")) {
				browserName = readTestData.readDataFromPropertyFile("browser");
				if (browserName.equalsIgnoreCase("null")) {
					throw new InvalidBrowserException();
				}
			} 
			if (browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
				Reporter.log("Successfully Launched Chrome Browser", true);
			} else if (browserName.equalsIgnoreCase("firefox")) {
					driver = new FirefoxDriver();
				Reporter.log("Successfully Launched Firefox Browser", true);
			}
			
			driver.manage().window().maximize();
			Reporter.log("Browser window is maximized successfully", true);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_TIMEOUT));
			explicitWait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_TIMEOUT));
		 
	}
	
	
	@BeforeMethod(alwaysRun = true)
	public void loginToSchoolManagementSystem() throws ReadPropertyFileDataException
	{    
		 initClass= new InitObjects();
		 url = readTestData.readDataFromPropertyFile("url");
		 mobileNo=readTestData.readDataFromPropertyFile("Mobile_number");
		 otp=readTestData.readDataFromPropertyFile("OTP");
		 driver.get(url);
		 new TeachmintSchoolManagementLoginPage(driver).login(mobileNo, otp);
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void logoutFromSchoolManagementSystem()
	{
	  explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
	   new TeachmintSchoolManagementHomePage(driver).logout();
	}
	
	
	@AfterClass(alwaysRun = true)
	public void browserTearDown()
	{
		driver.quit();
	}
	
	

	//********************Custom Exception************
	
	public class InvalidBrowserException extends Exception {
		
		public InvalidBrowserException()
		{
			super("Invalid browser value!!!");
		}
	}


}
