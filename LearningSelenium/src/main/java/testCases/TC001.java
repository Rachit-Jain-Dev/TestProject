package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dp.DataInputProvider;
import pages.LoginPage;
import wrappers.ProjectWrappers;

public class TC001 extends ProjectWrappers{
	@BeforeClass
	public void setValues(){
		System.out.println("@BeforeClass");
		browserName = "chrome";
		dataSheetName = "TC001";
		testCaseName = "Verify_Login_Page";
		testDescription = "Enter Username & Password and then click on SignUp link";
		category = "smoke";
		authors = "Rachit";
	}
	
	@Test(groups={"sanity"}, dataProvider = "fetchData")
	public void loginLogOut(String Username, String Password, String SignUpUName, String SignUpPwd){
		System.out.println("test");
		new LoginPage(driver, test)
		.enterUserName(Username)
		.enterPassword(Password)
		.clickSignUp()
		.enterSignUpUserName(SignUpUName)
		.enterSignUpPassword(SignUpPwd)
		.clickLogin();
	}
	
}
