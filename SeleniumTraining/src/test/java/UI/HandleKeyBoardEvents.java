package UI;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class HandleKeyBoardEvents {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "D:\\Download\\chrome-win32\\chrome-win32\\chrome.exe");
		WebDriverManager.chromedriver().setup();
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://extendsclass.com/text-compare.html");
		driver.manage().window().maximize();
		
		WebElement sourceTextArea = driver.findElement(By.xpath("//*[@id=\"dropZone\"]/div[2]//div[8]/pre/span"));
		
		Actions action = new Actions(driver);
		
		
		action.keyDown(sourceTextArea, Keys.CONTROL)
		.sendKeys("a")
		.sendKeys("c")
		.build()
		.perform();
		
		WebElement destinationTextArea = driver.findElement(By.xpath("//*[@id=\"dropZone2\"]//div[5]/div[4]/pre/span"));
		
		Thread.sleep(2000);
		action.keyDown(destinationTextArea, Keys.CONTROL)
		.sendKeys("a")
		.sendKeys("v")
		.build()
		.perform();
	
	}
}
