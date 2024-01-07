package AutoIt;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class windowauth {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "/Users/saramise/Downloads/geckodriver");


		WebDriver dr3 = new FirefoxDriver(); 
		dr3.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		dr3.manage().window().maximize();


		dr3.get("http://admin:admin@the-internet.herokuapp.com/");
		
		dr3.findElement(By.linkText("Basic Auth")).click();

		

	}

}
