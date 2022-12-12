package gsh.registry;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utility.CaptureScreenshots;
import utility.Reporting;

public class Listeners implements ITestListener
{
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	CaptureScreenshots screenshot = new CaptureScreenshots();
	Reporting reporter = new Reporting();
	
	public void onTestStart(ITestResult result) {
		
		try 
		{
			extent = reporter.generateReport();
			test = extent.createTest(result.getMethod().getMethodName());
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public void onTestSuccess(ITestResult result) {
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			String filepath = screenshot.getScreenshot(result.getMethod().getMethodName(), driver);
			test.addScreenCaptureFromPath(filepath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent.flush();
	}

	public void onTestFailure(ITestResult result) {
		
		
	}

	public void onTestSkipped(ITestResult result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		
		
	}
}
