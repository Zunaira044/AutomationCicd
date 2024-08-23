package SeleniumPractice.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import SeleniumPractice.TestComponents.BaseTest;
import SeleniumPractice.pageobjects.CartPage;
import SeleniumPractice.pageobjects.Chekoutpage;
import SeleniumPractice.pageobjects.ConfirmationPage;
import SeleniumPractice.pageobjects.LandingPage;
import SeleniumPractice.pageobjects.ProductCatalog;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups= {"ErrorValidation"})
	public void LoginErrorValidations() {
		// TODO Auto-generated method stub 

		String ProudctName = "ZARA COAT 3";
		ProductCatalog Productcatalog = Langdingpage.loginApplication("mdsarfaraz3176@gmail.com", "Faraz@000");

		Assert.assertEquals("Incorrect email or password.", Langdingpage.Errormessage());

	}
 
	@Test
	
	public void ProductErrorValidation() throws IOException {
		// TODO Auto-generated method stub

		String ProudctName = "ZARA COAT 3";
		ProductCatalog Productcatalog = Langdingpage.loginApplication("Bilal376@gmail.com", "Bilal@786");

		List<WebElement> Products1 = Productcatalog.getproductlist();
		Productcatalog.addProductTocart(ProudctName);
		CartPage cartpage = Productcatalog.goTocardpage();

		boolean match = cartpage.VerifyProductDisplay("ZARA COAT 33"); 

		Assert.assertFalse(match);
 
}
}