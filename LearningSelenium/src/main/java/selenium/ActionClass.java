package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {
	public static void main(String args[]) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/bin/driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/");
		driver.findElementByLinkText("Sign up").click();
		WebElement ele = driver.findElementByXPath("(//a[@href='#'])[3]");
		Actions action = new Actions(driver);
		
		action.moveToElement(ele).build().perform();
		Thread.sleep(3000);
		WebElement ele1 = driver.findElementByXPath("//a[contains(text(),'Accommodations')]");
		action.moveToElement(ele1).build().perform();
		Thread.sleep(3000);
		driver.findElementByXPath("//a[contains(text(),'Hotels & Lounge')]").click();
	}
}
