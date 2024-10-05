package Navigate_command;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CloseSpecificBrowser {
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
	
		for(String winId:windowIDs) {
			
			String title = driver.switchTo().window(winId).getTitle();
			
			String url = driver.switchTo().window(winId).getCurrentUrl();	
			
			if(title.equals("OrangeHRM") || title.equals("Human Resources Management Software | OrangeHRM")) {
				System.out.println(driver.getCurrentUrl());
				driver.close();
				//some validation here
			}
		}
		
	}
}
