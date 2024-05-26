package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonPage.AbstractComponents;

public class OrderPage extends AbstractComponents{

	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		super(driver);
//		initilization
		this.driver = driver;
//		Why this method is created--Before going to any method first this constructor will execute
		PageFactory.initElements(driver, this);
	}
	
	// PageFactory
	@FindBy(css = "tr td:nth-child(3) ")
	List<WebElement> productNames;
	
	public Boolean VerifyOrderDisplay(String productName) {		
		Boolean match = productNames.stream().anyMatch(item -> item.getText().equalsIgnoreCase(productName));
		return match;	
	}
	

}
