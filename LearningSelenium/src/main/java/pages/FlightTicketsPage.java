package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;

import wrappers.ProjectWrappers;

import com.relevantcodes.extentreports.ExtentTest;

public class FlightTicketsPage extends ProjectWrappers{
	public FlightTicketsPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test; 
	}
	
	public FlightTicketsPage SelectTrip(){
		clickByXpath("//input[@value='One way']");
		return this;
	}
	
	public FlightTicketsPage EnterOrigin(String Origin) throws InterruptedException{
		enterById("origin", Origin);
		Thread.sleep(1000);
		enterByKeys("origin", Keys.ENTER);
		return this;
	}
	
	public FlightTicketsPage EnterDestination(String Destination) throws InterruptedException{
		enterById("destination", Destination);
		Thread.sleep(1000);
		enterByKeys("destination", Keys.ENTER);
		return this;
	}
	
	public LoginPage clickHome(){
		switchToParentWindow();
		return new LoginPage(driver,test);
	}
}
