package UI;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class HandleCheckbox {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "D:\\Download\\chrome-win32\\chrome-win32\\chrome.exe");
		WebDriverManager.chromedriver().setup();
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");
		driver.manage().window().maximize();
		
		List<WebElement> genderRadioBtn = driver.findElements(By.xpath("//div[@id='radio_1665627729_field']/ul/li/input"));
		List<WebElement> genderRadioName = driver.findElements(By.xpath("//div[@id='radio_1665627729_field']/ul/li"));
		System.out.println(genderRadioBtn.size());
		
		for(int i = 0;i<genderRadioBtn.size();i++) {
			System.out.println(genderRadioName.get(i).getText());
			genderRadioBtn.get(i).click();
			Thread.sleep(1000);
		}

		
	}

}
