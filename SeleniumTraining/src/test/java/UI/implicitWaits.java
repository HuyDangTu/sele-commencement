package UI;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class implicitWaits {

	public static String browser = "Edge";
	public static WebDriver driver;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
			
			if(browser.equals("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				 driver = new FirefoxDriver();
			}else if(browser.equals("Chrome")) {
				WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver();
			}else if (browser.equals("Edge")) {
				WebDriverManager.edgedriver().setup();
				 driver = new EdgeDriver();
			}

		driver.get("http://www.ebay.com");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//Duration timeOutDuration = Duration.ofSeconds(10);
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[6]/a"));
				
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
		 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(10))
			       .pollingEvery(Duration.ofSeconds(2))
			       .withMessage("Selenium training")
			       .ignoring(NoSuchElementException.class);

		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[6]/a/i"))).click();
		
	}

}
