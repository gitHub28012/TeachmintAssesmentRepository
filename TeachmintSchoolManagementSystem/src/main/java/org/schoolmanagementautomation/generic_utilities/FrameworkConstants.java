package org.schoolmanagementautomation.generic_utilities;

public interface FrameworkConstants {
	
	
	String CHROME_KEY="webdriver.chrome.driver";
	String CHROME_PATH="./src/main/resources/drivers/chromedriver.exe";
	
	String FIREFOX_KEY="webdriver.gecko.driver";
	String FIREFOX_PATH="./src/main/resources/drivers/geckodriver.exe";
	
	String PROPERTY_PATH="./src/test/resources/PropertyData/config.properties";
	String EXCEL_PATH="./src/test/resources/TestData/SchoolStudentTestData.xlsx";
	
	String STUDENT_INFOSHEET="validStudentInfo";
	
	String SCREEN_SHOT_PATH="./ScreenShots";
	
	
	int IMPLICIT_TIMEOUT = 30;
	int EXPLICIT_TIMEOUT = 15;

}
