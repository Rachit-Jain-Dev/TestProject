package day3;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
public class IrctcFlightBooking {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.irctc.co.in");
		driver.findElementByLinkText("Flight Tickets").click();
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println("Parent Window - "+parentWindow);
		System.out.println("All Windows - "+allWindows);
		
		for (String s : allWindows) {			//Navigating to the last Window
			driver.switchTo().window(s);
		}
		
		driver.findElementByXPath("//input[@value='One way']").click();
		driver.findElementById("origin").sendKeys("MAA");
		driver.findElementById("origin").sendKeys(Keys.DOWN);
		driver.findElementById("origin").sendKeys(Keys.ENTER);
		driver.findElementById("destination").sendKeys("DEL");
		driver.findElementById("destination").sendKeys(Keys.DOWN);
		driver.findElementById("destination").sendKeys(Keys.ENTER);
		driver.findElementByXPath("//img[@class='ui-datepicker-trigger']").click();
		driver.findElementByXPath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[1]/td[5]/a").click();
		driver.findElementByXPath("//div[@class='srchbtn']").click();			
	}
}
