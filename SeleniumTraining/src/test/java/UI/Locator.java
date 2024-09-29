package UI;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;


public class Locator {

		public static String browser = "Chrome";
		public static WebDriver driver;
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
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
			
			
			driver.get("https://www.saucedemo.com/");
						
			WebElement password = driver.findElement(By.id("password"));
			
			driver.findElement(RelativeLocator.with(By.tagName("input")).above(password)).sendKeys("huy@gmail.com");
			driver.findElement(RelativeLocator.with(By.tagName("input")).below(password)).click();
			
		}

}
