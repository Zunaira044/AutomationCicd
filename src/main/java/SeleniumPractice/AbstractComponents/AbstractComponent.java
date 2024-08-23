package SeleniumPractice.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumPractice.pageobjects.CartPage;
import SeleniumPractice.pageobjects.Orderpage;

public class AbstractComponent {

	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
	//css=button[routerlink='/dashboard/cart']
	//xpath ="//button[@routerlink='/dashboard/cart']"
	@FindBy(css ="button[routerlink='/dashboard/cart']")
	WebElement cartHeader;

	@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	WebElement OrderHeader;

	public void WaitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}

	public void WaitForWebElementToAppear(WebElement findby) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findby));
	}

	public void waitForElementTodisappear(By findy) {

		// Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findy));

	}

	public CartPage goTocardpage() {

		cartHeader.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}

	public Orderpage goToOrderpage() {

		OrderHeader.click();
		Orderpage Orderpage = new Orderpage(driver);
		return Orderpage;

	}
}
