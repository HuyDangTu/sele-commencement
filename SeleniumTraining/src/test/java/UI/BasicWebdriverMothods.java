package UI;
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


public class BasicWebdriverMothods {

		public static String browser = "Chrome";
		public static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
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
			driver.manage().window().maximize();
			
			String currentURL = driver.getCurrentUrl();
			System.out.println(currentURL);
			
			String title = driver.getTitle();
			System.out.println(title);
			
			String pagesource = driver.getPageSource();
			System.out.println(pagesource);
			
			//driver.navigate().to("https://www.google.com.vn/?hl=vi");
			
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
			
			List<WebElement> webElements = driver.findElements(By.xpath("//div[@class='inventory_item']/div"));
			System.out.println(webElements);
			


			String windowhandle = driver.getWindowHandle();
			System.out.println(windowhandle);
			
			driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//div[@class='slide-buttons']/a")).click();
			Set<String> windowhandles = driver.getWindowHandles();
			System.out.println(windowhandles);
			
			driver.quit();
			
		}

}
