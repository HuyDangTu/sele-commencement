package CheckBoxes_Alerts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAuthenticationAleart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		WebDriver driver =  new EdgeDriver();
		
		//URL Without credentials
		//driver.get("https://the-internet.herokuapp.com/basic_auth");
		
		//To access a web page that required authentication
		//in the URL, we have provide the username:password as format below
		//URL Without credentials
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
	}

}


//Frame is on the current web and contains some other elements(from, div)
//Iframe is another web page which is embeded in the current web page
//driver focus on current page, so, driver can take any action on the iframe
//we have to switch to iframe, frame to perform actions


