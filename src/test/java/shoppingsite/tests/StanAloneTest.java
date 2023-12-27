package shoppingsite.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

public class StanAloneTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "/Users/saramise/Downloads/geckodriver");

		String prodvalidate = "ZARA COAT 3";
		WebDriver dr1 = new FirefoxDriver();
		dr1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w1 = new WebDriverWait(dr1, Duration.ofSeconds(10));

		dr1.get("https://rahulshettyacademy.com/client");
		dr1.manage().window().maximize();

		// testpractice1@gmail.com, Nuzvid@123
		dr1.findElement(By.id("userEmail")).sendKeys("testpractice1@gmail.com");
		dr1.findElement(By.id("userPassword")).sendKeys("Nuzvid@123");
		dr1.findElement(By.id("login")).click();

		w1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> elems = dr1.findElements(By.cssSelector(".mb-3"));

		WebElement prod = elems.stream().filter(s -> s.findElement(By.tagName("b")).getText().equals(prodvalidate))
				.findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		w1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		// After it becomes invisible
		w1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));

		WebElement prod1 = elems.stream()
				.filter(s -> s.findElement(By.tagName("b")).getText().equals("ADIDAS ORIGINAL")).findFirst()
				.orElse(null);
		prod1.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		w1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		// After it becomes invisible
		w1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));

		dr1.findElement(By.cssSelector("[routerlink=\"/dashboard/cart\"]")).click();

		List<WebElement> cartitems = dr1.findElements(By.cssSelector(".cartSection h3"));

		Boolean cartmatch = cartitems.stream().anyMatch(item -> item.getText().equalsIgnoreCase(prodvalidate));
		Assert.assertTrue(cartmatch);

		dr1.findElement(By.cssSelector(".totalRow button")).click();

		Actions a1 = new Actions(dr1);
		a1.sendKeys(dr1.findElement(By.cssSelector("[placeholder=\"Select Country\"]")), "india").build().perform();

		w1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

		dr1.findElement(By.xpath("//button[@class=\"ta-item list-group-item ng-star-inserted\"][2]")).click();
		dr1.findElement(By.cssSelector(".action__submit")).click();

		String confirmsg = dr1.findElement(By.cssSelector("[class=\"hero-primary\"]")).getText();
		System.out.println("Expected message is " + confirmsg);
		Assert.assertTrue(confirmsg.equalsIgnoreCase("Thankyou for the order."));

		dr1.quit();

	}

}
