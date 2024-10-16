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
		
		//read data from specific row
		System.out.println("row 3 col 3:"+driver.findElement(By.xpath("//table[@name='BookTable']//tr[3]//td[3]")).getText());
		
		System.out.println("Table");
		
		//print the table header
		for(int j=1;j<=4;j++) {
			System.out.print(driver.findElement(By.xpath("//table[@name='BookTable']//tr[1]//th["+j+"]")).getText()+"\t");
		}	
		System.out.println("");
		//print all table data
		for(int i=2;i<=7;i++) {
			for(int j=1;j<=4;j++) {
				System.out.print(driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td["+j+"]")).getText()+"\t");
			}	
			System.out.println("");
		}
		
		System.out.println("Books of Mukesh");
		
		//print books of Mukesh
		for(int i=2;i<=7;i++) {
			
			String author = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[2]")).getText();
			
			if(author.equals("Mukesh")) {
			
				System.out.println(author +"\t"+ driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[1]")).getText());

			}
		}
		//find total price of the books
	}

}
