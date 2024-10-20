package DateTimePicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class DatetimeDemo {

	public static void selectFutureDay(WebDriver driver, String month, String year, String day) {
			//open the datetime picker by click the dropdown	
			driver.findElement(By.xpath("//input[@id='datepicker']")).click();
			
			//loop while true to select month and year
			while(true) {
			
				String CurrentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
				String CurrentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
				
				if(CurrentMonth.equals(month) && CurrentYear.equals(year)) {
					break;
				}
				//Past Date
				//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
				//Future Date
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
				
			}
			
			//find current year, month in the picker
			//if current year and month match the expectations, break the loop and select day
			//if they do not match, select month and year
			//select all the date in the table 
			List<WebElement> listOfday = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody//td/a"));
			
			for(WebElement day1:listOfday) {
				if(day1.getText().equals(day)) {
					day1.click();
					break;
				}
			}
	}
	
	public static void selectPastDay(WebDriver driver, String month, String year, String day) {
		//open the datetime picker by click the dropdown	
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		//loop while true to select month and year
		while(true) {
		
			String CurrentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String CurrentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(CurrentMonth.equals(month) && CurrentYear.equals(year)) {
				break;
			}
			//Past Date
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			
		}
		
		//find current year, month in the picker
		//if current year and month match the expectations, break the loop and select day
		//if they do not match, select month and year
		//select all the date in the table 
		List<WebElement> listOfday = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody//td/a"));
		
		for(WebElement day1:listOfday) {
			if(day1.getText().equals(day)) {
				day1.click();
				break;
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	
		WebDriver driver =  new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();

		WebElement demoFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		
		driver.switchTo().frame(demoFrame);
		//send keys to enter date 
		//driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("10/17/2025");
		
		//define expected year, month, day variables
		String month = "May";
		String year = "2025";
		String day = "12";
		
		selectFutureDay(driver,month,year,day);
		
		Thread.sleep(2000);
		
		month = "October";
		year = "2020";
		day = "31";
		
		selectPastDay(driver,month,year,day);
		
	}

}
