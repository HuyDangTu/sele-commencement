package Dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class BoostrapDropdown {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver =  new EdgeDriver();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		
		//Select single option 
		//open drop down option
		WebElement button = driver.findElement(By.xpath("//button[@class='multiselect dropdown-toggle btn btn-default']"));
		button.click();
		
		//select single option
		driver.findElement(By.xpath("//input[@value='Java']")).click();
		
		//select all options and 
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]/li/a/label"));
		
		for(WebElement op:options) {
			System.out.println(op.getText());
			if(op.getText().equals("Java") || op.getText().equals("Python") || op.getText().equals("MySQL")) {
				op.click();
			}
		}
	}
}
