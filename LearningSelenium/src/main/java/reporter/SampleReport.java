package reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class SampleReport{
	public ExtentTest test;
	public static ExtentReports report;
	public String testCaseName, testDescription, category, authors;
	
	public abstract long takeSnap();

	public void report(String Status, String expected, String actual, Boolean flagTakeSnap){	
		if(flagTakeSnap && !Status.equalsIgnoreCase("INFO")){	
			long snapNumber = 100000l;
			try{
				snapNumber= takeSnap();
			}catch (Exception e) {
				e.printStackTrace();
			}
			actual=actual+test.addScreenCapture("../Screenshots/Images/snap"+snapNumber+".jpeg");					
		}
	
		if(Status.equalsIgnoreCase("Pass"))
			test.log(LogStatus.PASS, expected, actual);
		else if(Status.equalsIgnoreCase("Fail"))
			test.log(LogStatus.FAIL, expected, actual);
		else if(Status.equalsIgnoreCase("Warning"))
			test.log(LogStatus.WARNING, expected, actual);
		else
			test.log(LogStatus.INFO, expected, actual);
	}
	
	public ExtentReports startResult(){
		report = new ExtentReports("./Results/result.html",true);
//		extent.loadConfig(new File("./src/main/resources/extent-config.xml"));
		return report;
	}
	
	public ExtentTest startTestCase(String testCaseName, String testDescription){
		test = report.startTest(testCaseName, testDescription);
		test.assignAuthor(authors);
		test.assignCategory(category);
		
		return test;
	}
	
	public void endTestcase(){
		report.endTest(test);
	}
	
	public void endResult(){
		report.flush();
	}
}
