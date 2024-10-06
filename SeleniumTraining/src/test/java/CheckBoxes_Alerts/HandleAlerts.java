package CheckBoxes_Alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HandleAlerts {
	public static void main(String[] args) throws InterruptedException {
		
		 // TODO Auto-generated method stub
		WebDriver driver =  new EdgeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		//Alert is not a web Element
		//JS Alert,JS Confirm, JS Prompt
	
		//Handle Normal Alert
		//switching to the current alert window and click Ok
		Thread.sleep(2000);
		System.out.println("Handle Normal Alert");
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		Alert myAlert = driver.switchTo().alert();
		System.out.println(myAlert.getText());
		myAlert.accept();
		
		//Handle confirmation alert, OK/Cancel button
		System.out.println("Handle confirmation alert");
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Alert myConfirmAlert = driver.switchTo().alert();
		System.out.println(myConfirmAlert.getText());
		myAlert.dismiss();
		
		
		//Handle Prompt Alert which have input box and Ok/Cancel button
		System.out.println("Handle Prompt Alert");
		System.out.println("Handle confirmation alert");
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Alert myPromtAlert = driver.switchTo().alert();
		System.out.println(myPromtAlert.getText());
		myAlert.sendKeys("Selenium");
		Thread.sleep(2000);
		myPromtAlert.accept();
		
		//handle Alert without switching to Alert
		//Can use explicit wait instead
	}
	
}
