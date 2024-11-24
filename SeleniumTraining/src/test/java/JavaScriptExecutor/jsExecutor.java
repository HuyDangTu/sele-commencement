package JavaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class jsExecutor {

	public static void main(String[] args) {
		
		
		EdgeDriver driver = new EdgeDriver();
	
		// Register an driver variable by creating an instance of WebDriver (class)
		//WebDriver driver =  new EdgeDriver();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		JavascriptExecutor js = driver;
		//EdgeDriver is class extended from RemoteWebDriver
		//RemoteWebDriver is an implementation of JavaScriptExecutor Interface
		//There for we can directly assign driver to jsE
		//In the other  hand, RemoteWebDriver is also an implementation of WebDriver Interface 
		//So we have to convert driver to JSE
		//Can apply JSE for many element that have action Click and Enter
		// JSE is an alternative way to perform click, sendkey or other action on elements
		//JSE should be used when cannot perform actions on element.
		
		WebElement nameTextBox = driver.findElement(By.xpath("//input[@id='name']"));
		
		js.executeScript("arguments[0].setAttribute('value','john')",nameTextBox);
		
		WebElement maleRadio = driver.findElement(By.xpath("//input[@id='male']"));
		
		js.executeScript("arguments[0].click()",maleRadio);
		
		WebElement femaleRadio = driver.findElement(By.xpath("//input[@id='female']"));
		
		js.executeScript("arguments[0].click()",femaleRadio);
	}

}
