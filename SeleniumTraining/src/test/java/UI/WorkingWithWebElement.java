package UI;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class WorkingWithWebElement {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "D:\\Download\\chrome-win32\\chrome-win32\\chrome.exe");
		WebDriverManager.chromedriver().setup();
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.sugarcrm.com/au/request-demo/");
		driver.manage().window().maximize();
		
		//Display all form controls in the request demo form
		List<WebElement> formElements = driver.findElements(By.xpath("//div[@class='user-form-body']/div"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (WebElement element : formElements) {
		    js.executeScript("arguments[0].setAttribute('style', 'display: inherit')", element);
		}
		
		Thread.sleep(5000);
		//close the Manage cookies pop up 
		//driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
		
		//Print out the results
		
		//Get particular web element by name attribute
		
		driver.findElement(By.name("firstname")).sendKeys("TDH");
		//Enter text into input element
		driver.findElement(By.name("email")).sendKeys("TSH@gamil.com");
		//clear the input
		driver.findElement(By.name("email")).clear();
		
		System.out.println(driver.findElement(By.xpath("//*[@id='field0']/div/input")).getAttribute("class"));
		
		System.out.println(driver.findElement(By.xpath("//*[@id='field0']/div/input")).getCssValue("border"));
		
		System.out.println(driver.findElement(By.xpath("//*[@id='field0']/div/input")).getSize());
		
		System.out.println(driver.findElement(By.xpath("//*[@id='field0']/div/input")).getLocation());
		
		System.out.println(driver.findElement(By.xpath("//*[@id='field0']/div/input")).getTagName());
		
		System.out.println(driver.findElement(By.xpath("//*[@id='field7']/div/input")).isDisplayed());
		
		System.out.println(driver.findElement(By.xpath("//*[@id='field0']/div/input")).isEnabled());
		
		System.out.println(driver.findElement(By.xpath("//*[@id='field0']/div/input")).isSelected());	
		
	}

}
