package org.schoolmanagementautomation.generic_utilities;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

public class UtilityMethods implements FrameworkConstants{
	
	
	// generic methods to handle Window,KeyBoard Actions,DropDown,takingScreenshots,frame
	
	public void switchToASpecificTitledWindow(WebDriver driver, String title) {
		String parentWindowId = driver.getWindowHandle();
		Set<String> allWindowIds = driver.getWindowHandles();
		allWindowIds.remove(parentWindowId);
		for (String windowId : allWindowIds) {
			driver.switchTo().window(windowId);
			if (driver.getTitle().equalsIgnoreCase(title)) {
				break;
			}
		}
	}
	
	
	
	public void switchToASpecificWindow(WebDriver driver, WebElement element) {
		String parent = driver.getWindowHandle();
		Set<String> allWid = driver.getWindowHandles();
		allWid.remove(parent);
		for (String sessionID : allWid) {
			driver.switchTo().window(sessionID);
			if (element.isDisplayed()) {
				break;
			}
		}
	}

	public void selectDropDown(WebElement listbox, String option) {
		Select select = new Select(listbox);
		int counter = 0;

		try {
			int index = Integer.parseInt(option);
			select.selectByIndex(index);
			counter++;
		} catch (Exception e) {
			System.out.println("It is not a index");
		}

		if (counter == 0) {
			try {
				select.selectByVisibleText(option);
			} catch (Exception e) {
				select.selectByValue(option);
			}
		}
	}
	
	
	
	public void switchToFrame(WebDriver driver, String indexNameOrId) {
		try {
			int index = Integer.parseInt(indexNameOrId);
			driver.switchTo().frame(index);
		} catch (NumberFormatException e) {
			driver.switchTo().frame(indexNameOrId);
		}
	}
	
	public void switchToFrame(WebDriver driver,WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}

   public void switchToDefaultPage(WebDriver driver)
   {
	   driver.switchTo().defaultContent();
   }
	
	public  void captureScreen(WebDriver driver, ITestResult result) {
		TakesScreenshot takeScreenShot = (TakesScreenshot)driver;
		File tempFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(SCREEN_SHOT_PATH + result.getName()+".png");
		try {
			FileUtils.copyFile(tempFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void moveOverOnTabUsingRobot()
	{
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_TAB);
				
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
