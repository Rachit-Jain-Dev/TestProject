package testDataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import dataDriven.DP;

public class TestDP {
	@Test(dataProvider="fetchData", dataProviderClass=DP.class)
	public void fetchDataFromExcel(String uName, String pwd) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https:/irctc.co.in");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("usernameId").sendKeys(uName);
		driver.findElementByName("j_password").sendKeys(pwd);
		
		Thread.sleep(5000);
		driver.close();
		
	}
}
