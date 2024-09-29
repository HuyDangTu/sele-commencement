package UI;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class HandleDropdownList {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "D:\\Download\\chrome-win32\\chrome-win32\\chrome.exe");
		WebDriverManager.chromedriver().setup();
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
		driver.manage().window().maximize();
		
		//Single Select
		WebElement singleDdown = driver.findElement(By.id("select-demo"));
		Select singleSelect = new Select(singleDdown);
		System.out.println(singleSelect.getFirstSelectedOption().getText());
		
		
//		Thread.sleep(2000);
		
//		singleSelect.selectByVisibleText("Thursday");
//		Thread.sleep(2000);

//		singleSelect.selectByValue("Saturday");
//		Thread.sleep(2000);
		
		//Multiple Select
		WebElement ddown = driver.findElement(By.id("multi-select"));
		Select select = new Select(ddown);
	
		select.selectByValue("California"); 
		select.selectByIndex(5);
		Thread.sleep(2000);
		List<WebElement> allItems = select.getAllSelectedOptions();	
		System.out.println(allItems.size());
		
		select.deselectAll();
		Thread.sleep(2000);
		select.selectByValue("California");
		
		select.selectByIndex(5);
		Thread.sleep(2000);
		select.deselectByIndex(5);
		List<WebElement> allItems1 = select.getAllSelectedOptions();	
		System.out.println(allItems1.size());
		
	}

}
