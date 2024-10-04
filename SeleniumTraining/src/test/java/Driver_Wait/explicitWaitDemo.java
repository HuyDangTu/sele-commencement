package Driver_Wait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class explicitWaitDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//indicate time to wait for the element
		//For explicit wait we have to provide condition and time to wait
	
		// To use explicit wait
		//first declare, then use the explicit wait instance
		//Provide certain condition
		
		WebDriver driver =  new EdgeDriver();
		
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		driver.get("https://opensource-demo.orangehrmlive.com/auth/login");
		
		driver.manage().window().maximize();
		
		//when the element is loaded on we page, it returns web element
		//if the condition is true, it return the web element
		
		WebElement textBox = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/*[@id=\\\"app\\\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")));
		textBox.sendKeys("abcd");
		
		
		WebElement password = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/*[@id=\\\"app\\\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")));
		textBox.sendKeys("abcd");
		
		//check if the element is on the page and clickable
		WebElement button = mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")));
		button.click();
		
		driver.close();
		
		//using the explicit wait is based on the condition
		//it doesn't base on the specified time
		// no need to applied for all statements 
		
		
	}

}
