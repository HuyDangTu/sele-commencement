package UI;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class HandleSilderAndResizeElement {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "D:\\Download\\chrome-win32\\chrome-win32\\chrome.exe");
		WebDriverManager.chromedriver().setup();
				
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='demo-frame']")));
		WebElement resizable = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
		
		Actions action = new Actions(driver);
		action.dragAndDropBy(resizable,200,100).perform();
		
//		driver.get("https://jqueryui.com/slider/#colorpicker");
//		driver.manage().window().maximize();
//		driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='demo-frame']")));
//		
//		WebElement redSlider = driver.findElement(By.xpath("//*[@id=\"red\"]/span"));
//		WebElement greenSlider = driver.findElement(By.xpath("//*[@id=\"green\"]/span"));
//		WebElement blueSlider = driver.findElement(By.xpath("//*[@id=\"blue\"]/span"));
//		
//		System.out.println(redSlider.getLocation());
//		System.out.println(greenSlider.getLocation());
//		System.out.println(blueSlider.getLocation());
//
//		Actions action = new Actions(driver);
//		
//		action.dragAndDropBy(redSlider,-100,71).perform();
//		action.dragAndDropBy(greenSlider,100,115).perform();
//		action.dragAndDropBy(blueSlider,150,159).perform();
		
	}

}
