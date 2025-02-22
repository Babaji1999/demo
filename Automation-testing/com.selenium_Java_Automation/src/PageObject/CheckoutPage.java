package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonPage.AbstractComponents;
import pages.LoginPage;

public class CheckoutPage extends AbstractComponents{

	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
//		initilization
		this.driver = driver;
//		Why this method is created--Before going to any method first this constructor will execute
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "input[class='input txt text-validated']:nth-child(1)")
	WebElement selectCountry_Field;

	By option_India = By.xpath("//button/span[text()=' India']");

	@FindBy(className = "action__submit")
	WebElement placeOrder_Button;

	public void selectCountry(String countyName) {
		selectCountry_Field.sendKeys(countyName);
		waitforElementToAppear(option_India);
		driver.findElement(LoginPage.option_India).click();
	}
	
	public ConfirmationPage submitOrder() {
		placeOrder_Button.click();
		return new ConfirmationPage(driver);
	}
	
}
