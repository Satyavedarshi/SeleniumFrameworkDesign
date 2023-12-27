package shoppingsite.pageobjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shoppingsite.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {

	WebDriver driver;

	public ProductCatalogue(WebDriver fromlandingdriv) {
		super(fromlandingdriv);
		this.driver = fromlandingdriv;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> itemslist;

	@FindBy(css = ".ng-animating")
	WebElement anime1;

	By productby = By.cssSelector(".mb-3");
	By addtocart = By.cssSelector(".card-body button:last-of-type");
	By toastmsg = By.cssSelector("#toast-container");

	public List<WebElement> getproductList() {
		waitforelemnttoappear(productby);
		return itemslist;
	}

	public WebElement getProductByName(String productname) {
		WebElement prod = getproductList().stream().filter(s -> s.findElement(By.tagName("b")).getText().equals(productname))
				.findFirst().orElse(null);
		return prod;
	}

	public void additemtocart(String productname) {
		WebElement prod = getProductByName(productname);
		prod.findElement(addtocart).click();
		waitforelemnttoappear(toastmsg);
		waitforelemnttodisappear(anime1);

	}

}
