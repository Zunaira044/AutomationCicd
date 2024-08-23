package SeleniumPractice.StepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import SeleniumPractice.TestComponents.BaseTest;
import SeleniumPractice.pageobjects.CartPage;
import SeleniumPractice.pageobjects.Chekoutpage;
import SeleniumPractice.pageobjects.ConfirmationPage;
import SeleniumPractice.pageobjects.LandingPage;
import SeleniumPractice.pageobjects.ProductCatalog;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationImpl extends BaseTest {

	public LandingPage landingPage;
	public ProductCatalog Productcatalog;

	public ConfirmationPage ConfirmationPage;

	@Given(" I landed on ECommerce page")

	public void i_landed_on_e_commerce_page() throws IOException {

		landingPage = launchapplication();

	}

	@Given("^login with username (.+) and password (.+)$")

	public void login_with_username_and_password(String username, String password) {

		Productcatalog = Langdingpage.loginApplication(username, password);
	}

	@When("^I Product (.+) to cart$")

	public void i_add_product_to_cart(String productName) {
		List<WebElement> Products1 = Productcatalog.getproductlist();
		Productcatalog.addProductTocart(productName);

	}

	@And("^checkout (.+) and submit the order$")

	public void checkout_submit_the_order(String productName) {

		CartPage cartpage = Productcatalog.goTocardpage();
		boolean match = cartpage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		Chekoutpage Chekoutpage = cartpage.goToCheckout();
		Chekoutpage.Selectcountry("india");
		ConfirmationPage = Chekoutpage.submitOrder();

	}

	@Then("{string} message is displayed on confirmation page ")
	public void message_is_displayed_on_confirmation_page(String string) {

		String ConfirmationMessage = ConfirmationPage.getConfirmationmessage();

		Assert.assertTrue(ConfirmationMessage.equalsIgnoreCase(string));

	}
}
