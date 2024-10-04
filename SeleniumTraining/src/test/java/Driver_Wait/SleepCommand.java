package Driver_Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SleepCommand {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver =  new EdgeDriver();
		
		//Open the URL on the web browser
		driver.get("https://opensource-demo.orangehrmlive.com/auth/login");
		
		driver.manage().window().maximize();
		
		//Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("abcd");
		
		//implicit wait
		//explicit wait
	}

}
