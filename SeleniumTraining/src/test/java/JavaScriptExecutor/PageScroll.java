package JavaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class PageScroll {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		EdgeDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		
		//scroll by pixel Y offset 1500px
		JavascriptExecutor js = driver;
		js.executeScript("window.scrollBy(0,1500)", "");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		//scroll until the element is inside the window
		Thread.sleep(1000);
		WebElement ele = driver.findElement(By.xpath("//strong[normalize-space()='Community poll']"));
		js.executeScript("arguments[0].scrollIntoView();", ele);
		System.out.println(js.executeScript("return window.pageYOffset;"));
	
		//scroll up to the top of the page
		//To get attribute => access the document.window.
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight);", "");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		//scroll down to the end of the page
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight);", "");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
	}	

}
