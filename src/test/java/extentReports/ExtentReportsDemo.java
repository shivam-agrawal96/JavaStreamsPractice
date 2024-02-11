package extentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {
	
	ExtentReports extent;
	
	@BeforeTest
	public void reporterInitializer()
	{
		String filePath = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(filePath);
		reporter.config().setDocumentTitle("Stand_Alone_Report");
		reporter.config().setReportName("Standard Report");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Environment", "Live");
	}
	
	@Test
	public void getReport()
	{
		
//		ExtentTest test =
		extent.createTest("Initial Demo");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.udemy.com/");
		System.out.println(driver.getTitle());
//		test.fail("Result don't match");
		extent.flush();
	}

}
