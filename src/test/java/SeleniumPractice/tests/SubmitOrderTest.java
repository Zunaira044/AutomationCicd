package SeleniumPractice.tests;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumPractice.TestComponents.BaseTest;
import SeleniumPractice.pageobjects.CartPage;
import SeleniumPractice.pageobjects.Chekoutpage;
import SeleniumPractice.pageobjects.ConfirmationPage;
import SeleniumPractice.pageobjects.LandingPage;
import SeleniumPractice.pageobjects.Orderpage;
import SeleniumPractice.pageobjects.ProductCatalog;

public class SubmitOrderTest extends BaseTest {
    	String ProudctName = "ZARA COAT 3";

	@Test(dataProvider = "getdata", groups = { "Purschase order" })
	public void SubmitOrder(HashMap<String, String> input) throws IOException {
		// TODO Auto-generated method stub
		
		ProductCatalog Productcatalog = Langdingpage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> Products1 = Productcatalog.getproductlist();
		Productcatalog.addProductTocart(input.get("product")); 
		CartPage cartpage = Productcatalog.goTocardpage();

		boolean match = cartpage.VerifyProductDisplay(input.get("product"));

		Assert.assertTrue(match);

		Chekoutpage Chekoutpage = cartpage.goToCheckout();

		Chekoutpage.Selectcountry("india");
		ConfirmationPage ConfirmationPage = Chekoutpage.submitOrder();
		String ConfirmationMessage = ConfirmationPage.getConfirmationmessage();

		Assert.assertTrue(ConfirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods = { "SubmitOrder" })

	public void OrderHistoryTest() {
		ProductCatalog Productcatalog = Langdingpage.loginApplication("mdsarfaraz376@gmail.com", "Faraz@000");

		Orderpage Orderpage = Productcatalog.goToOrderpage();

		Assert.assertTrue(Orderpage.VerifyOrdersDisplay(ProudctName));

	}

	@DataProvider
	public Object[][] getdata() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//SeleniumPractice//data//PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}
}

/*
 * HashMap<String, String> map = new HashMap<String, String>(); map.put("email",
 * "mdsarfaraz376@gmail.com"); map.put("password", "Faraz@000");
 * map.put("product", "ZARA COAT 3");
 * 
 * HashMap<String, String> map1 = new HashMap<String, String>();
 * map.put("email", "Bilal376@gmail.com"); map.put("password", "Bilal@786");
 * map.put("product", "ADIDAS ORIGINAL");
 */