package selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FbSignup {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElementById("u_0_2").sendKeys("Rachit");
		driver.findElementById("u_0_4").sendKeys("Jain");
		driver.findElementById("u_0_7").sendKeys("jain_rachit90@rediffmail.com");
		driver.findElementById("u_0_a").sendKeys("jain_rachit90@rediffmail.com");
		driver.findElementById("u_0_e").sendKeys("secretPass17");
		new Select(driver.findElementById("day")).selectByIndex(2);
		new Select(driver.findElementById("month")).selectByVisibleText("Jul");
		new Select(driver.findElementById("year")).selectByValue("1991");
		driver.findElementById("u_0_i").click();
		driver.findElementById("u_0_m").click();
	}

}
