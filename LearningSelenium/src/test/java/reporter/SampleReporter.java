package reporter;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class SampleReporter {
	public void report(String Status, String Expected, String Actual){
		ExtentReports report = new ExtentReports("./Results/ResultReport.html");
		ExtentTest test = report.startTest("Validate_Browser_Navigation", "To verify whether the User is able to open the Browser");
		
		test.assignAuthor("Rachit");
		test.assignCategory("Smoke");
		
		if(Status.equalsIgnoreCase("pass"))
				test.log(LogStatus.PASS, Expected, Actual);
		else if(Status.equalsIgnoreCase("fail"))
			test.log(LogStatus.FAIL, Expected, Actual);
		else if(Status.equalsIgnoreCase("warning"))
			test.log(LogStatus.WARNING, Expected, Actual);
		else 
			test.log(LogStatus.INFO, Expected, Actual);
		
		report.endTest(test);
		report.flush();
	}
	@Test
	public void testMathod(){
		try {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			report("Pass", "Browser should be opened", "Browser is opened");
		} catch (Exception e) {
			e.printStackTrace();
			report("Fail", "Browser should be opened", "Browser is not opened");
		}
	}
}
