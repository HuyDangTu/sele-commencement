package Dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver =  new EdgeDriver();
		driver.get("https://testautomationpractice.blogspot.com");
		driver.manage().window().maximize();
		
		//Select/OPtion tags Drop Down 
		WebElement drpdown = driver.findElement(By.xpath("//select[@id='country']"));
		Select drpdCountry = new Select(drpdown);
		
		//select option by value, index, visible text
		drpdCountry.selectByVisibleText("France");
		
		Thread.sleep(1000);
		//Value is attribute value of option tag
		drpdCountry.selectByValue("uk");
		
		Thread.sleep(1000);
		//Index start from 0
		drpdCountry.selectByIndex(8);
		
		//How many total option in the drop down?
		//Capture all option of the dropdown
		//getOptions return all options of dropwdown
		List<WebElement> LstofOption = drpdCountry.getOptions();
		System.out.println("number of option" + LstofOption.size());
		
		//loop through the list of options 
//		for(int i=0;i<LstofOption.size();i++)
//		{
//			System.out.println(LstofOption.get(i).getText());
//		}
		//Advanced loop
		for(WebElement op:LstofOption) {
			System.out.println(op.getText());
		}
		
	}

}
