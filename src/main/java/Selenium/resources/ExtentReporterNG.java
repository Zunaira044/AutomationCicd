package Selenium.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports getReportObject() {

		String filepath = System.getProperty("user.dir") + "\\Reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(filepath);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("ExtentReports");

		ExtentReports	extent = new ExtentReports();
		extent.attachReporter(reporter); // connection b/w helperclass and main class
		extent.setSystemInfo("Test Engineer", "Md Sarfaraz Ahmed");
		return extent;
	}
}