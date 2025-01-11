package TestNG;

import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class OrangeHRMTest {
  
	WebDriver driver;
	
	@Test(priority=1)
	public void openApp() {
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	@Test(priority=2)
	public void testLogoPresence() {
		boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		if(status) {
			System.out.println("Logo is present"+status);
		}else {
			System.out.println("Logo is NOT present"+status);
		}
	}
	@Test(priority=3)
	public void testLogin() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();	
	}
	
	@Test(priority=3)
	public void closeApp() {
		driver.close();
	}
	
}
