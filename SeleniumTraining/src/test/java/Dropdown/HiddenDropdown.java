package Dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HiddenDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver =  new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		
		//login
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();	
		
		//Click PIM on the left pane
		driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']")).click();
		
		//Open the drop down by clicking arrow down icon of the drop down list
		driver.findElement(By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[6]/div/div[2]/div/div/div[2]")).click();
		
		//select all options and print in console 
		List<WebElement> options = driver.findElements(By.xpath("//div[@role='listbox']/div[@role='option']/span"));
		System.out.println(options.size());
		for(WebElement op:options) {
			System.out.println("option: " + op.getText());
		}
		
		//select single option
		driver.findElement(By.xpath("//div[@role='listbox']//div[2]")).click();
	}

}
