package com.db.Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.db.TestBase.TestBase;

public class ListenerSetup extends TestBase implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Test execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test execution completed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("Test execution Failed");
		UtilClass.takeScreenShot(result.getName()+System.currentTimeMillis());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("Test execution Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}

}
