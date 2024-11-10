package KeyBoardActions_Slider_NewTabWindow;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandleCtrlClickandSwitchBtwTabs {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	
		WebDriver driver =  new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.opencart.com/");
		driver.manage().window().maximize();
		
		
		WebElement marketplaceLink = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//a[normalize-space()='Marketplace'] "));
		
		Actions act = new Actions(driver);
		
		//press command and click
		
		act.keyDown(Keys.COMMAND).click(marketplaceLink).keyUp(Keys.COMMAND).perform();
		
		List<String> listOfWindow = new ArrayList(driver.getWindowHandles());
		
		driver.switchTo().window(listOfWindow.get(1));
		
		//open url in a new tab or new window
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://demo.nopcommerce.com/");
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
	}

}
