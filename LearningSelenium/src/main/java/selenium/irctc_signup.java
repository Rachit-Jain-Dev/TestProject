package selenium;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class irctc_signup {
	public static void main(String[] args) throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://irctc.co.in");
		driver.findElementByLinkText("Sign up").click();
		driver.findElementById("userRegistrationForm:userName").sendKeys("Rachit9841");
		driver.findElementById("userRegistrationForm:password").sendKeys("Secret_Pass12");
		driver.findElementById("userRegistrationForm:confpasword").sendKeys("Secret_Pass12");
		
		driver.findElementById("userRegistrationForm:firstName").sendKeys("Rachit");
		driver.findElementById("userRegistrationForm:middleName").sendKeys("K");
		driver.findElementById("userRegistrationForm:lastName").sendKeys("Jain");
		driver.findElementById("userRegistrationForm:gender:0").click();
		driver.findElementById("userRegistrationForm:maritalStatus:1").click();
		Select s1 = new Select(driver.findElementById("userRegistrationForm:dobDay"));
		s1.selectByVisibleText("02");
		Select s2 = new Select(driver.findElementById("userRegistrationForm:dobMonth"));
		s2.selectByValue("07");
		Select s3 = new Select(driver.findElementById("userRegistrationForm:dateOfBirth"));
		s3.selectByVisibleText("1991");
		new Select(driver.findElementById("userRegistrationForm:occupation")).selectByVisibleText("Private");
		driver.findElementById("userRegistrationForm:email").sendKeys("rachitjain123456@gmail.com");
		driver.findElementById("userRegistrationForm:mobile").sendKeys("9811509533");
		new Select(driver.findElementById("userRegistrationForm:nationalityId")).selectByVisibleText("India");
		
		driver.findElementById("userRegistrationForm:address").sendKeys("House No 524");
		
		Select country=new Select(driver.findElementById("userRegistrationForm:countries"));
		List<WebElement> L= country.getOptions();
		System.out.println("The country dropdown has the following values: -");
		for(WebElement w: L){
			System.out.println(w.getText());
		}
		
		driver.findElementById("userRegistrationForm:countries").sendKeys("E");
		driver.findElementById("userRegistrationForm:countries").sendKeys("E");
		driver.findElementById("userRegistrationForm:countries").sendKeys(Keys.ENTER);
		
		//new Select(driver.findElementById("userRegistrationForm:countries")).selectByVisibleText("India");
		driver.findElementById("userRegistrationForm:pincode").sendKeys("110055");
		driver.findElementById("userRegistrationForm:statesName").click();
		System.out.println(driver.findElementById("userRegistrationForm:statesName").getText());
		Thread.sleep(2000);
		new Select(driver.findElementById("userRegistrationForm:cityName")).selectByIndex(1);
		Thread.sleep(2000);
		new Select(driver.findElementById("userRegistrationForm:postofficeName")).selectByIndex(3);
		driver.findElementById("userRegistrationForm:landline").sendKeys("01123562624");
		driver.findElementById("userRegistrationForm:resAndOff:0").click();
		driver.close();		
		
	}
}
