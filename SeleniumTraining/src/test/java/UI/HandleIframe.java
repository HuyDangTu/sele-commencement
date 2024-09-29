package UI;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class HandleIframe {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "D:\\Download\\chrome-win32\\chrome-win32\\chrome.exe");
		WebDriverManager.chromedriver().setup();
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");
		driver.manage().window().maximize();
		
		WebElement iframe = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(iframe);
		
		WebElement iframe2 = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe2);
		System.out.println(driver.findElement(By.xpath("//*[@id=\"subtopnav\"]/a[1]")));
		driver.findElement(By.xpath("//*[@id=\"subtopnav\"]/a[1]")).click();
		
		driver.switchTo().parentFrame();
		System.out.println(driver.findElement(By.xpath("//html/body/h1")).getText());
		
		
	}

}
