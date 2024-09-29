package UI;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class GetAllLinks {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "D:\\Download\\chrome-win32\\chrome-win32\\chrome.exe");
		WebDriverManager.chromedriver().setup();
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.sugarcrm.com/au/request-demo/");
		driver.manage().window().maximize();
		
//		Thread.sleep(3000);
//		if(driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).isDisplayed()) {
//			driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
//		}
		
		List<WebElement> alltags = driver.findElements(By.tagName("a"));
		System.out.println("Total tags are" + alltags.size());
		
		for(int i=0;i<alltags.size();i++) {
			System.out.println("Links on page are"+alltags.get(i).getDomAttribute("href"));
			System.out.println("Links on page are"+alltags.get(i).getText());
		}
	}

}
