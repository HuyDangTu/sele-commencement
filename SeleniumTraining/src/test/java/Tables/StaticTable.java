package Tables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class StaticTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver =  new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//Number of row (tr tag)
		List<WebElement> list =  driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr"));
		System.out.println("Number of row" + list.size());
		
		//Number of col (th tag)
		List<WebElement> list2 =  driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr[1]/th"));
		System.out.println("Number of col" + list2.size());
		
		
		
	}

}
