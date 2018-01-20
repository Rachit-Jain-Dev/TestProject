package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import wrappers.ProjectWrappers;

import com.relevantcodes.extentreports.ExtentTest;

public class LoginPage extends ProjectWrappers{
	public LoginPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test; 
		/*if(!(driver.getCurrentUrl()=="https://www.irctc.co.in/eticketing/loginHome.jsf")){
			report("fail","This should be Login Page","This is not a Login Page",true);
		}*/
	}
	
	public LoginPage enterUserName(String data){
		enterById("usernameId", data);
		return this;
	}
	
	public LoginPage enterPassword(String data){
		enterByName("j_password", data);
		return this;
	}
	
	public SignUpPage clickSignUp(){
		clickByLink("Sign up");
		return new SignUpPage(driver,test);
	}
	
	public FlightTicketsPage ClickFlightTickets(){
		clickByLink("Flight Tickets");
		switchToLastWindow();
		return new FlightTicketsPage(driver,test);
	}
}
