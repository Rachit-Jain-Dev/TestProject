package day3;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class LearnFrames {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		
		WebElement frameElement = driver.findElementById("iframeResult");
		driver.switchTo().frame(frameElement);
		
		driver.findElementByXPath("/html/body/button").click();
		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Prinu Jain");
		alert.accept();
		
		driver.switchTo().defaultContent(); //or driver.switchTo().parentFrame(); 
		
		driver.findElementById("tryhome").click();
		
		Set<String> allWindows = driver.getWindowHandles();
		for (String s : allWindows) {		//Navigating to Last Window
			driver.switchTo().window(s);
		}
		
		String s1 = driver.findElementByLinkText("Learn HTML").getText();
		System.out.println(s1);
	}
}
