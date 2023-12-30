package shoppingsite.testcomponents;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import shoppingsite.pageobjects.LandingPage;


public class BaseTest {
	
	public WebDriver dr1;
	public LandingPage lp;
	
	public WebDriver initializeDriver() throws IOException {
		//Properties class
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src/main//java//shoppingsite//resources//GlobalData.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");
		
		if (browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "/Users/saramise/Downloads/geckodriver");
			dr1 = new FirefoxDriver();
			
		}

		dr1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w1 = new WebDriverWait(dr1, Duration.ofSeconds(10));
		
		return dr1;
		
	}
	
	public List<HashMap<String,String>> getJsonDataToMap(String Fileloc) throws IOException {
		//read json to String
		String jsoncontent = FileUtils.readFileToString(new File(Fileloc),StandardCharsets.UTF_8);

		//String HashMap
		ObjectMapper mapper = new ObjectMapper(); 
		List<HashMap<String,String>> data = mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String,String>>>(){});
		return data;
	}

	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApp() throws IOException {
		WebDriver driver = initializeDriver();
		lp = new LandingPage(driver);
		lp.goTo();
		return lp;
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeDriver() {
		dr1.close();
	}

}
