package extententreport_SingleTestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Extent_Report1 {
	
	ExtentReports extent;
	
	@BeforeTest
	public void config() {
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter repoter = new ExtentSparkReporter(path);
		repoter.config().setReportName("Web Automation Result");
		repoter.config().setDocumentTitle("Test Result");
		
		extent = new ExtentReports();
		extent.attachReporter(repoter);
		extent.setSystemInfo("Tester", "Aayush");
		
	}
	
	@Test
	public void demo() {
		ExtentTest test = extent.createTest("Demo");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		System.out.println(driver.getTitle());
		driver.close();
		test.fail("Result not match"); 
		extent.flush();
	}

}