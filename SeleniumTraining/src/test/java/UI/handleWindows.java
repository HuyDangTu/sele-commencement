package UI;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;


public class handleWindows {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "D:\\Download\\chrome-win32\\chrome-win32\\chrome.exe");
		WebDriverManager.chromedriver().setup();
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/ap/?ir=1");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"1707962206997_xa6\"]/div[1]/article/div[2]/div/pbc-button[1]/a")).click();
		
		Set<String> windowHandlers = driver.getWindowHandles();
		System.out.println(windowHandlers);
		
		Iterator<String> iterator = windowHandlers.iterator();
		
		String parentWindow = iterator.next();
		System.out.println(parentWindow);
		
		String childWindow = iterator.next();
		System.out.println(childWindow);
		
		driver.switchTo().window(childWindow);
		driver.findElement(By.xpath("//*[@name='UserFirstName']")).sendKeys("First name");  //*[@id="UserFirstName-PK1N"]
		driver.findElement(By.xpath("//*[@name='UserLastName']")).sendKeys("Last name");
		
		Thread.sleep(2000);
		driver.switchTo().window(parentWindow);
		
		Thread.sleep(2000);
		driver.close();
	}

}
