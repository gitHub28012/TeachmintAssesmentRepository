package org.schoolmanagementautomation.generic_utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
	
private JavascriptExecutor javaScript;
	
	public JavaScriptUtil(WebDriver driver) {
		javaScript =( (JavascriptExecutor) driver);
	}
	

	
	// generic javascriptexecutor  methods
	public void jsClick(WebElement element) {
		javaScript.executeScript("arguments[0].click();", element);
	}

	
	public void scrollTillParticaulrWebElement(WebElement element)
	{
	      Point loc = element.getLocation();
	      int xaxis = loc.getX();
	      int yaxis = loc.getY();
	      javaScript.executeScript(("window.scrollTo("+xaxis+","+yaxis+")"));
	}
	
   public void scrollDown(int down)
   {
	   javaScript.executeScript("window.scrollBy(0,"+down+")");
   }

}
