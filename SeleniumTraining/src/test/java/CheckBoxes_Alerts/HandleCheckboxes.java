package CheckBoxes_Alerts;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class HandleCheckboxes {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver =  new EdgeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//find the check boxes
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		
		//loop through the list of check boxes and click all

//		for (int i=0;i<checkboxes.size();i++) {
//			checkboxes.get(i).click();
//		}
//		
//		for(WebElement checkbox:checkboxes) {
//			checkbox.click();
//		}
		
		//select last three check boxes
//		for (int i=checkboxes.size()-3;i<checkboxes.size();i++) {
//			checkboxes.get(i).click();
//		}
		for (int i=0;i<checkboxes.size()-4;i++) {
			checkboxes.get(i).click();
		}
		
		Thread.sleep(5000);
		//un-select if check boxes are checked
		
		for(WebElement checkbox:checkboxes) {
			if(checkbox.isSelected()) {
				checkbox.click();
			}
		}
	}
}
