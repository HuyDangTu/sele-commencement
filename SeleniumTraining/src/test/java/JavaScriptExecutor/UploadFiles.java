package JavaScriptExecutor;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class UploadFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EdgeDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
		
		WebElement UploadBtn = driver.findElement(By.xpath("//input[@id='filesToUpload']"));
		
		
		String file1 = "/Users/huy/Downloads/SQLQuery_1.sql";	
		String file2 = "/Users/huy/Downloads/SQLQuery_3.sql";	
		//scroll by pixel Y offset 1500px
		
		UploadBtn.sendKeys(file1+"\n"+file2);
		
		List<WebElement> listOfFiles = driver.findElements(By.xpath("//ul[@id='fileList']/li"));
		
		if(listOfFiles.size() ==2) {
			System.out.println("2 files uploaded");
		}else {
			System.out.println("Missing file(s)");	
		}
		
		if(listOfFiles.get(0).getText().equals("SQLQuery_1.sql") && listOfFiles.get(1).getText().equals("SQLQuery_3.sql")) {
			System.out.println("2 files matched");
		}else {
			System.out.println("some files are not matched");	
		}	
	}

}
