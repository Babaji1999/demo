package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonPage.AbstractComponents;
import pages.LoginPage;

public class ConfirmationPage extends AbstractComponents{

	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
//		initilization
		this.driver = driver;
//		Why this method is created--Before going to any method first this constructor will execute
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "h1[class='hero-primary']")
	WebElement orderCnfMessage;
	
	public Boolean getConfirmationMessage() {
		String orderPageThankyouMessage = " Thankyou for the order. ";
		waitforElementToBeClickable(LoginPage.download_OrderDetails);
		Boolean thankyouPage = orderCnfMessage.getText().trim().equalsIgnoreCase(orderPageThankyouMessage.trim());
		return thankyouPage;
	}

}
