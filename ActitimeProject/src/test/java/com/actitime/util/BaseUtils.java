package com.actitime.util;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class BaseUtils extends AbstractTestNGCucumberTests {

	public RemoteWebDriver driver;
	public ReportUtil reportUtil;

	@BeforeSuite(alwaysRun = true)
	public void ReportConfig(@Optional ITestContext ctx) {
		String suiteName = ctx.getCurrentXmlTest().getSuite().getName();
		reportUtil = new ReportUtil();
		reportUtil.initializeReport(suiteName);
		reportUtil.killReport();
	}

	@AfterSuite(alwaysRun = true)
	public void closeReport() {
		reportUtil.killReport();
	}

}