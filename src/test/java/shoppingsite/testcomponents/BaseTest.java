package shoppingsite.testcomponents;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import shoppingsite.pageobjects.LandingPage;


public class BaseTest {
	
	public WebDriver dr1;
	
	public WebDriver initializeDriver() throws IOException {
		//Propertoes class
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//resources//GlobalData.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");
		
		if (browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "/Users/saramise/Downloads/geckodriver");
			WebDriver dr1 = new FirefoxDriver();
			
		}

		dr1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w1 = new WebDriverWait(dr1, Duration.ofSeconds(10));
		
		return dr1;
		
	}
	
	public void launchApp() throws IOException {
		WebDriver driver = initializeDriver();
		LandingPage lp = new LandingPage(driver);
		lp.goTo();
		
	}

}
