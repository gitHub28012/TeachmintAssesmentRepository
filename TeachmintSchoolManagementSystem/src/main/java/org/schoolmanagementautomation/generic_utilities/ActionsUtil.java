package org.schoolmanagementautomation.generic_utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtil {
	
Actions actions ;
	
	public ActionsUtil(WebDriver driver) {
		actions = new Actions(driver);
	}

	
	// generic mouse actions methods 
	public void mouseHoverOnElement(WebElement targetElement) {
		actions.moveToElement(targetElement).perform();
	}
	
	public void mouseHoverOnElementCoordinates(WebElement targetElement, int xOffset , int yOffset) {
		actions.moveToElement(targetElement, xOffset, yOffset).perform();
	}
	
	public void doubleClickOnElement(WebElement targetElement) {
		actions.doubleClick(targetElement).perform();
	} 
	
	public void rightClickOnElement(WebElement targetElement) {
		actions.contextClick(targetElement).perform();
	}
	

}
