package testCases;

import org.testng.annotations.Test;

import wrappers.ProjectWrappers;

public class IrctcsSignUp extends ProjectWrappers{
	@Test(groups="smoke")
	
	public void signUp() throws InterruptedException{
		clickByLink("Sign up");
		enterById("userRegistrationForm:userName","Rachit9841");
		enterById("userRegistrationForm:password","SecretPass12");
		enterById("userRegistrationForm:confpasword","SecretPass12");
		enterById("userRegistrationForm:firstName","Rachit");
		enterById("userRegistrationForm:middleName","K");	
		enterById("userRegistrationForm:lastName","Jain");
		clickById("userRegistrationForm:gender:0");
		clickById("userRegistrationForm:maritalStatus:1");
		selectVisibileTextById("userRegistrationForm:dobDay", "02");
		Thread.sleep(2000);
		selectVisibileTextById("userRegistrationForm:dobMonth", "JUL");
		Thread.sleep(2000);
		selectVisibileTextById("userRegistrationForm:dateOfBirth", "1991");
		selectVisibileTextById("userRegistrationForm:occupation", "Private");
		enterById("userRegistrationForm:email","rachitjain123456@gmail.com");
		enterById("userRegistrationForm:mobile","9811509533");
		selectVisibileTextById("userRegistrationForm:nationalityId", "India");
		enterById("userRegistrationForm:address","House No 524");
		selectVisibileTextById("userRegistrationForm:countries","India");
		enterById("userRegistrationForm:pincode","110055");
		clickById("userRegistrationForm:statesName");
		String s = getTextById("userRegistrationForm:statesName");
		System.out.println(s);
		Thread.sleep(2000);
		selectIndexById("userRegistrationForm:cityName", 1);
		Thread.sleep(2000);
		selectIndexById("userRegistrationForm:postofficeName", 3);
		enterById("userRegistrationForm:landline","01123562624");
		clickById("userRegistrationForm:resAndOff:0");	
		clickByLinkNoSnap("Submit Registration Form>>>");
		
		String alertText = getAlertText();
		System.out.println("The Alert Text is\n"+alertText);
		acceptAlert();
	}

}
