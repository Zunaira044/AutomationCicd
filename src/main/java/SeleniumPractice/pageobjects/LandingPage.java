package SeleniumPractice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumPractice.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	WebElement useremail =driver.findElement(By.cssSelector("#userEmail"));

	@FindBy(css = "#userEmail")
	WebElement userEmail;

	@FindBy(css = "#userPassword")
	WebElement passwords;

	@FindBy(css = "#login")
	WebElement login;

	@FindBy(css = "div[aria-label='Incorrect email or password.']")
	WebElement errormessage; 

	public void Goto() {
		driver.get("https://rahulshettyacademy.com/client/");  
	}

	public ProductCatalog loginApplication(String email, String Password) {
		userEmail.sendKeys(email);
		passwords.sendKeys(Password);
		login.click();
		ProductCatalog Productcatalog = new ProductCatalog(driver);
		return Productcatalog;
	}
	
	public String Errormessage() {
		WaitForWebElementToAppear(errormessage);
		return errormessage.getText();
		
	}

}
