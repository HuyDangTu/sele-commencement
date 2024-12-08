package Screenshots;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Take_screenshot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EdgeOptions options=new EdgeOptions();
		options.addArguments("--headless=new"); // setting for headless mode of execution
		
		EdgeDriver driver = new EdgeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);
		System.out.println();
		File targetfile = new File(System.getProperty("user.dir")+"/Screenshots/FullScreen.png");
		sourcefile.renameTo(targetfile);
		
		
		WebElement fetureList = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		
		File sourcefile1 = fetureList.getScreenshotAs(OutputType.FILE);
		File targetfile1 = new File(System.getProperty("user.dir")+"/Screenshots/featureList.png");
		sourcefile1.renameTo(targetfile1);
		
	}

}
