package Dynamic_Table;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleDynamicTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver =  new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.opencart.com/admin/index.php?route=common");
		driver.manage().window().maximize();
		
		
		driver.navigate().refresh();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		//Number of row (tr tag)
		WebElement usernameTxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-username']")));
				//driver.findElement(By.xpath("//input[@id='input-username']"));
		WebElement passwordTxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-password']")));
				//driver.findElement(By.xpath("//input[@id='input-password']"));
		WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Login']")));
				//driver.findElement(By.xpath("//button[normalize-space()='Login']"));
	
		usernameTxt.clear();
		passwordTxt.clear();
		usernameTxt.sendKeys("demo");
		passwordTxt.sendKeys("demo");
		loginBtn.click();

		WebElement CustomerDrp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")));
		CustomerDrp.click();
		
		WebElement customerOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")));
		customerOption.click();
		
		
		String pageNumberTxt =  driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
		
		String pageNumber = pageNumberTxt.substring(25,28);
		System.out.println(pageNumber);
		
		for(int i =1;i<=5;i++){
			
			System.out.println("Page " + i);
			
			if(i > 1) {
				WebElement nextpage = driver.findElement(By.xpath("//ul[@class='pagination']//*[text()="+i+"]"));
				//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='pagination']//*[text()="+i+"]"))).click();
				
				//An element which is click-able must be located in the view of the web page.
				//Due to the pagination navigation is not in the viewport.
				//Use the Java Script executor to scroll down to have the pagination be in the viewport
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextpage);
				Thread.sleep(3000);
				System.out.println(nextpage.getText());
				nextpage.click();
				Thread.sleep(3000);
			}
			
			List<WebElement> listOfTableRows = driver.findElements(By.xpath("//tbody/tr"));
			
			//loop through the table rows
			for(int r=1;r<=listOfTableRows.size();r++) {
				//loop through fixed column numbers
				for(int c=2;c<=5;c++) {
					System.out.print(driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+r+"]/td["+c+"]")).getText()+"\t");
				}
				System.out.println("");
			}
			System.out.println("---------------------------------------");
			
		}
		
	}

}
