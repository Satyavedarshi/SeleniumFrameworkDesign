package shoppingsite.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {
	
	WebDriver driver;
	
	public OrdersPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderitems;
	
	
	public Boolean VerifyOrderDisplay(String productname) {
		Boolean match = orderitems.stream().anyMatch(p -> p.getText().equalsIgnoreCase(productname));
		return match;
	}

}
