package KeyBoardActions_Slider_NewTabWindow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandleSlider {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver =  new EdgeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
	
		
		//handle min slider
		
		WebElement minSlider = driver.findElement(By.xpath("//div[@id='slider-range']//span[1]"));
		
		Point locationOfMinSLider = minSlider.getLocation();
		
		System.out.println(locationOfMinSLider);
		
		Actions act = new Actions(driver);
		
		
		act.dragAndDropBy(minSlider, 100,289 ).perform();
		
		
		//handle max slider
		
		WebElement maxSlider = driver.findElement(By.xpath("//div[@id='slider-range']//span[2]"));
		
		Point locationOfMaxSLider = maxSlider.getLocation();
		
		System.out.println(locationOfMaxSLider);
		
		
		act.dragAndDropBy(maxSlider, -100,289 ).perform();
		
		
		
	}

}
