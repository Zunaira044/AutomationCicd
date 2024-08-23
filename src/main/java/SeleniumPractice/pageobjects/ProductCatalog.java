package SeleniumPractice.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumPractice.AbstractComponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent {

	WebDriver driver;

	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	List<WebElement> Products = driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css = ".col-lg-4")
	List<WebElement> Products;

	By ProductBy = By.cssSelector(".mb-3");
	By addToCart = By.xpath("//div/button [2]");
	By toastMeassage = By.cssSelector("#toast-container");  
	By spinner = By.cssSelector(".ng-animating");

	public List<WebElement> getproductlist() {
		WaitForElementToAppear(ProductBy); 
		return Products;
	}

//step1 getting list of products
	public WebElement getProductbyName(String ProudctName) {

		WebElement prod = getproductlist().stream()
				.filter(Product -> Product.findElement(By.cssSelector("b")).getText().equals(ProudctName)).findFirst()
				.orElse(null);
		return prod;
	}

//step2 add to card the required product
	public void addProductTocart(String ProudctName) {

		WebElement prod = getProductbyName(ProudctName); 
		prod.findElement(addToCart).click();
		WaitForElementToAppear(toastMeassage);
		waitForElementTodisappear(spinner); 

	}
}
