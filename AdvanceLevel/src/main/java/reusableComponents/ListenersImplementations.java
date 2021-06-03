package reusableComponents;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testBase.DriverFactory;
import testBase.ExtentFactory;
import testBase.ExtentReportNG;

public class ListenersImplementations implements ITestListener {

	static ExtentReports reports;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = reports.createTest(result.getMethod().getMethodName());
		ExtentFactory.getInstance().setExtent(test);
		/*
		 * ExtentFactory.getInstance().getExtent().log(Status.PASS,
		 * "Test Case: " + result.getMethod().getMethodName() + "is Passed");
		 */
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentFactory.getInstance().getExtent().log(Status.PASS,
				"Test Case: " + result.getMethod().getMethodName() + "is Passed");
		ExtentFactory.getInstance().removeExtentObject();
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentFactory.getInstance().getExtent().log(Status.FAIL,
				"Test Case: " + result.getMethod().getMethodName() + "is Failed");
		// ExtentFactory.getInstance().getExtent().log(Status.FAIL,
		// result.getThrowable());

		File src = ((TakesScreenshot) DriverFactory.getInstances().getDriver()).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);

		String screenshotPath = System.getProperty("user.dir") + "/Reports/Screenshots/" + actualDate + ".png";

		File dest = new File(screenshotPath);

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ExtentFactory.getInstance().getExtent().addScreenCaptureFromPath(screenshotPath,
					"Test Case Failure Screenshot");
			ExtentFactory.getInstance().removeExtentObject();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentFactory.getInstance().getExtent().log(Status.SKIP,
				"Test Case: " + result.getMethod().getMethodName() + "is skipped");
		ExtentFactory.getInstance().removeExtentObject();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		try {
			reports = ExtentReportNG.setupExtentReport();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		reports.flush();
	}

}
