package shoppingsite.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class confirmPage {

	WebDriver driver;

	public confirmPage(WebDriver driv3) {
		// TODO Auto-generated constructor stub
		this.driver = driv3;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[class=\"hero-primary\"]")
	WebElement confmsgelem;

	public String checkconfirmmsg() {
		String confirmsg = confmsgelem.getText();
		return confirmsg;
	}

}
