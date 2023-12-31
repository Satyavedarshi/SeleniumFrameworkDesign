package shoppingsite.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.sun.net.httpserver.Authenticator.Retry;

import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import shoppingsite.pageobjects.ProductCatalogue;
import shoppingsite.pageobjects.cartPage;
import shoppingsite.pageobjects.checkOut;
import shoppingsite.pageobjects.confirmPage;
import shoppingsite.testcomponents.BaseTest;
import shoppingsite.testcomponents.RetryTest;

public class errorValidations extends BaseTest{
	
	@Test(groups= {"ErrorHandling"}, retryAnalyzer=RetryTest.class)
	public void loginErrorCheck() throws IOException {
		
		// TODO Auto-generated method stub

		String prodvalidate = "ZARA COAT 3";
		
		

		// testpractice1@gmail.com, Nuzvid@123
		lp.loginApplication("testbhamchik@gmail.com", "Nuzvid@123");
		AssertJUnit.assertEquals("Incorrect email or password.", lp.getErrorMessage());
		
	}
	
	@Test
	public void ProductNameErrorCheck() throws IOException {
		
		// TODO Auto-generated method stub

		String prodvalidate = "ZARA COAT 3";

		// testpractice1@gmail.com, Nuzvid@123
		ProductCatalogue p1 = lp.loginApplication("testpractice1@gmail.com", "Nuzvid@123");

		p1.additemtocart(prodvalidate);
		p1.additemtocart("ADIDAS ORIGINAL");
		cartPage cart1 = p1.gotocartpage();

		AssertJUnit.assertTrue(cart1.verifycartitems("ZARA COAT 3"));
		checkOut checkpage = cart1.gotocheckout();

		checkpage.selectcountry("india");
		confirmPage msg = checkpage.submitconfirm();

		String confirmsg = msg.checkconfirmmsg();

		System.out.println("Expected message is " + confirmsg);
		AssertJUnit.assertTrue(confirmsg.equalsIgnoreCase("Thankyou for the order."));
		
	}

}
