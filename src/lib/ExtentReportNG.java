package lib;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	public static ExtentReports getReportObject() {
		
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter repoter = new ExtentSparkReporter(path);
		repoter.config().setReportName("Web Automation Result");
		repoter.config().setDocumentTitle("Test Result");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(repoter);
		extent.setSystemInfo("Tester", "Aayush");
		extent.createTest(path);
		return extent;
	}

}
