package org.schoolmanagement.element_repository;

import java.time.Duration;

import org.checkerframework.checker.signature.qual.PrimitiveType;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.schoolmanagementautomation.base.BasePage;
import org.schoolmanagementautomation.generic_utilities.InitObjects;

public class TeachmintSchoolManagementHomePage extends BasePage {

	public TeachmintSchoolManagementHomePage(WebDriver driver) {
		super(driver);
	}

	// Record the WebElement of Home page and utilize
	@FindBy(xpath = "//div[@class='flex items-center cursor-pointer']/descendant::span[@data-qa='icon-chevronDown']")
	private WebElement profileIcon;
	@FindBy(xpath = "//div[text()='Logout']")
	private WebElement logOutButton;
	@FindBy(xpath = "//iframe[@class='SwitchAdmin_iframe__2jYgf']")
	private WebElement frameElement;
	@FindBy(xpath = "(//div[contains(@class,'Sidebar_sidebarWrapp')])[1]")
	private WebElement allOptionsInHomePage;
	@FindBy(xpath = "(//div[text()='Administration']/following-sibling::span)[1]")
	private WebElement administrationOption;
	@FindBy(tagName = "releases-panel")
	private WebElement shadowHostElement;

	// utilization methods of WebElemet
	public WebElement getFrameElement() {
		return frameElement;
	}

	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getLogOutButton() {
		return logOutButton;
	}

	public WebElement getAllOptionsInHomePage() {
		return allOptionsInHomePage;
	}

	public WebElement getAdministrationOption() {
		return administrationOption;
	}

	public WebElement getShadowHostElement() {
		return shadowHostElement;
	}

	// operational Methods of WebElement
	public void logout() {
		InitObjects initObj = new InitObjects();
		initObj.getActionsUtil(driver).mouseHoverOnElement(profileIcon);
		profileIcon.click();
		initObj.getUtilityMethods().switchToFrame(driver, frameElement);
		initObj.explicitWait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_TIMEOUT));
		initObj.explicitWait.until(ExpectedConditions.elementToBeClickable(logOutButton)).click();
	}

	public void selectModuleToWorkOn(WebElement element) {
		InitObjects initObj = new InitObjects();
		SearchContext shadowRootElemet = shadowHostElement.getShadowRoot();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		shadowRootElemet.findElement(By.cssSelector("path[d='M6 18L18 6M6 6l12 12']")).click();
		;
		initObj.getActionsUtil(driver).mouseHoverOnElement(allOptionsInHomePage);
		initObj.getActionsUtil(driver).mouseHoverOnElement(element);
		element.click();
	}

}
