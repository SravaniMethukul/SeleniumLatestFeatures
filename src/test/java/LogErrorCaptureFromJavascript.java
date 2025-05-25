import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class LogErrorCaptureFromJavascript {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		
		//using in built Selenium package
		
		//listeners 

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("a[routerlink='/products']")).click();
		
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		
		driver.findElement(By.linkText("Cart")).click();
		driver.findElement(By.id("exampleInputEmail1")).clear();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
		
		LogEntries entry = driver.manage().logs().get(LogType.BROWSER); //get log entry object
		
		List<LogEntry> entries = entry.getAll(); //getAll() returns all logs in list
		for(LogEntry e : entries) { //iterate and get each Message
			System.out.println(e.getMessage());
		}
	}

}
