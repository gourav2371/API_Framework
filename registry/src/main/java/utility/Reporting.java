package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporting
{
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter sparker;
	public ExtentReports generateReport()
	{
		String reportName = "Test Report.html";
		String reportPath = System.getProperty("user.dir")+"\\reports\\"+reportName;
		sparker = new ExtentSparkReporter(reportPath);
		
		sparker.config().setDocumentTitle("YNHH Report");
		sparker.config().setReportName("YNHH Testing Report");
		sparker.config().setTimeStampFormat("dd-mm-yyyy hh:mm:ss");
		
		extent.attachReporter(sparker);
		extent.setSystemInfo("Tester", "Gourav Shivalkar");
		return extent;
	}
}