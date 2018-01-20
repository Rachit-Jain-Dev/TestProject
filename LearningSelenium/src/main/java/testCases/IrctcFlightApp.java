package testCases;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import dp.DataInputProvider;
import wrappers.ProjectWrappers;

public class IrctcFlightApp extends ProjectWrappers{
	@Test(groups="smoke", dataProvider="DP_testdata", dataProviderClass=DataInputProvider.class)
	public void flightApp(String Origin, String Destination) throws InterruptedException{
		//invokeApp("chrome", "https://www.irctc.co.in");
		clickByLink("Flight Tickets");
		switchToLastWindow();
		clickByXpath("//input[@value='One way']");
		enterById("origin", Origin);
		Thread.sleep(1000);
		enterByKeys("origin", Keys.ENTER);
		enterById("destination", Destination);
		Thread.sleep(1000);
		enterByKeys("destination", Keys.ENTER);
		clickByXpath("//img[@class='ui-datepicker-trigger']");
		clickByXpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[2]/td[7]/a");
		selectVisibileTextByName("airlinePreference", "Vistara Airline");
		clickByXpathNoSnap("//div[@class='srchbtn']");
		/*String alertText = getAlertText();
		System.out.println("The Alert Text is\n"+alertText);
		acceptAlert();*/
	}
}
