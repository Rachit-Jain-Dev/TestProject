package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrappers;

public class SignUpPage extends ProjectWrappers{
	public SignUpPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test; 
		
	}
	
	public SignUpPage enterSignUpUserName(String data){
		enterById("userRegistrationForm:userName", data);
		return this;
	}
	
	public SignUpPage enterSignUpPassword(String data){
		enterById("userRegistrationForm:password", data);
		return this;
	}
	
	public LoginPage clickLogin(){
		clickByLink("Home");
		return new LoginPage(driver,test);
	}
}
