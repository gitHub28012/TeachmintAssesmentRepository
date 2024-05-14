package org.schoolmanagementautomation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.schoolmanagementautomation.generic_utilities.InitObjects;

public abstract class BasePage extends InitObjects{
	
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

}
