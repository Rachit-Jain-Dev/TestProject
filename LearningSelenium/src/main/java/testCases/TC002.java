package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.ProjectWrappers;

public class TC002 extends ProjectWrappers{
	@BeforeClass
	public void setValues(){
		System.out.println("@BeforeClass");
		browserName = "chrome";
		dataSheetName = "TC002";
		testCaseName = "Verify_Flights_Tickets_Page";
		testDescription = "Enter Username & Password and then click on Flight Tickets link";
		category = "smoke";
		authors = "Rachit";
	}
	
	@Test(groups={"sanity"}, dataProvider = "fetchData")
	public void loginLogOut(String Username, String Password, String Orig, String Dest) throws InterruptedException{
		System.out.println("test");
		new LoginPage(driver, test)
		.enterUserName(Username)
		.ClickFlightTickets()
		.SelectTrip()
		.EnterOrigin(Orig)
		.EnterDestination(Dest)
		.clickHome()
		.enterPassword(Password);
	}
}
