package chromedevtools;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

public class Mobileemulatortest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.setProperty("webdriver.chrome.driver", "/Users/saramise/Documents/browserDrivers/chromedriver");

		ChromeDriver dr1 = new ChromeDriver();
		dr1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		DevTools dt = dr1.getDevTools();

		dt.createSession();


		//dt.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));

		Map cdpmap = new HashMap();
		cdpmap.put("width", 600);
		cdpmap.put("height", 1000);
		cdpmap.put("deviceScaleFactor", 50);
		cdpmap.put("mobile", true);

		/*
		 * dr1.executeCdpCommand("Emulation.setDeviceMetricsOverride", cdpmap);
		 * 
		 * dr1.get("https://rahulshettyacademy.com/angularAppdemo/");
		 * 
		 * dr1.findElement(By.className("navbar-toggler-icon")).click();
		 * dr1.findElement(By.linkText("Library")).click();
		 */

		Map<String,Object> cords = new HashMap<String,Object>();
		cords.put("latitude", 23);
		cords.put("longitude", 45);
		cords.put("accuracy", 1);
		

		dr1.executeCdpCommand("Emulation.setGeolocationOverride", cords);
		dr1.get("http://google.com");
		
		dr1.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
		dr1.findElements(By.cssSelector(".LC20lb")).get(0).click();
		
		//String title = dr1.findElement(By.cssSelector(".our-story-card-title")).getText();	
		//System.out.println(title);


	}

}
