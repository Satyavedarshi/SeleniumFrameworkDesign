package chromedevtools;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class consolelogerrors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver dr1 = new ChromeDriver();
		dr1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		DevTools dt = dr1.getDevTools();

		dt.createSession();
		
		dr1.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		dr1.findElement(By.linkText("Browse Products")).click();
		dr1.findElement(By.linkText("Selenium")).click();
		dr1.findElement(By.cssSelector(".add-to-cart")).click();
		dr1.findElement(By.linkText("Cart")).click();
		
		dr1.findElement(By.id("exampleInputEmail1")).clear();
		dr1.findElement(By.id("exampleInputEmail1")).sendKeys("2");
		
		LogEntries entry = dr1.manage().logs().get(LogType.BROWSER);
		List<LogEntry> entries = entry.getAll();
		
		for(LogEntry e: entries) {
			System.out.println(e.getMessage());
		}

	}

}
