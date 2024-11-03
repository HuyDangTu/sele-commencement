package MouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandleDrandAndDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver =  new EdgeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
	
		WebElement box1 = driver.findElement(By.xpath("//div[@id='box1']"));
		WebElement italyBox = driver.findElement(By.xpath("//div[@id='box106']"));
		
		WebElement box7 = driver.findElement(By.xpath("//div[@id='box7']"));
		WebElement swedenBox = driver.findElement(By.xpath("//div[@id='box102']"));
		
		WebElement box5 = driver.findElement(By.xpath("//div[@id='box5']"));
		WebElement usaBox = driver.findElement(By.xpath("//div[@id='box103']"));
		
		WebElement capitalBox = driver.findElement(By.xpath("//div[@id='capitals']"));	
		

		
		Actions act = new Actions(driver);
		act.dragAndDrop(box1,italyBox).perform();
		act.dragAndDrop(box7,swedenBox).perform();
		act.dragAndDrop(box5,usaBox).perform();
		
		Thread.sleep(2000);
		//Drag elements back to the Capital box
		act.dragAndDrop(box1,capitalBox).perform();
		act.dragAndDrop(box7,capitalBox).perform();
		act.dragAndDrop(box5,capitalBox).perform();
			 

	}

}
