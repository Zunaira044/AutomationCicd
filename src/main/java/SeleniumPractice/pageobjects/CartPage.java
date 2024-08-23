package SeleniumPractice.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumPractice.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> CartProducts;

	@FindBy(css = ".totalRow button")
	WebElement checkout;

	public Boolean VerifyProductDisplay(String ProudctName) {

		Boolean Match = CartProducts.stream()
				.anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(ProudctName));
		return Match;
	}

	public Chekoutpage goToCheckout() {

		checkout.click();
		return new Chekoutpage(driver);
	}

}

/*
 * List<WebElement> cartproducts =
 * driver.findElements(By.cssSelector(".cartSection h3"));
 * 
 * boolean match = cartproducts.stream() .anyMatch(cartproduct ->
 * cartproduct.getText().equalsIgnoreCase(ProudctName));
 */