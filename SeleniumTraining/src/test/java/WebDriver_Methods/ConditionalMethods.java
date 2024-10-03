package WebDriver_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ConditionalMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver =  new EdgeDriver();
		
		//Open the URL on the web browser
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
		Thread.sleep(2000);
		
		//isDisplayed
		WebElement logo =  driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img"));
		System.out.println(logo.isDisplayed());
		
		//isEnabled allow to enter,input,check box,radio, button
		WebElement textBox =  driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]"));
		System.out.println(textBox.isEnabled());
		
		//isSelected
		
		WebElement maleCheckBox = driver.findElement(By.xpath("//*[@id='gender-male']"));
		WebElement femaleCheckBox = driver.findElement(By.xpath("//*[@id=\"gender-female\"]"));
		
		System.out.println("before selecting");
		
		System.out.println(maleCheckBox.isSelected()); //false
		System.out.println(femaleCheckBox.isSelected()); //false
		
		System.out.println("after selecting");
		
		//click check boxes
		maleCheckBox.click();
		
		System.out.println(maleCheckBox.isSelected()); //true
		System.out.println(femaleCheckBox.isSelected()); //false
		
		Thread.sleep(2000);
		//click male check box 
		femaleCheckBox.click();
		System.out.println(maleCheckBox.isSelected()); //false
		System.out.println(femaleCheckBox.isSelected()); //true
	
		Thread.sleep(1000);
		driver.close();
	}

}
