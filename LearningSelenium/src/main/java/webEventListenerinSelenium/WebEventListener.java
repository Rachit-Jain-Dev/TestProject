package webEventListenerinSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

public class WebEventListener implements WebDriverEventListener{
	
	public void beforeAlertAccept(WebDriver driver) {
		Reporter.log("Alert is present "+driver.switchTo().alert().getText());
	}

	public void afterAlertAccept(WebDriver driver) {
		Reporter.log("Alert is accepted"); 
	}
	
	public void beforeAlertDismiss(WebDriver driver) {
		Reporter.log("Alert is present "+driver.switchTo().alert().getText());
	}

	public void afterAlertDismiss(WebDriver driver) {	
		Reporter.log("Alert is dismissed");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		Reporter.log("Value of the: "+element.toString()+" before any changes made");
		Reporter.log("Value of the: "+element.toString()+keysToSend);
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {	
		/*Reporter.log("Element Value changed to: "+element.toString());
		Reporter.log("Value of the: "+element.toString()+keysToSend);*/
	}
	
	public void beforeClickOn(WebElement element, WebDriver driver) {
		Reporter.log("Clicking on: " +element.getText());
		Reporter.log(element.toString());
	}//Clicking on: Sign up
	 //[[ChromeDriver: chrome on XP (1ef55ce4999e84af47c621e97b38339a)] -> link text: Sign up]
	
	public void afterClickOn(WebElement element, WebDriver driver) {
		/*Reporter.log("Clicked on: " +element.getText());
		Reporter.log(element.toString());*/
	}
	
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		Reporter.log("Finding the Element: " +by.toString());
	}//Finding the Element: By.linkText: Sign up

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		//Reporter.log("Found the Element: " +by.toString());
	}
	
	public void beforeNavigateTo(String url, WebDriver driver) {
		Reporter.log("Navigation to: "+url);		
	}//Navigation to: https://irctc.co.in
	
	public void afterNavigateTo(String url, WebDriver driver) {
		Reporter.log("Navigated to: "+url);
	}//Navigation to: https://irctc.co.in
	
	public void afterNavigateBack(WebDriver driver) {
		
		
	}

	public void afterNavigateForward(WebDriver driver) {
		
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		
		
	}
	

	public void afterScript(String arg0, WebDriver driver) {
		
		
	}

	public void beforeNavigateBack(WebDriver driver) {
				
	}

	public void beforeNavigateForward(WebDriver driver) {
		
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		
		
	}

	

	public void beforeScript(String arg0, WebDriver driver) {
		
		
	}

	public void onException(Throwable arg0, WebDriver driver) {
		
		
	}
	
}
