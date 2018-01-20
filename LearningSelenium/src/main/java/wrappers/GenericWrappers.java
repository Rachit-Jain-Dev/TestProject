package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import reporter.SampleReport;

public class GenericWrappers extends SampleReport implements Wrappers {
	
	public RemoteWebDriver driver;
	int i=0;
	public void invokeApp(String browser, String url){
		try{
			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")){
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("IE")){
				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}else {
				System.setProperty("phantomjs.binary.path", "./drivers/phantomjs.exe");
				driver = new PhantomJSDriver();
			}
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			report("Pass","The Browser "+browser+" should be launched successfully","The Browser "+browser+" launched successfully",true);
			
		}catch(WebDriverException e){
			report("Fail","The Browser "+browser+" should be launched successfully","The Browser "+browser+" got closed, due to unknown error",true);
		//	System.err.println("The Browser "+browser+" got closed, due to unknown error");
		}	
	}
	
	
	public void enterById(String idValue, String data){
		try{
			driver.findElementById(idValue).clear();
			driver.findElementById(idValue).sendKeys(data);
			report("pass","The Text field "+idValue+" should be entered with the text "+data,"The Text field "+idValue+" is entered with the text "+data,true);
		}catch(NoSuchElementException n){
			report("Fail","The Text field "+idValue+" should be entered with the text "+data,"The Text field "+idValue+" is not found in the webpage",true);
		}catch(ElementNotVisibleException ev){
			report("Fail","The Text field "+idValue+" should be entered with the text "+data,"The Text field "+idValue+" is not visible in the webpage",true);
		}catch(ElementNotSelectableException es){
			report("Fail","The Text field "+idValue+" should be entered with the text "+data,"The Text field "+idValue+" is disabled, and so is not able to select",true);
		}catch(TimeoutException t){
			report("Fail","The Text field "+idValue+" should be entered with the text "+data,"The Text field "+idValue+" is not entered, since execution is failed because the command did not complete in enough time",true);
		}catch(WebDriverException e){
			report("Fail","The Text field "+idValue+" should be entered with the text "+data,"The Browser got closed, due to unknown error",true);
		}catch(Exception e){
			report("Fail","The Text field "+idValue+" should be entered with the text "+data,"The Text field "+idValue+" is not entered with the text "+data+", due to unknown error",true);
		}
	}

	
	public void enterByName(String nameValue, String data){
		try{
			driver.findElementByName(nameValue).clear();
			driver.findElementByName(nameValue).sendKeys(data);
			report("Pass","The Text field "+nameValue+" should be entered with the text "+data,"The Text field "+nameValue+" is entered with the text "+data,true);
		}catch(NoSuchElementException n){
			report("Fail","The Text field "+nameValue+" should be entered with the text "+data,"The Text field "+nameValue+" is not found in the webpage",true);
		}catch(ElementNotVisibleException ev){
			report("Fail","The Text field "+nameValue+" should be entered with the text "+data,"The Text field "+nameValue+" is not visible in the webpage",true);
		}catch(ElementNotSelectableException es){
			report("Fail","The Text field "+nameValue+" should be entered with the text "+data,"The Text field "+nameValue+" is disabled, and so is not able to select",true);
		}catch(TimeoutException t){
			report("Fail","The Text field "+nameValue+" should be entered with the text "+data,"The Text field "+nameValue+" is not entered, since execution is failed because the command did not complete in enough time",true);
		}catch(WebDriverException e){
			report("Fail","The Text field "+nameValue+" should be entered with the text "+data,"The Browser got closed, due to unknown error",true);
		}catch(Exception e){
			report("Fail","The Text field "+nameValue+" should be entered with the text "+data,"The Text field "+nameValue+" is not entered with the text "+data+", due to unknown error",true);
		}
	}

	
	public void enterByXpath(String xpathValue, String data){
		try{
			driver.findElementByXPath(xpathValue).clear();
			driver.findElementByXPath(xpathValue).sendKeys(data);
			report("pass","The Text field "+xpathValue+" should be entered with the text "+data,"The Text field "+xpathValue+" is entered with the text "+data,true);
		}catch(NoSuchElementException n){
			report("fail","The Text field "+xpathValue+" should be entered with the text "+data,"The Text field "+xpathValue+" is not found in the webpage",true);
		}catch(ElementNotVisibleException ev){
			report("fail","The Text field "+xpathValue+" should be entered with the text "+data,"The Text field "+xpathValue+" is not visible in the webpage",true);
		}catch(ElementNotSelectableException es){
			report("fail","The Text field "+xpathValue+" should be entered with the text "+data,"The Text field "+xpathValue+" is disabled, and so is not able to select",true);
		}catch(TimeoutException t){
			report("fail","The Text field "+xpathValue+" should be entered with the text "+data,"The Text field "+xpathValue+" is not entered, since execution is failed because the command did not complete in enough time",true);
		}catch(WebDriverException e){
			report("fail","The Text field "+xpathValue+" should be entered with the text "+data,"The Browser got closed, due to unknown error",true);
		}catch(Exception e){
			report("fail","The Text field "+xpathValue+" should be entered with the text "+data,"The Text field "+xpathValue+" is not entered with the text "+data+", due to unknown error",true);
		}		
	}

	
	
	public boolean verifyTitle(String title) {
		boolean bReturn = false;
		try{
			if(driver.getTitle().equals(title)){
				report("pass","The title "+title+" should be verified and got matched","The title "+title+" is verified and got matched",true);
				bReturn = true;
			}
			else
				report("fail","The title "+title+" should be verified and got matched","The title "+title+" is verified and got mismatched",true);
		}catch(WebDriverException e){
			report("fail","The title "+title+" should be verified and got matched","The Browser got closed, due to unknown error",true);
		}catch(Exception e){
			report("fail","The title "+title+" should be verified and got matched","The title "+title+" is not verified",true);
		}
		return bReturn;
	}

	
	public void verifyTextById(String id, String text){
		try{
			String s = driver.findElementById(id).getText();
			if(s.equals(text))
				report("pass","The text "+text+" with the field "+id+" should be verified and got matched","The text "+text+" with the field "+id+" is verified and got matched",true);
			else
				report("fail","The text "+text+" with the field "+id+" should be verified and got matched","The text "+text+" with the field "+id+" is verified and got mismatched",true);
		}catch(NoSuchElementException n){
			report("fail","The text "+text+" with the field "+id+" should be verified and got matched","The id field "+id+" is not found in the webpage",true);
		}catch(ElementNotVisibleException ev){
			report("fail","The text "+text+" with the field "+id+" should be verified and got matched","The id field "+id+" is not visible in the webpage",true);
		}catch(TimeoutException t){
			report("fail","The text "+text+" with the field "+id+" should be verified and got matched","The id field "+id+" is not verified, since execution is failed because the command did not complete in enough time",true);
		}catch(WebDriverException e){
			report("fail","The text "+text+" with the field "+id+" should be verified and got matched","The Browser got closed, due to unknown error",true);
		}catch(Exception e){
			report("fail","The text "+text+" with the field "+id+" should be verified and got matched","The id field "+id+" is not verified with the text "+text+", due to unknown error",true);
		}		
	}

	
	public void verifyTextByXpath(String xpath, String text){
		try{
			String s = driver.findElementByXPath(xpath).getText();
			if(s.equals(text))
				report("pass","The text "+text+" with the field "+xpath+" should be verified and got matched","The text "+text+" with the field "+xpath+" is verified and got matched",true);
			else
				report("fail","The text "+text+" with the field "+xpath+" should be verified and got matched","The text "+text+" with the field "+xpath+" is verified and got mismatched",true);
		}catch(NoSuchElementException n){
			report("fail","The text "+text+" with the field "+xpath+" should be verified and got matched","The field "+xpath+" is not found in the webpage",true);
		}catch(ElementNotVisibleException ev){
			report("fail","The text "+text+" with the field "+xpath+" should be verified and got matched","The field "+xpath+" is not visible in the webpage",true);
		}catch(TimeoutException t){
			report("fail","The text "+text+" with the field "+xpath+" should be verified and got matched","The field "+xpath+" is not verified, since execution is failed because the command did not complete in enough time",true);
		}catch(WebDriverException e){
			report("fail","The text "+text+" with the field "+xpath+" should be verified and got matched","The Browser got closed, due to unknown error",true);
		}catch(Exception e){
			report("fail","The text "+text+" with the field "+xpath+" should be verified and got matched","The field "+xpath+" is not verified with the text "+text+", due to unknown error",true);
		}		
	}

	
	public void verifyTextContainsByXpath(String xpath, String text) {
		try{
			String s = driver.findElementByXPath(xpath).getText();
			if(text.contains(s))
				report("pass","The text "+text+" with the field "+xpath+" should be verified and got partially matched","The text "+text+" with the field "+xpath+" is verified and got partially matched",true);
			else
				report("fail","The text "+text+" with the field "+xpath+" should be verified and got partially matched","The text "+text+" with the field "+xpath+" is verified and got partially mismatched",true);
		}catch(NoSuchElementException n){
			report("fail","The text "+text+" with the field "+xpath+" should be verified and got partially matched","The field "+xpath+" is not found in the webpage",true);
		}catch(ElementNotVisibleException ev){
			report("fail","The text "+text+" with the field "+xpath+" should be verified and got partially matched","The field "+xpath+" is not visible in the webpage",true);
		}catch(TimeoutException t){
			report("fail","The text "+text+" with the field "+xpath+" should be verified and got partially matched","The field "+xpath+" is not verified, since execution is failed because the command did not complete in enough time",true);
		}catch(WebDriverException e){
			report("fail","The text "+text+" with the field "+xpath+" should be verified and got partially matched","The Browser got closed, due to unknown error",true);
		}catch(Exception e){
			report("fail","The text "+text+" with the field "+xpath+" should be verified and got partially matched","The field "+xpath+" is not verified with the text "+text+", due to unknown error",true);
		}
	}

	
	public void clickById(String id){
		try{
			driver.findElementById(id).click();
			report("pass","The Element with field "+id+" should be clicked","The Element with field "+id+" is clicked",true);
		}catch(NoSuchElementException n){
			report("fail","The Element with field "+id+" should be clicked","The Element with field "+id+" is not found in the webpage",true);
		}catch(ElementNotVisibleException ev){
			report("fail","The Element with field "+id+" should be clicked","The Element with field "+id+" is not visible in the webpage",true);
		}catch(TimeoutException t){
			report("fail","The Element with field "+id+" should be clicked","The Element with field "+id+" is not found, since execution is failed because the command did not complete in enough time",true);
		}catch(WebDriverException e){
			report("fail","The Element with field "+id+" should be clicked","The Browser got closed, due to unknown error",true);
		}catch(Exception e){
			report("fail","The Element with field "+id+" should be clicked","The Element with field "+id+" is not found, due to unknown error",true);
		}	
	}

	
	public void clickByClassName(String classVal){
		try{
			driver.findElementByClassName(classVal).click();
			report("pass","The Element with field "+classVal+" should be clicked","The Element with field "+classVal+" is clicked",true);
		}catch(NoSuchElementException n){
			report("fail","The Element with field "+classVal+" should be clicked","The Element with field "+classVal+" is not found in the webpage",true);
		}catch(ElementNotVisibleException ev){
			report("fail","The Element with field "+classVal+" should be clicked","The Element with field "+classVal+" is not visible in the webpage",true);
		}catch(TimeoutException t){
			report("fail","The Element with field "+classVal+" should be clicked","The Element with field "+classVal+" is not found, since execution is failed because the command did not complete in enough time",true);
		}catch(WebDriverException e){
			report("fail","The Element with field "+classVal+" should be clicked","The Browser got closed, due to unknown error",true);
		}catch(Exception e){
			report("fail","The Element with field "+classVal+" should be clicked","The Element with field "+classVal+" is not found, due to unknown error",true);
		}	
	}

	
	public void clickByName(String name){
		try{
			driver.findElementByName(name).click();
			report("pass","The Element with field "+name+" should be clicked","The Element with field "+name+" is clicked",true);
		}catch(NoSuchElementException n){
			report("fail","The Element with field "+name+" should be clicked","The Element with field "+name+" is not found in the webpage",true);
		}catch(ElementNotVisibleException ev){
			report("fail","The Element with field "+name+" should be clicked","The Element with field "+name+" is not visible in the webpage",true);
		}catch(TimeoutException t){
			report("fail","The Element with field "+name+" should be clicked","The Element with field "+name+" is not found, since execution is failed because the command did not complete in enough time",true);
		}catch(WebDriverException e){
			report("fail","The Element with field "+name+" should be clicked","The Browser got closed, due to unknown error",true);
		}catch(Exception e){
			report("fail","The Element with field "+name+" should be clicked","The Element with field "+name+" is not found, due to unknown error",true);
		}
	}

	
	public void clickByLink(String name){
		try{
			driver.findElementByLinkText(name).click();
			report("pass","The link with field "+name+" should be clicked","The link with field "+name+" is clicked",true);
		}catch(NoSuchElementException n){
			report("fail","The link with field "+name+" should be clicked","The link with field "+name+" is not found in the webpage",true);
		}catch(ElementNotVisibleException ev){
			report("fail","The link with field "+name+" should be clicked","The link with field "+name+" is not visible in the webpage",true);
		}catch(TimeoutException t){
			report("fail","The link with field "+name+" should be clicked","The link with field "+name+" is not found, since execution is failed because the command did not complete in enough time",true);
		}catch(WebDriverException e){
			report("fail","The link with field "+name+" should be clicked","The Browser got closed, due to unknown error",true);
		}catch(Exception e){
			report("fail","The link with field "+name+" should be clicked","The link with field "+name+" is not found, due to unknown error",true);
		}	
	}

	
	public void clickByLinkNoSnap(String name){
		try{
			driver.findElementByLinkText(name).click();
			report("pass","The link with field "+name+" should be clicked","The link with field "+name+" is clicked",true);
		}catch(NoSuchElementException n){
			report("fail","The link with field "+name+" should be clicked","The link with field "+name+" is not found in the webpage",true);
		}catch(ElementNotVisibleException ev){
			report("fail","The link with field "+name+" should be clicked","The link with field "+name+" is not visible in the webpage",true);
		}catch(TimeoutException t){
			report("fail","The link with field "+name+" should be clicked","The link with field "+name+" is not found, since execution is failed because the command did not complete in enough time",true);
		}catch(WebDriverException e){
			report("fail","The link with field "+name+" should be clicked","The Browser got closed, due to unknown error",true);
		}catch(Exception e){
			report("fail","The link with field "+name+" should be clicked","The link with field "+name+" is not found, due to unknown error",true);
		}
	}

	
	public void clickByXpath(String xpathVal) {
		try{
			driver.findElementByXPath(xpathVal).click();
			report("pass","The Element with field "+xpathVal+" should be clicked","The Element with field "+xpathVal+" is clicked",true);
		}catch(NoSuchElementException n){
			report("fail","The Element with field "+xpathVal+" should be clicked","The Element with field "+xpathVal+" is not found in the webpage",true);
		}catch(ElementNotVisibleException ev){
			report("fail","The Element with field "+xpathVal+" should be clicked","The Element with field "+xpathVal+" is not visible in the webpage",true);
		}catch(TimeoutException t){
			report("fail","The Element with field "+xpathVal+" should be clicked","The Element with field "+xpathVal+" is not found, since execution is failed because the command did not complete in enough time",true);
		}catch(WebDriverException e){
			report("fail","The Element with field "+xpathVal+" should be clicked","The Browser got closed, due to unknown error",true);
		}catch(Exception e){
			report("fail","The Element with field "+xpathVal+" should be clicked","The Element with field "+xpathVal+" is not found, due to unknown error",true);
		}
	}

	
	public void clickByXpathNoSnap(String xpathVal){
		try{
			driver.findElementByXPath(xpathVal).click();
			report("pass","The Element with field "+xpathVal+" should be clicked","The Element with field "+xpathVal+" is clicked",false);
		}catch(NoSuchElementException n){
			report("fail","The Element with field "+xpathVal+" should be clicked","The Element with field "+xpathVal+" is not found in the webpage",false);
		}catch(ElementNotVisibleException ev){
			report("fail","The Element with field "+xpathVal+" should be clicked","The Element with field "+xpathVal+" is not visible in the webpage",false);
		}catch(TimeoutException t){
			report("fail","The Element with field "+xpathVal+" should be clicked","The Element with field "+xpathVal+" is not found, since execution is failed because the command did not complete in enough time",false);
		}catch(WebDriverException e){
			report("fail","The Element with field "+xpathVal+" should be clicked","The Browser got closed, due to unknown error",false);
		}catch(Exception e){
			report("fail","The Element with field "+xpathVal+" should be clicked","The Element with field "+xpathVal+" is not found, due to unknown error",false);
		}		
	}

	
	public String getTextById(String idVal) {
		String s= null;
		try{
			s = driver.findElementById(idVal).getText();
			report("pass","The Text: "+s+" should be returned successfully from the Id "+idVal,"The Text: "+s+" is returned successfully from the Id "+idVal,true);
		}catch(NoSuchElementException n){
			report("fail","The Text: "+s+" should be returned successfully from the Id "+idVal,"The Element with field "+idVal+" is not found in the webpage",true);
		}catch(ElementNotVisibleException ev){
			report("fail","The Text: "+s+" should be returned successfully from the Id "+idVal,"The Element with field "+idVal+" is not visible in the webpage",true);
		}catch(TimeoutException t){
			report("fail","The Text: "+s+" should be returned successfully from the Id "+idVal,"The Element with field "+idVal+" is not found, since execution is failed because the command did not complete in enough time",true);
		}catch(WebDriverException e){
			report("fail","The Text: "+s+" should be returned successfully from the Id "+idVal,"The Browser got closed, due to unknown error",true);
		}catch(Exception e){
			report("fail","The Text: "+s+" should be returned successfully from the Id "+idVal,"The Element with field "+idVal+" is not found, due to unknown error",true);
		}
		return s;
	}

	
	public String getTextByXpath(String xpathVal) {
		String s= null;
		try{
			s = driver.findElementById(xpathVal).getText();
			report("pass","The Text: "+s+" should be returned successfully from the Id "+xpathVal,"The Text: "+s+" is returned successfully from the Id "+xpathVal,true);
		}catch(NoSuchElementException n){
			report("fail","The Text: "+s+" should be returned successfully from the Id "+xpathVal,"The Element with field "+xpathVal+" is not found in the webpage",true);
		}catch(ElementNotVisibleException ev){
			report("fail","The Text: "+s+" should be returned successfully from the Id "+xpathVal,"The Element with field "+xpathVal+" is not visible in the webpage",true);
		}catch(TimeoutException t){
			report("fail","The Text: "+s+" should be returned successfully from the Id "+xpathVal,"The Element with field "+xpathVal+" is not found, since execution is failed because the command did not complete in enough time",true);
		}catch(WebDriverException e){
			report("fail","The Text: "+s+" should be returned successfully from the Id "+xpathVal,"The Browser got closed, due to unknown error",true);
		}catch(Exception e){
			report("fail","The Text: "+s+" should be returned successfully from the Id "+xpathVal,"The Element with field "+xpathVal+" is not found, due to unknown error",true);
		}
		return s;
	}

	
	public void selectVisibileTextById(String id, String value){	
		try{
			WebElement element = driver.findElementById(id);
			Select s = new Select(element);
			s.selectByVisibleText(value);
			report("pass","The dropdown with Id "+id+" should be selected with value "+value,"The dropdown with Id "+id+" is selected with value "+value,true);
		}catch(NoSuchElementException n){
			report("fail","The dropdown with Id "+id+" should be selected with value "+value,"The Text field "+id+" is not found in the webpage",true);
		}catch(ElementNotVisibleException ev){
			report("fail","The dropdown with Id "+id+" should be selected with value "+value,"The Text field "+id+" is not visible in the webpage",true);
		}catch(ElementNotSelectableException es){
			report("fail","The dropdown with Id "+id+" should be selected with value "+value,"The Text field "+id+" is disabled, and so is not able to select",true);
		}catch(TimeoutException t){
			report("fail","The dropdown with Id "+id+" should be selected with value "+value,"The Text field "+id+" is not entered, since execution is failed because the command did not complete in enough time",true);
		}catch(WebDriverException e){
			report("fail","The dropdown with Id "+id+" should be selected with value "+value,"The Browser got closed, due to unknown error",true);
		}catch(Exception e){
			report("fail","The dropdown with Id "+id+" should be selected with value "+value,"The Text field "+id+" is not entered with the text "+value+", due to unknown error",true);
		}
	}

	
	public void selectIndexById(String id, int value){
		try{
			WebElement element = driver.findElementById(id);
			Select s1 = new Select(element);
			s1.selectByIndex(value);
			report("pass","The dropdown with Id "+id+" should be selected with index "+value,"The dropdown with Id "+id+" is selected with index "+value,true);
		}catch(NoSuchElementException n){
			report("fail","The dropdown with Id "+id+" should be selected with index "+value,"The Text field "+id+" is not found in the webpage",true);
		}catch(ElementNotVisibleException ev){
			report("fail","The dropdown with Id "+id+" should be selected with index "+value,"The Text field "+id+" is not visible in the webpage",true);
		}catch(ElementNotSelectableException es){
			report("fail","The dropdown with Id "+id+" should be selected with index "+value,"The Text field "+id+" is disabled, and so is not able to select",true);
		}catch(TimeoutException t){
			report("fail","The dropdown with Id "+id+" should be selected with index "+value,"The Text field "+id+" is not entered, since execution is failed because the command did not complete in enough time",true);
		}catch(WebDriverException e){
			report("fail","The dropdown with Id "+id+" should be selected with index "+value,"The Browser got closed, due to unknown error",true);
		}catch(Exception e){
			report("fail","The dropdown with Id "+id+" should be selected with index "+value,"The Text field "+id+" is not entered with the index "+value+", due to unknown error",true);
		}
	}

	public void selectVisibileTextByName(String name, String value){	
		try{
			WebElement element = driver.findElementByName(name);
			Select s = new Select(element);
			s.selectByVisibleText(value);
			report("pass","The dropdown with Id "+name+" should be selected with value "+value,"The dropdown with Id "+name+" is selected with value "+value,true);
		}catch(NoSuchElementException n){
			report("fail","The dropdown with Id "+name+" should be selected with value "+value,"The Text field "+name+" is not found in the webpage",true);
		}catch(ElementNotVisibleException ev){
			report("fail","The dropdown with Id "+name+" should be selected with value "+value,"The Text field "+name+" is not visible in the webpage",true);
		}catch(ElementNotSelectableException es){
			report("fail","The dropdown with Id "+name+" should be selected with value "+value,"The Text field "+name+" is disabled, and so is not able to select",true);
		}catch(TimeoutException t){
			report("fail","The dropdown with Id "+name+" should be selected with value "+value,"The Text field "+name+" is not entered, since execution is failed because the command did not complete in enough time",true);
		}catch(WebDriverException e){
			report("fail","The dropdown with Id "+name+" should be selected with value "+value,"The Browser got closed, due to unknown error",true);
		}catch(Exception e){
			report("fail","The dropdown with Id "+name+" should be selected with value "+value,"The Text field "+name+" is not entered with the text "+value+", due to unknown error",true);
		}
	}
	
	public void switchToParentWindow() {
		try{
			Set<String> allWindows = driver.getWindowHandles();	
			for (String s : allWindows) {			//Navigating to the Parent Window
				driver.switchTo().window(s);
				break;
			}
			report("pass","Window is switched to Parent Window Successfully","Window is switched to Parent Window Successfully",true);
			System.out.println("Window is switched to Parent Window Successfully");
		}catch (NoSuchWindowException e) {
			//e.printStackTrace();
			report("fail","Window is switched to Parent Window Successfully","Cannot be switched to Parent window as no Parent window exist",true);
		}catch(TimeoutException t){
			report("fail","Window is switched to Parent Window Successfully","Cannot be switched to Parent window, since execution is failed because the command did not complete in enough time",true);
		}catch(WebDriverException e){
			report("fail","Window is switched to Parent Window Successfully","The Browser got closed, due to unknown error",true);
		}catch(Exception e){
			report("fail","Window is switched to Parent Window Successfully","Cannot be switched to Parent window, due to unknown error",true);
		}
	}

	public void switchToLastWindow() {
		try{
			Set<String> allWindows = driver.getWindowHandles();	
			for (String s : allWindows) {			//Navigating to the last Window
				driver.switchTo().window(s);
			}
			report("pass","Window should be switched to Last Window Successfully","Window is switched to Last Window Successfully",true);
		}catch (NoSuchWindowException e) {
			//e.printStackTrace();
			report("pass","Window should be switched to Last Window Successfully","Cannot be switched to Last window as no Last window exist",true);
		}catch(TimeoutException t){
			report("pass","Window should be switched to Last Window Successfully","Cannot be switched to Last window, since execution is failed because the command did not complete in enough time",true);
		}catch(WebDriverException e){
			report("pass","Window should be switched to Last Window Successfully","The Browser got closed, due to unknown error",true);
		}catch(Exception e){
			report("pass","Window should be switched to Last Window Successfully","Cannot be switched to Last window, due to unknown error",true);
		}
	}

	
	public void acceptAlert() {
		try{
			Alert al = driver.switchTo().alert();
			al.accept();
			report("pass","The alert should be accepted successfully","The alert is accepted successfully",true);
		}catch (NoAlertPresentException e) {
			report("fail","The alert should be accepted successfully","The Alert cannot be accepted as no alert present at this insatance",true);
		}catch(TimeoutException t){
			report("fail","The alert should be accepted successfully","The Alert cannot be accepted, since execution is failed because the command did not complete in enough time",true);
		}catch(WebDriverException e){
			report("fail","The alert should be accepted successfully","The Browser got closed, due to unknown error",true);
		}catch(Exception e){
			report("fail","The alert should be accepted successfully","The Alert cannot be accepted, due to unknown error",true);
		}
	}

	
	public void dismissAlert() {
		try{
			Alert al = driver.switchTo().alert();
			al.dismiss();
			report("pass","The alert should be dismissed successfully","The alert is dismissed successfully",true);
		}catch (NoAlertPresentException e) {
			report("fail","The alert should be dismissed successfully","The Alert cannot be dismissed as no alert present at this insatance",true);
		}catch(TimeoutException t){
			report("fail","The alert should be dismissed successfully","The Alert cannot be dismissed, since execution is failed because the command did not complete in enough time",true);
		}catch(WebDriverException e){
			report("fail","The alert should be dismissed successfully","The Browser got closed, due to unknown error",true);
		}catch(Exception e){
			report("fail","The alert should be dismissed successfully","The Alert cannot be dismissed, due to unknown error",true);
		}
	}

	
	public String getAlertText() {
		String text = null;
		try{
			Alert al = driver.switchTo().alert();
			text = al.getText();
			report("pass","The text of the Alert should be captured ","The text of the Alert is captured successfully",true);
		}catch (NoAlertPresentException e) {
			report("fail","The text of the Alert should be captured ","The text of the Alert cannot be captured as no alert present at this insatance",true);
		}catch(TimeoutException t){
			report("fail","The text of the Alert should be captured ","The text of the Alert cannot be captured, since execution is failed because the command did not complete in enough time",true);
		}catch(WebDriverException e){
			report("fail","The text of the Alert should be captured ","The Browser got closed, due to unknown error",true);
		}catch(Exception e){
			report("fail","The text of the Alert should be captured ","The text of the Alert cannot be captured, due to unknown error",true);
		}
		return text;
	}

	
	public long takeSnap() {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;  
		//Math.random() * 900000000L --> It will give doubles values in between 0 to 900000000L. It can be 0.99343 o0r 8888443423.34322.
		//Math.floor --> will change the value to integer. It can changed 0.99343 to "0" 0r 8888443423.34322 to "8888443423"
		//We are adding 1 crore more, it can be small no also, 1, 55, 888, 22345.. so we need to add to make same crore series
		try{
			File temp = driver.getScreenshotAs(OutputType.FILE);
			File des = new File("./Screenshots/Images/snap"+number+".jpeg");
			FileUtils.copyFile(temp, des);
		} catch (WebDriverException e) {
			report("FAIL","The snapshot should not be taken","The browser has been closed",true);
		} catch (IOException e) {
			report("FAIL","The snapshot should not be taken","The snapshot could not be taken",true);
		}
		return number;
	}

	
	public void closeBrowser() {	
		try{
			driver.close();
			report("pass","Browser should be closed","Browser got closed",true);
		}catch(Exception e){
			report("pass","Browser should be closed","Browser is not closed, due to unknown error",true);
		}
	}

	
	public void closeAllBrowsers() {	
		try{
			driver.quit();
			report("pass","All opened Browser should be closed","All opened Browser got closed",false);
		}catch(Exception e){
			report("fail","All opened Browser should be closed","All opened Browser are not closed, due to unknown error",false);
		}
	}
	
	public void enterByKeys(String id, Keys k){
		try{
			driver.findElementById(id).sendKeys(k);
			report("pass","The selected entry "+id+"should be clicked by using Keys "+k,"The selected entry "+id+"is clicked by using Keys "+k,true);
		}catch(NoSuchElementException n){
			report("fail","The selected entry "+id+"should be clicked by using Keys "+k,"The Text field "+id+" is not found in the webpage",true);
		}catch(ElementNotVisibleException ev){
			report("fail","The selected entry "+id+"should be clicked by using Keys "+k,"The Text field "+id+" is not visible in the webpage",true);
		}catch(ElementNotSelectableException es){
			report("fail","The selected entry "+id+"should be clicked by using Keys "+k,"The Text field "+id+" is disabled, and so is not able to select",true);
		}catch(TimeoutException t){
			report("fail","The selected entry "+id+"should be clicked by using Keys "+k,"The Text field "+id+" is not entered, since execution is failed because the command did not complete in enough time",true);
		}catch(WebDriverException e){
			report("fail","The selected entry "+id+"should be clicked by using Keys "+k,"The Browser got closed, due to unknown error",true);
		}catch(Exception e){
			report("fail","The selected entry "+id+"should be clicked by using Keys "+k,"The Text field "+id+" is not entered with the Keys "+k+", due to unknown error",true);
		}
	}
}