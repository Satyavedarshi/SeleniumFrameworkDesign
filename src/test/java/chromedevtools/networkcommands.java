package chromedevtools;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.network.Network;
import org.openqa.selenium.devtools.v118.network.model.Request;
import org.openqa.selenium.devtools.v118.network.model.Response;

public class networkcommands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver dr1 = new ChromeDriver();
		DevTools dt = dr1.getDevTools();
		
		dt.createSession();
		dt.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		dt.addListener(Network.requestWillBeSent(), request->{
			Request req = request.getRequest();
			System.out.println(req.getUrl());
			
		});
		
		dt.addListener(Network.responseReceived(), resp->{
			Response res = resp.getResponse();
			System.out.println(res.getUrl());
			System.out.println(res.getStatus());
			if(res.getStatus().toString().startsWith("4")) {
				System.out.println(res.getUrl());
			}
			
		});
		
		dr1.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		dr1.findElement(By.cssSelector("button[routerlink*='library']")).click();
		

	}

}
