package KeyBoardActions_Slider_NewTabWindow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandleKeyBoardActions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver =  new EdgeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://text-compare.com");
		driver.manage().window().maximize();
	
	
		
		WebElement textArea1 = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
		
		textArea1.click();
		textArea1.sendKeys("Welcome");
		
		Actions act = new Actions(driver);
		
		act.keyDown(Keys.COMMAND).sendKeys("A").keyUp(Keys.COMMAND).perform();
		act.keyDown(Keys.COMMAND).sendKeys("C").keyUp(Keys.COMMAND).perform();
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		act.keyDown(Keys.COMMAND).sendKeys("V").keyUp(Keys.COMMAND).perform();
		
	}

}
