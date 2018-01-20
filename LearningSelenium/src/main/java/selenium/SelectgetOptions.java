package selenium;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectgetOptions {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://irctc.co.in");
		driver.findElementByLinkText("Sign up").click();
		
		Select s2 = new Select(driver.findElementById("userRegistrationForm:dobMonth"));
		List<WebElement> l = s2.getOptions();
		for(int i=0;i<l.size();i++)
			System.out.println(l.get(i).getText());
		WebElement table = driver.findElementByTagName("table");
	}
}
