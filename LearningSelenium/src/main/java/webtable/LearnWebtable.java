package webtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWebtable {
	public static void main(String args[]) throws InterruptedException{
		int i=0,j=1;
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://erail.in");
		driver.findElementById("buttonFromTo").click();
		Thread.sleep(5000);
		WebElement table = driver.findElementByTagName("table");
		//System.out.println(table.0);/*
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println("No of Rows="+rows.size());
		
		for(j=1;j<rows.size();j++){
			try{
				if(table.findElement(By.xpath("//*[@id='divTrainsList']/table[1]/tbody/tr["+j+"]/td[11]")).getText().equals("Y")){
				//if(driver.findElementByXPath("//*[@id='divTrainsList']/table[1]/tbody/tr["+j+"]/td[11]").getText().equals("Y")) 	  both are correct
					i++;
				}
			}catch(NoSuchElementException e){
				System.out.println("No of trains also go on Wednesday, which are scheduled for today are "+i);
				break;
			}
		}
	}
}
