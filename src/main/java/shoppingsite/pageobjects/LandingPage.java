package shoppingsite.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shoppingsite.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	WebDriver driver;

	public LandingPage(WebDriver dr1) {
		super(dr1);
		this.driver = dr1;
		PageFactory.initElements(driver, this);

	}

	// WebElement email = driv.findElement(By.id("userEmail"));
	@FindBy(id = "userEmail")
	WebElement email;

	@FindBy(id = "userPassword")
	WebElement passwd;

	@FindBy(id = "login")
	WebElement submitbutton;

	public ProductCatalogue loginApplication(String emailtext, String password) {
		email.sendKeys(emailtext);
		passwd.sendKeys(password);
		submitbutton.click();
		ProductCatalogue p1 = new ProductCatalogue(driver);
		return p1;

	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
	}

}
