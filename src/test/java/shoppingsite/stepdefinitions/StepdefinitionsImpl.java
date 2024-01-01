package shoppingsite.stepdefinitions;

import java.io.IOException;

import org.testng.AssertJUnit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import shoppingsite.pageobjects.LandingPage;
import shoppingsite.pageobjects.ProductCatalogue;
import shoppingsite.pageobjects.cartPage;
import shoppingsite.pageobjects.checkOut;
import shoppingsite.pageobjects.confirmPage;
import shoppingsite.testcomponents.BaseTest;

public class StepdefinitionsImpl extends BaseTest{
	
	public LandingPage landingpage;
	public ProductCatalogue pc;
	public cartPage cart1;
	public checkOut checkpage;
	public confirmPage msg;
	
	@Given("I landed on the Ecommerce Page")
	public void I_landed_on_the_Ecommerce_Page() throws IOException {
		landingpage = launchApp();
		
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String email, String passwd) {
		pc = landingpage.loginApplication(email,passwd);
	}
	
	@When("^I add (.+) to cart$")
	public void I_add_to_cart(String productname) {
		pc.additemtocart(productname);
	}
	
	@And("^checkout (.+) and submit the order$")
	public void checkout_and_submit_order(String productname) {
		cart1 = pc.gotocartpage();
		cart1.verifycartitems(productname);
		checkpage = cart1.gotocheckout();

		checkpage.selectcountry("india");
		msg = checkpage.submitconfirm();
	}
	
	@Then("{string} message is displayed on ConfirmationPage")
	public void message_displayed_on_ConfirmationPage(String confirmmessage) {
		String confirmsg = msg.checkconfirmmsg();

		System.out.println("Expected message is " + confirmsg);
		AssertJUnit.assertTrue(confirmsg.equalsIgnoreCase("Thankyou for the order."));
		
		driver.close();
	}
	
}
