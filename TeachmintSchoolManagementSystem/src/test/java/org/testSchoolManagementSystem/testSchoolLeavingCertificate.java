package org.testSchoolManagementSystem;

import org.schoolmanagement.element_repository.TeachmintSchoolManagementHomePage;
import org.schoolmanagement.element_repository.TeachmintSchoolmanagementAdministrationPage;
import org.schoolmanagementautomation.base.BaseTest;
import org.schoolmanagementautomation.generic_utilities.CustomeListener;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomeListener.class)
public class testSchoolLeavingCertificate extends BaseTest{
	
	
	@Test(alwaysRun = true)
	public void testSchoolLCMethod()
	{
		
		TeachmintSchoolManagementHomePage homePage = new TeachmintSchoolManagementHomePage(driver);
		
		homePage.selectModuleToWorkOn(homePage.getAdministrationOption());
		Assert.assertEquals(true,homePage.getShadowHostElement().isDisplayed());
		Reporter.log("Administration Module is Selected!!",true);
		
		TeachmintSchoolmanagementAdministrationPage administrationPage = new TeachmintSchoolmanagementAdministrationPage(driver);
		administrationPage.selectTheCertificateType(administrationPage.getSchoolLeavingCertificate());
		Assert.assertEquals(true,administrationPage.getCertificate_and_Doc_Element().isDisplayed());
		Reporter.log("SchoolLeavingCertificate Selected!!");
		
		String studentName = readTestData.readStringDataFromExcel(STUDENT_INFOSHEET,1,1);
		String remark = readTestData.readStringDataFromExcel(STUDENT_INFOSHEET,1,11);
		administrationPage.searchTheStudent_and_generateCertificate(studentName, remark);
		Reporter.log("Searched for student and generated his LC!!");
		
		administrationPage.downloadTheSchoolLeavingCertificate(administrationPage.getLCgenerateButton3());
		Reporter.log("Downloaded the SchoolLeavingCertificate!!");
		
		Assert.assertEquals(administrationPage.getStudentNameElementFromHistory().getText(),studentName);
		administrationPage.validateCertificate();
		Reporter.log("It's a validate certificate!!");
		
	}
	

}
