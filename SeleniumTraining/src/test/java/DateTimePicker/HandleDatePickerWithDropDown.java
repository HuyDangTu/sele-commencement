package DateTimePicker;

import java.time.Duration;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDatePickerWithDropDown {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	
		WebDriver driver =  new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		//WebElement demoFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		
		//driver.switchTo().frame(demoFrame);
		driver.findElement(By.xpath("//input[@id='txtDate']")).click();
		
		String month = "Dec";
		String expectedYear = "1999";
		String day = "12";
		
		HashMap<String, Month> Months = new HashMap<String, Month>();

	    // Add keys and values (Country, City)
		Months.put("Jan", Month.JANUARY);
		Months.put("Feb", Month.FEBRUARY);
		Months.put("Mar", Month.MARCH);
		Months.put("Apr", Month.APRIL);
		Months.put("May", Month.MAY);
		Months.put("Jun", Month.JUNE);
		Months.put("Jul", Month.JULY);
	    Months.put("Aug", Month.AUGUST);
	    Months.put("Sep", Month.SEPTEMBER);
	    Months.put("Oct", Month.OCTOBER);
	    Months.put("Nov", Month.NOVEMBER);
	    Months.put("Dec", Month.DECEMBER);
		
	    System.out.println(Months); 
		
		//Select Years
		while(true) {
			WebElement yearSelect = driver.findElement(By.xpath("//select[@aria-label='Select year']"));
			Select yeaDrd = new Select(yearSelect);
			List<WebElement> years = yeaDrd.getOptions();
			List<String> allDisplayedYears = new ArrayList<>();
			
			for(WebElement yr:years) {
				allDisplayedYears.add(yr.getText());
			}
			
			if(allDisplayedYears.contains(expectedYear)){
				yeaDrd.selectByValue(expectedYear);
				break;
			}else if(Integer.parseInt(expectedYear) > Integer.parseInt(allDisplayedYears.getLast()))
				{
					yeaDrd.selectByValue(allDisplayedYears.getLast());					
				}else{
					yeaDrd.selectByValue(allDisplayedYears.getFirst());	
				}
		}
		
		while(true) {
	
			String selectedMonth = driver.findElement(By.xpath("//select[@aria-label='Select month']/option[@selected='selected']")).getText();
			System.out.println(selectedMonth);
	
			if(Months.get(selectedMonth).compareTo(Months.get(month)) < 0 ){
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}else if(Months.get(selectedMonth).compareTo(Months.get(month)) > 0){
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			}else {
				break;
			}
			
		}
		
		List<WebElement> listOfday = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//a"));
		
		for(WebElement day1:listOfday) {
			if(day1.getText().equals(day)) {
				day1.click();
				break;
			}
		}
		
	}
}
