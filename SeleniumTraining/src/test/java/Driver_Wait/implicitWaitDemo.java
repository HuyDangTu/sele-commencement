package Driver_Wait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class implicitWaitDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver =  new EdgeDriver();
		
		//implicit wait method
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//The time out duration is applied for  all statement
		//Implicit wait  should be declared after the creation of driver
		//One time declare and applied for all the code
		//When the synchronization issue occurs the implicit wait shall take care
		//Have to specify the time in the implicit wait command, the specified time is hard code
		//Sometime it takes more time than defined time to load the elements, it lead to the failure
		//Until the driver is alive, the implicit wait is applicable to all statements
		//Hard coding the time, the exception shall be thrown if time out 
		//Every statement is waiting for the specified time
		//If the maximum time is not sufficient, the exception shall be thrown
		//Easy to use
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/auth/login");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("abcd");
		
		driver.close();
		
		
		
	}

}
