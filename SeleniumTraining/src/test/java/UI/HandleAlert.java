package UI;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class HandleAlert {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "D:\\Download\\chrome-win32\\chrome-win32\\chrome.exe");
		WebDriverManager.chromedriver().setup();
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
//		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
//		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_confirm");
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		
		driver.manage().window().maximize();
		
		WebElement iframe = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(iframe);
		
//		WebElement iframe2 = driver.findElement(By.tagName("iframe"));
//		driver.switchTo().frame(iframe2);
//		System.out.println(driver.findElement(By.xpath("//*[@id=\"subtopnav\"]/a[1]")));
		driver.findElement(By.xpath("/html/body/button")).click();
		
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		
		Thread.sleep(1000);
		
		//driver.switchTo().alert().accept();
		//driver.switchTo().alert().dismiss();
		driver.switchTo().alert().sendKeys("Huy Tu");
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		driver.switchTo().parentFrame();
		System.out.println(driver.getTitle());
		
		
	}

}
