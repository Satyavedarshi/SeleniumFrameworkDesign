 package shoppingsite.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import shoppingsite.pageobjects.LandingPage;
import shoppingsite.pageobjects.OrdersPage;
import shoppingsite.pageobjects.ProductCatalogue;
import shoppingsite.pageobjects.cartPage;
import shoppingsite.pageobjects.checkOut;
import shoppingsite.pageobjects.confirmPage;
import shoppingsite.testcomponents.BaseTest;

public class SubmitOrderTest extends BaseTest{

		@Test(dataProvider="getData", groups= {"purchaseorder"})
		public void SubmitOrder(HashMap<String,String> map) throws IOException {
			
			// TODO Auto-generated method stub


			// testpractice1@gmail.com, Nuzvid@123
			//ProductCatalogue p1 = lp.loginApplication("testpractice1@gmail.com", "Nuzvid@123");
			ProductCatalogue p1 = lp.loginApplication(map.get("email"), map.get("passwd"));

			p1.additemtocart(map.get("productname"));
			cartPage cart1 = p1.gotocartpage();

			cart1.verifycartitems(map.get("productname"));
			checkOut checkpage = cart1.gotocheckout();

			checkpage.selectcountry("india");
			confirmPage msg = checkpage.submitconfirm();

			String confirmsg = msg.checkconfirmmsg();

			System.out.println("Expected message is " + confirmsg);
			AssertJUnit.assertTrue(confirmsg.equalsIgnoreCase("Thankyou for the order."));
			
		}
		
		@Test(dependsOnMethods= {"SubmitOrder"}, dataProvider="getData")
		public void OrderHistoryTest(HashMap<String,String> map1) throws IOException {
			
			// TODO Auto-generated method stub

			//String prodvalidate = "ZARA COAT 3";
			// testpractice1@gmail.com, Nuzvid@123
			ProductCatalogue p1 = lp.loginApplication(map1.get("email"), map1.get("passwd"));

			OrdersPage op = p1.gotoorderspage();
			Assert.assertTrue(op.VerifyOrderDisplay("FAIL PRODUCTNAME"));
			//Assert.assertTrue(op.VerifyOrderDisplay(map1.get("productname")));
			
		}
		
		
		@DataProvider
		public Object[][] getData() throws IOException {
			/*
			 * HashMap<String,String> map1 = new HashMap<String,String>(); map1.put("email",
			 * "testpractice1@gmail.com"); map1.put("passwd", "Nuzvid@123");
			 * map1.put("productname","ZARA COAT 3");
			 * 
			 * HashMap<String,String> map2 = new HashMap<String,String>(); map2.put("email",
			 * "testpractice1@gmail.com"); map2.put("passwd", "Nuzvid@123");
			 * map2.put("productname","ADIDAS ORIGINAL");
			 */
			List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//shoppingsite//data//PurchaseOrder.json");
			return new Object[][] {{data.get(0)},{data.get(1)}};
			//return new Object[][] {{"testpractice1@gmail.com", "Nuzvid@123","ZARA COAT 3"},{"testpractice1@gmail.com", "Nuzvid@123","ADIDAS ORIGINAL"},{"testpractice2@gmail.com", "Nuzvid@123","ADIDAS ORIGINAL"}};
		}
		
	

}
