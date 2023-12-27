package shoppingsite.pageobjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import shoppingsite.AbstractComponents.AbstractComponents;

public class cartPage extends AbstractComponents {

	WebDriver driv;

	public cartPage(WebDriver dr1) {
		super(dr1);
		this.driv = dr1;
		PageFactory.initElements(driv, dr1);
	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartitems;

	@FindBy(css = ".totalRow button")
	WebElement checkoutbutton;

	By productby = By.cssSelector(".mb-3");
	By addtocart = By.cssSelector(".card-body button:last-of-type");
	By toastmsg = By.cssSelector("#toast-container");

	public boolean verifycartitems(String prodvalidate) {
		Boolean cartmatch = cartitems.stream().anyMatch(item -> item.getText().equalsIgnoreCase(prodvalidate));
		return cartmatch;
	}

	public checkOut gotocheckout() {
		checkoutbutton.click();
		checkOut check1 = new checkOut(driv);
		return check1;
	}

}
