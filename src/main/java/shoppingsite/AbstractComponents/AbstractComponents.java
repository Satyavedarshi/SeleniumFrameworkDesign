package shoppingsite.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import shoppingsite.pageobjects.OrdersPage;
import shoppingsite.pageobjects.cartPage;

public class AbstractComponents {

	WebDriver driver;

	public AbstractComponents(WebDriver dr1) {
		// TODO Auto-generated constructor stub

		this.driver = dr1;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerlink=\"/dashboard/cart\"]")
	WebElement cartbutton;
	
	@FindBy(css="[routerlink=\"/dashboard/myorders\"]")
	WebElement myorders;

	public void waitforelemnttoappear(By findby) {
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w1.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	public void waitforwebelemnttoappear(WebElement wb) {
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w1.until(ExpectedConditions.visibilityOf(wb));
	}

	public void waitforelemnttodisappear(WebElement anime) {
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w1.until(ExpectedConditions.invisibilityOf(anime));
	}

	public cartPage gotocartpage() {
		cartbutton.click();
		cartPage cart1 = new cartPage(driver);
		return cart1;
	}
	
	public OrdersPage gotoorderspage() {
		myorders.click();
		OrdersPage op = new OrdersPage(driver);
		return op;
	}

}
