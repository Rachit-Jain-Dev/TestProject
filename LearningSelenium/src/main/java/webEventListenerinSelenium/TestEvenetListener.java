package webEventListenerinSelenium;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(webEventListenerinSelenium.Listener.class)
public class TestEvenetListener extends TestBase{
	@Test
	public void testEventListener() throws InterruptedException{
		driver.get("https://irctc.co.in");
		driver.findElement(By.linkText("Sign up")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("userRegistrationForm:userName")).sendKeys("Rachit9841");
		driver.findElement(By.id("userRegistrationForm:password")).sendKeys("Secret_Pass12");
		driver.findElement(By.id("userRegistrationForm:confpasword")).sendKeys("Secret_Pass12");
		
		driver.findElement(By.id("userRegistrationForm:firstName")).sendKeys("Rachit");
		driver.findElement(By.id("userRegistrationForm:middleName")).sendKeys("K");
		driver.findElement(By.id("userRegistrationForm:lastName")).sendKeys("Jain");
		Thread.sleep(3000);
		driver.findElement(By.id("userRegistrationForm:gender:0")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("userRegistrationForm:maritalStatus:1")).click();
	}
}
