package selenium;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./bin/driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://irctc.co.in");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByLinkText("Flight Tickets").click();;
		driver.findElementByLinkText("E-Catering").click();
		driver.findElementByLinkText("E-Bedroll").click();
		driver.findElementByLinkText("Cab / Bus").click();
		driver.findElementByLinkText("E-Wheelchair").click();
		driver.findElementByLinkText("IRCTC Rail Connect App").click();
		
		Set<String> s = driver.getWindowHandles();
		System.out.println(s);
		for (String s1 : s) {
			driver.switchTo().window(s1);
			System.out.println(s1+"---------"+driver.getTitle());
		}
	}

}
