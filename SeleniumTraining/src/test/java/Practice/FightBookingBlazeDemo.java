package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class FightBookingBlazeDemo {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver =  new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.blazedemo.com/");
		driver.manage().window().maximize();
		
		
		// Setup
		
		String departCity = "Portland";
		String destCity = "New York";
		int RowIndexOfLowestPrices = 0;
		double LowestPrice = 99999;
		
		
		//Test run
		
		//Select Depart and Dest cities
		Select DepartureCityDrd = new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));
		Select DestCityDrd = new Select(driver.findElement(By.xpath("//select[@name='toPort']")));
		WebElement FindFightBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		
		DepartureCityDrd.selectByValue(departCity);
		DestCityDrd.selectByValue(destCity);
		FindFightBtn.click();
	
		//Find the lowest price
		
		for(int r=1;r<6;r++) {
			String price = driver.findElement(By.xpath("//table/tbody/tr["+r+"]//td[6]")).getText();
			double convertedPrice = Double.parseDouble(price.substring(1));
			
			if(convertedPrice < LowestPrice) {
				LowestPrice = convertedPrice;
				RowIndexOfLowestPrices = r;
			}  
		}
		
		System.out.println("lowest price: " + LowestPrice);
		System.out.println("row index of the lowest price: " + RowIndexOfLowestPrices);
		
		driver.findElement(By.xpath("//table/tbody/tr["+RowIndexOfLowestPrices+"]//td[1]/input")).click();
		
		
		
		//input purchase information
		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Josh Smitch");
		
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("8flr 12 Emeral Baulevard");
		
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("New York");

		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("New York");

		driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("89000");

		Select cardTypeDrd = new Select(driver.findElement(By.xpath("//select[@id='cardType']")));
		cardTypeDrd.selectByIndex(1);

		driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("12");

		driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Josh Anderson Smith");

		driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys("2017");

		driver.findElement(By.xpath("//input[@id='rememberMe']")).click();

		//click Purchase Fight
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		
		//Verify if the sucess message is display 
		if(driver.findElement(By.xpath("//h1")).getText().equals("Thank you for your purchase today!")) {
			System.out.println("success: "+ driver.findElement(By.xpath("//h1")).getText());
		}
	}

}
