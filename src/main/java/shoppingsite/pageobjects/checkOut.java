package shoppingsite.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import shoppingsite.AbstractComponents.AbstractComponents;

public class checkOut extends AbstractComponents {

	WebDriver driv3;

	public checkOut(WebDriver dr1) {
		super(dr1);
		this.driv3 = dr1;
		PageFactory.initElements(driv3, dr1);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;

	@FindBy(xpath = "//button[@class=\"ta-item list-group-item ng-star-inserted\"][2]")
	WebElement selectcountryelm;

	@FindBy(css = ".action__submit")
	WebElement confbutton;

	public void selectcountry(String Country1) {
		Actions a1 = new Actions(driv3);
		a1.sendKeys(country, Country1).build().perform();
		waitforelemnttoappear(By.cssSelector(".ta-results"));
		selectcountryelm.click();
	}

	public confirmPage submitconfirm() {
		confbutton.click();
		confirmPage cp1 = new confirmPage(driv3);
		return cp1;
	}
}
