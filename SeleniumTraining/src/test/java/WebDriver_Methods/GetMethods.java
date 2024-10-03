package WebDriver_Methods;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;



public class GetMethods {

	public static void main(String[] args) throws InterruptedException {
		
		
	// GET METHODS
	
		WebDriver driver =  new EdgeDriver();
		
		//Open the URL on the web browser
		driver.get("https://opensource-demo.orangehrmlive.com/auth/login");
		Thread.sleep(2000);
		
		//Get title of the web page
		System.out.println(driver.getTitle());
		
		//Get the current URL
		System.out.println(driver.getCurrentUrl());
	
		//Get the page source(BTML, script,...) of the current web page
		//System.out.println(driver.getPageSource());
		
		
		//Get the Window Handler return string
		String windowId =  driver.getWindowHandle();
		System.out.println("windown Id: " + windowId);
		
	
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		//Get the Window Handler return a Set of string
		Set<String> windowIds = driver.getWindowHandles();
		
		System.out.println(windowIds);
		
		//Close command close the single browser
		//Quit command close all the browser windows at that time
		//To close specific browser, must provide window id
		//Switch between browser windows, must provide window id
		Thread.sleep(1000);
		driver.quit();

	}
}