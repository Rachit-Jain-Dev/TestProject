package wrappers;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentTest;

import dp.DataInputProvider;

public class ProjectWrappers extends GenericWrappers{
	public String browserName, dataSheetName;
	
	@BeforeSuite
	public void beforeSuite(){
		System.out.println("beforeSuite");
		startResult();
	}
	
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("beforeMethod");
		test = startTestCase(testCaseName, testDescription);	
		test.assignCategory(category);
		test.assignAuthor(authors);
		invokeApp(browserName, "https://www.irctc.co.in");
	}
	
	/*
	@BeforeMethod
	public void launchIrctc(){
		invokeApp("chrome", "https://www.irctc.co.in");
	}*/
	
	@AfterMethod
	public void closeIrctc(){
		System.out.println("@AfterMethod");
		endTestcase();
		closeAllBrowsers();
	}
	
	@AfterSuite
	public void afterSuite(){
		System.out.println("@AfterSuite");
		endResult();
	}
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("@BeforeTest");
		//loadObjects();
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("@AfterTest");
	//	unloadObjects();
	}
	
	@DataProvider(name="fetchData")
	public Object[][] getData() throws IOException{
		System.out.println("@DataProvider");
		return DataInputProvider.readExcelData("./testData/"+dataSheetName+".xlsx");		
	}	
}
