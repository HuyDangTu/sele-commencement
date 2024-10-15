package Dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AutoSuggestDropdown {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver =  new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.google.com.vn/?hl=vi");
		driver.manage().window().maximize();
		
		
		//login
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Sele");
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='UUbT9 EyBRub']//div[@id='Alh6id']//ul[@role='listbox']//li//div[@role='option']"));
		
		
		for(WebElement op:list) {
			
			System.out.println("option: " + op.getText());
			
			if(op.getText().equals("select sql")) {
				op.click();
				break;
			}
			
		}
		
	}
}
