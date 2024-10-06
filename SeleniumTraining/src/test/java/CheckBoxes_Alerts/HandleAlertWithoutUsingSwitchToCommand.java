package CheckBoxes_Alerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlertWithoutUsingSwitchToCommand {

	public static void main(String[] args) throws InterruptedException {
		
		
		// TODO Auto-generated method stub
		WebDriver driver =  new EdgeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		//handle Alert without switching to Alert
		//Can use explicit wait instead
		
		Thread.sleep(2000);
		System.out.println("Handle Normal Alert");
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		
		Alert myAlert = myWait.until(ExpectedConditions.alertIsPresent());
		
		System.out.println(myAlert.getText());
		myAlert.accept();
		
	}
}
