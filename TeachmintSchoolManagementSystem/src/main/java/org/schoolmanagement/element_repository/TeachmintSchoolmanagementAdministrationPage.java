package org.schoolmanagement.element_repository;

import java.io.Serial;
import java.time.Duration;

import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.schoolmanagementautomation.base.BasePage;
import org.schoolmanagementautomation.generic_utilities.InitObjects;

public class TeachmintSchoolmanagementAdministrationPage extends BasePage {

	public TeachmintSchoolmanagementAdministrationPage(WebDriver driver) {
		super(driver);
	}

	// Record the WebElement of Administration page and utilize

	@FindBy(partialLinkText = "Certificates")
	private WebElement certificatesLink;
	@FindBy(xpath = "//h6[text()='School leaving certificate']/ancestor::div[@data-qa='plain-card']")
	private WebElement schoolLeavingCertificate;
	@FindBy(xpath = "//h2[text()='Certificates and Documents']")
	private WebElement certificate_and_Doc_Element;
	@FindBy(xpath = "//div[text()='Generate']")
	private WebElement LCgenerateButton1;
	@FindBy(name = "search")
	private WebElement searchTextField;
	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	private WebElement studentSelectCheckBox;
	@FindBy(xpath = "//div[text()='Generate']")
	private WebElement LCgenerateButton2;
	@FindBy(xpath = "//input[@placeholder='Remarks']")
	private WebElement remarksField;
	@FindBy(xpath = "//span[text()='Show changes in preview']")
	private WebElement previewCertificateButton;
	@FindBy(xpath = "//div[text()='Mother']")
	private WebElement scrollingElement;
	@FindBy(xpath = "//div[text()='Generate']/ancestor::button")
	private WebElement LCgenerateButton3;
	@FindBy(id = "download")
	private WebElement LCdownloadButton;
	@FindBy(xpath = "(//span[@data-qa='icon-ellipsisVertical'])[5]")
	private WebElement icon;
	@FindBy(xpath = "(//div[text()='Preview'])[1]")
	private WebElement PreviewToVerify;
	@FindBy(xpath = "(//p[contains(@class,'krayon__Para-module__VmUAA krayon__Para-module__Qddrw krayon__Para-module__5')])[1]")
	private WebElement studentNameElementFromHistory;
	@FindBy(xpath = "(//span[@data-qa='icon-close'])[2]")
	private WebElement closePreview;
	
	
	
	// utilization methods of WebElemet

	public WebElement getIcon() {
		return icon;
	}

	public WebElement getCertificatesLink() {
		return certificatesLink;
	}

	public WebElement getSchoolLeavingCertificate() {
		return schoolLeavingCertificate;
	}

	public WebElement getLCgenerateButton1() {
		return LCgenerateButton1;
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getStudentSelectCheckBox() {
		return studentSelectCheckBox;
	}

	public WebElement getLCgenerateButton2() {
		return LCgenerateButton2;
	}

	public WebElement getRemarksField() {
		return remarksField;
	}

	public WebElement getPreviewCertificateButton() {
		return previewCertificateButton;
	}

	public WebElement getScrollingElement() {
		return scrollingElement;
	}

	public WebElement getLCgenerateButton3() {
		return LCgenerateButton3;
	}

	public WebElement getLCdownloadButton() {
		return LCdownloadButton;
	}

	public WebElement getPreviewToVerify() {
		return PreviewToVerify;
	}

	public WebElement getStudentNameElementFromHistory() {
		return studentNameElementFromHistory;
	}
	
	public WebElement getCertificate_and_Doc_Element() {
		return certificate_and_Doc_Element;
	}

	
	public WebElement getClosePreview() {
		return closePreview;
	}

	
	// operational Methods of WebElement


	public void selectTheCertificateType(WebElement certificateType) {
		InitObjects initObj = new InitObjects();
		initObj.getActionsUtil(driver).mouseHoverOnElement(certificatesLink);
		certificatesLink.click();
		certificateType.click();

	}

	public void searchTheStudent_and_generateCertificate(String studentName, String remark) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LCgenerateButton1.click();
		searchTextField.click();
		searchTextField.sendKeys(studentName);

		studentSelectCheckBox.click();
		LCgenerateButton2.click();

		InitObjects initObj = new InitObjects();
		explicitWait = initObj.getExplicitWait(driver, Duration.ofSeconds(EXPLICIT_TIMEOUT));
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		initObj.getJavaScriptUtil(driver).scrollTillParticaulrWebElement(remarksField);
		remarksField.sendKeys(remark);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		previewCertificateButton.click();

	}

	public void downloadTheSchoolLeavingCertificate(WebElement targetButton) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		InitObjects initObj = new InitObjects();
		explicitWait = initObj.getExplicitWait(driver, Duration.ofSeconds(EXPLICIT_TIMEOUT));
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
		initObj.getActionsUtil(driver).mouseHoverOnElement(targetButton);
		targetButton.click();
		LCdownloadButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		initObj.getJavaScriptUtil(driver).scrollDown(500);
		initObj.getUtilityMethods().moveOverOnTabUsingRobot();
		initObj.getActionsUtil(driver).mouseHoverOnElement(certificatesLink);
		certificatesLink.click();
		initObj.getJavaScriptUtil(driver).scrollDown(600);
	}

	public void validateCertificate() {
		InitObjects initObj = new InitObjects();
		initObj.getActionsUtil(driver).mouseHoverOnElement(icon);
		icon.click();
		PreviewToVerify.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        closePreview.click();
	}

}
