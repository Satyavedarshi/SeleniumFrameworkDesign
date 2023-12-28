 package shoppingsite.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
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
import org.testng.annotations.Test;

import shoppingsite.pageobjects.LandingPage;
import shoppingsite.pageobjects.ProductCatalogue;
import shoppingsite.pageobjects.cartPage;
import shoppingsite.pageobjects.checkOut;
import shoppingsite.pageobjects.confirmPage;
import shoppingsite.testcomponents.BaseTest;

public class SubmitOrderTest extends BaseTest{

		@Test
		public void SubmitOrder() throws IOException {
			
			// TODO Auto-generated method stub

			String prodvalidate = "ZARA COAT 3";


			// testpractice1@gmail.com, Nuzvid@123
			ProductCatalogue p1 = lp.loginApplication("testpractice1@gmail.com", "Nuzvid@123");

			p1.additemtocart(prodvalidate);
			p1.additemtocart("ADIDAS ORIGINAL");
			cartPage cart1 = p1.gotocartpage();

			cart1.verifycartitems(prodvalidate);
			checkOut checkpage = cart1.gotocheckout();

			checkpage.selectcountry("india");
			confirmPage msg = checkpage.submitconfirm();

			String confirmsg = msg.checkconfirmmsg();

			System.out.println("Expected message is " + confirmsg);
			AssertJUnit.assertTrue(confirmsg.equalsIgnoreCase("Thankyou for the order."));
			
		}
		
	

}
