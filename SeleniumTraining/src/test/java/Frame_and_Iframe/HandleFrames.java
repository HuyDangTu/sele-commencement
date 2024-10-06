package Frame_and_Iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HandleFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver =  new EdgeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		//Switch to frame 1
		WebElement frame1 = driver.findElement(By.xpath("//frameset[1]/frame[1]"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Hello frame 1");
		
		//Back to the default content
		driver.switchTo().defaultContent();
		
		//Switch to frame 2
		//Frame 2
		WebElement frame2 = driver.findElement(By.xpath("//frameset//frameset//frame[1]"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Hello frame 2");
		
		//Back to the default content
		driver.switchTo().defaultContent();
		
		//Frame 3
		WebElement frame3 = driver.findElement(By.xpath("//frameset//frameset//frame[2]"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Hello frame3");
				
		//switch to the iframe in frame 3
	
		driver.switchTo().frame(0);
//		driver.findElement(By.xpath("//div[@id='i8']//div[@class='AB7Lab Id5V1']")).click();
		
		//click the radio button using javascript executor instead of
		WebElement rdbutton = driver.findElement(By.xpath("//div[@id='i8']//div[@class='AB7Lab Id5V1']"));
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		js. executeScript ("arguments[0].click();",rdbutton);
		
		//Back to the default content
		driver.switchTo().defaultContent();
	}

}
