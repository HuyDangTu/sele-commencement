package MouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//action class object
		//mouse hover -> moveToElement, 
		//rightlick -> context click, 
		//double click, 
		//drand and drop
		//ore defined provided in Sele
		//build is to craete action
		//perform is to complete an action
		//should use the build to create an actions for reusse or use later

		WebDriver driver =  new EdgeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		WebElement desktop = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		
		WebElement MacOption = driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		
		Actions act = new Actions(driver);
		
		Action clickOnMacOption = act.moveToElement(desktop).moveToElement(MacOption).click().build();
		
		clickOnMacOption.perform();
	}

}
