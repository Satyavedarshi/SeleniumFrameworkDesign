package chromedevtools;

import java.time.Duration;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.network.model.ConnectionType;
import org.openqa.selenium.devtools.v118.network.Network;

import com.google.common.collect.ImmutableList;

public class networkspeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver dr1 = new ChromeDriver();
		dr1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		DevTools dt = dr1.getDevTools();

		dt.createSession();
		
		dt.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		dt.send(Network.emulateNetworkConditions(false, 3000, 20000, 10000, Optional.of(ConnectionType.ETHERNET)));


		dr1.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		dr1.findElement(By.linkText("Browse Products")).click();
		dr1.findElement(By.linkText("Selenium")).click();
		dr1.findElement(By.cssSelector(".add-to-cart")).click();

		System.out.println(dr1.findElement(By.cssSelector("p")).getText());

	}

}
