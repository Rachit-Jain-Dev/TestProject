package selenium;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Monster {
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver", "./bin/driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.monsterindia.com/selenium-jobs-in-bangalore.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//a[@class='btn btn_purple pull-left']").click();
		System.out.println(driver.findElementByXPath("//a[@class='btn btn_purple pull-left']").getAttribute("text"));
		driver.findElementById("username_login").sendKeys("rachitjain123456@gmail.com");
		driver.findElementById("username_login").sendKeys(Keys.TAB);
		driver.findElementByXPath("//input[@id='password_input']").sendKeys("mypass1990");
		driver.findElementById("button").click();
		
		driver.navigate().back();
		driver.navigate().back();
		//driver.findElementByXPath("//a[contains(text(),' Next > ')]").click();
		//driver.findElementByXPath("//a[contains(text(),' Next > ')]").click();
		while(driver.findElementByXPath("//a[contains(text(),' Next > ')]").isDisplayed()){
			List l = driver.findElementsByXPath("//a[@class='btn pull-right apply']");
			System.out.println("Total jobs on a page "+l.size());
			for(int i=0;i<l.size();i++){
				driver.findElementByXPath("(//a[@class='btn pull-right apply'])["+(i+1)+"]").click();
				System.out.println("Job applied at "+(i+1));
				Set<String> s = driver.getWindowHandles();
				/*for (String s1 : s) {
					if(!(s1.equals(driver.getWindowHandle()))){
						driver.switchTo().window(s1);
						driver.close();
						driver.switchTo().window(driver.getWindowHandle());
					}
				}*/
			}
		}
	}
}
