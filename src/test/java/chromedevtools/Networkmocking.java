package chromedevtools;

import java.time.Duration;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.fetch.Fetch;
import org.openqa.selenium.devtools.v118.network.Network;
import org.openqa.selenium.devtools.v118.network.model.Request;
import org.openqa.selenium.devtools.v118.network.model.Response;

public class Networkmocking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver dr1 = new ChromeDriver();
		dr1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		DevTools dt = dr1.getDevTools();
		
		dt.createSession();
		dt.send(Fetch.enable(Optional.empty(), Optional.empty()));
		dt.addListener(Fetch.requestPaused(), request->{
			if(request.getRequest().getUrl().contains("shetty")) {
				String newurl = request.getRequest().getUrl().replace("=shetty","=BadGuy");
				System.out.println(newurl);
				dt.send(Fetch.continueRequest(request.getRequestId(), Optional.of(newurl), Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty(), Optional.empty()));
			}
			else {
				dt.send(Fetch.continueRequest(request.getRequestId(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
			}
		});
		
		
		
		dr1.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		dr1.findElement(By.cssSelector("button[routerlink*='library']")).click();
		
		System.out.println(dr1.findElement(By.cssSelector("p")).getText());

	}

}
