package org.schoolmanagementautomation.generic_utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.schoolmanagement.element_repository.TeachmintSchoolManagementLoginPage;

public class InitObjects implements FrameworkConstants {
	
	
	public static WebDriver driver;
	public InitObjects initClass;
	public ReadTestData readTestData;
	public JavaScriptUtil javascriptUtil;
	public ActionsUtil actionsUtil;
	public WebDriverWait explicitWait;
	public UtilityMethods utilityMethod;
	public String url;
	public String mobileNo;
	public String otp;
	public TeachmintSchoolManagementLoginPage loginPage;
	
	public ActionsUtil getActionsUtil(WebDriver driver) {
		return new ActionsUtil(driver);
	}
	
	public JavaScriptUtil getJavaScriptUtil(WebDriver driver) {
		return new JavaScriptUtil(driver);
	}
	
	public ReadTestData getReadTestData() {
		return new ReadTestData();
	}
	
	public UtilityMethods getUtilityMethods() {
		return new UtilityMethods();
	}
	
	public WebDriverWait getExplicitWait(WebDriver driver,Duration sec)
	{
		return new WebDriverWait(driver,sec);
	}

}
