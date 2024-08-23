package SeleniumPractice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SeleniumPractice.AbstractComponents.AbstractComponent;

public class Chekoutpage extends AbstractComponent {

	WebDriver driver;

	public Chekoutpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	/*Actions a = new Actions(driver);

		a.sendKeys(driver.findElement(By.cssSelector(".form-group input")), "india").build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body//app-root//button[2]")));

		driver.findElement(By.xpath("//body//app-root//button[2]")).click();
		driver.findElement(By.cssSelector(".actions a")).click();
*/
	
	@FindBy(css=".form-group input")
	WebElement country;
	
	@FindBy(xpath="//body//app-root//button[2]")
	WebElement selectcountry;
	
	@FindBy(css=".actions a")
	WebElement submit;
	
	
	public void Selectcountry(String countryName) {
		
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		WaitForElementToAppear(By.xpath("//body//app-root//button[2]"));
		selectcountry.click();
	
	}
	
	public ConfirmationPage submitOrder() { 
		
		submit.click();
		
		return new ConfirmationPage(driver);
	}
}
