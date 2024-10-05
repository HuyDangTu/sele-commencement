package Navigate_command;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class HandleBrowserWindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver =  new EdgeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/auth/login");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		Set<String> windowIDs = driver.getWindowHandles();
		
		//Set don't have get method
		//so we have to convert from Set to List to use Get using index 
		List<String> windowList = new ArrayList(windowIDs);
		
		
		//approach1
		//even we open e new browser window, the driver still focus on the parent (the initial opened browser)
		//have to switch from other window
		
		
		/*
		 * String parentID=windowList.get(0); String childID=windowList.get(1);
		 * System.out.println(driver.getTitle());
		 * 
		 * 
		 * driver.switchTo().window(childID); System.out.println(driver.getTitle());
		 * 
		 * driver.switchTo().window(parentID); System.out.println(driver.getTitle());
		 */
		 
		
		//If we have many of browser window
		//approach 2
		for(String winId:windowIDs) {
			
			String title = driver.switchTo().window(winId).getTitle();
			
			if(title.equals("OrangeHRM")) {
				System.out.println(driver.getCurrentUrl());
				//some validation here
			}
		}
		
	}

}
