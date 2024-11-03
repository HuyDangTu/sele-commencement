package MouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver =  new EdgeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(frame);
		
		WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement field2 = driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement doubleClickBtn = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));		 
		
		field1.clear();
		field1.sendKeys("Handle Double Click");
		
		Actions act = new Actions(driver);
		act.doubleClick(doubleClickBtn).perform();
		String text2 = field2.getAttribute("value");
		System.out.println(text2);
		if(text2.equals(field1.getAttribute("value"))) {
			System.out.println("Text copied");
		}else {
			System.out.println("Text was not copied");
		}
	}

}
