package selenium;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Naukri {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./bin/driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//a[@title='Google apps']").click();
		driver.findElementById("gb36").click();
		/*driver.findElementById("login_Layer").click();
		try{
			driver.findElementById("eLogin").sendKeys("rachitjain123456@gmail.com");
		}catch(Exception e){
			driver.findElementById("eLoginNew").sendKeys("rachitjain123456@gmail.com");
		}
		driver.findElementById("pLogin").sendKeys("mypass1990");
		
		WebElement ele1 = driver.findElementByXPath("//button[contains(text(),'Login')]");
		ele1.click();
		System.out.println("Clicked on Login");
		WebElement ele = driver.findElementByXPath("//span[@class='topIcon jobs']");
		
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		Thread.sleep(5000);
		driver.findElementByLinkText("Jobs by Skill").click();
		Thread.sleep(3000);
		
		Set<String> s= driver.getWindowHandles();
		for (String s1 : s) {
			try{
				if(driver.findElementByXPath("//a[@title='Networking Jobs']").isDisplayed());
				break;
			}catch(Exception e){
				driver.switchTo().window(s1);
			}
		}
		Thread.sleep(3000);
		
		driver.findElementByName("qp").sendKeys("Selenium, Selenium Webdriver, POM, TestNG");
		driver.findElementByName("qp").sendKeys(Keys.TAB);
		driver.findElementByName("ql").sendKeys("Chennai, Bangalore, Delhi/NCR");
		driver.findElementByName("qp").sendKeys(Keys.TAB);
		driver.findElementByXPath("//input[@placeholder='Experience']").click();
		driver.findElementByXPath("//input[@placeholder='Experience']/following::li[5]").click();
		driver.findElementByXPath("//input[@placeholder='Salary']").click();
		driver.findElementByXPath("//input[@placeholder='Salary']/following::li[7]").click();
		driver.findElementById("qsbFormBtn").click();*/
		
	}

}
