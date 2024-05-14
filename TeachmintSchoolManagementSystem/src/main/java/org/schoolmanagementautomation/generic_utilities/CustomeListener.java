package org.schoolmanagementautomation.generic_utilities;

import org.schoolmanagementautomation.base.BaseTest;
import org.testng.ISuite;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomeListener extends BaseTest implements ITestListener {

	public void onFinish(ISuite suite) {					
		Reporter.log("About to end executing Suite [" + suite.getName() + "]");
	}
	
	public void onStart(ISuite suite) {								
		Reporter.log("About to begin executing Suite [" + suite.getName() + "]");
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {								
		//not implemented
	}

	public void onTestFailure(ITestResult result) {	
		InitObjects initObj = new InitObjects();
		initObj.getUtilityMethods().captureScreen(driver, result);
				
	}		

	public void onTestSkipped(ITestResult result) {					
		Reporter.log("Test [" + result.getName() + "] skipped");
	}		

	public void onTestStart(ITestResult result) {					
		Reporter.log("Execution of the test [" + result.getName() + "] started");
	}	
	
	public void onTestSuccess(ITestResult result) {					
		Reporter.log("Test [" + result.getName() + "] passed");
	}
}
