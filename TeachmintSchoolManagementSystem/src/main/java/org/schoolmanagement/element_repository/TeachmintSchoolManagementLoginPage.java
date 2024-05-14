package org.schoolmanagement.element_repository;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.schoolmanagementautomation.base.BasePage;
import org.schoolmanagementautomation.generic_utilities.InitObjects;

public class TeachmintSchoolManagementLoginPage extends BasePage {
	

	public TeachmintSchoolManagementLoginPage(WebDriver driver) {
		super(driver);
	}

	// Record the WebElement of Login page and utilize

	@FindBy(id = "user-input")
	private WebElement mobileNumberInput;
	@FindBy(xpath = "//input[@id='send-otp-btn-id']")
	private WebElement sendOtpButton;
	@FindBy(xpath = "//input[@data-group-idx]")
	private List<WebElement> otpFields;
	@FindBy(id = "submit-otp-btn-id")
	private WebElement submitOtpButton;
	@FindBy(xpath = "(//div[@class='profile-cont'])[2]")
	private WebElement accountProfile;

	
	//utilization methods of WebElemet 
	public WebElement getAccountProfile() {
		return accountProfile;
	}

	public WebElement getMobileNumberInput() {
		return mobileNumberInput;
	}

	public WebElement getSendOtpButton() {
		return sendOtpButton;
	}

	public List<WebElement> getOtpFields() {
		return otpFields;
	}

	public WebElement getSubmitOtpButton() {
		return submitOtpButton;
	}

	// operational Methods of WebElement
	public void login(String mono, String otp) {

		mobileNumberInput.click();
		mobileNumberInput.sendKeys(mono);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sendOtpButton.click();
		for (int i = 0; i < otp.length(); i++) {
			WebElement otpField = otpFields.get(i);
			otpField.sendKeys(String.valueOf(otp.charAt(i)));
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		submitOtpButton.click();
		InitObjects initObj = new InitObjects();
		initObj.getActionsUtil(driver).mouseHoverOnElement(accountProfile);
		accountProfile.click();

	}

}
