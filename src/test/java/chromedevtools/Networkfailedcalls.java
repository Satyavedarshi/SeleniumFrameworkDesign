package chromedevtools;

import java.time.Duration;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.fetch.Fetch;
import org.openqa.selenium.devtools.v118.network.model.ErrorReason;
import org.openqa.selenium.devtools.v118.network.model.RequestPattern;

public class Networkfailedcalls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver dr1 = new ChromeDriver();
		dr1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		DevTools dt = dr1.getDevTools();

		dt.createSession();
		
		Optional pat = Optional.of(new RequestPattern(Optional.of("*GetBook*"),Optional.empty(),Optional.empty()));
		
		dt.send(Fetch.enable(pat, Optional.empty()));
		dt.addListener(Fetch.requestPaused(), request->{
			if(request.getRequest().getUrl().contains("shetty")) {
				dt.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
			}
		});



		dr1.get("https://rahulshettyacademy.com/angularAppdemo/");

		dr1.findElement(By.cssSelector("button[routerlink*='library']")).click();

		System.out.println(dr1.findElement(By.cssSelector("p")).getText());


	}

}
