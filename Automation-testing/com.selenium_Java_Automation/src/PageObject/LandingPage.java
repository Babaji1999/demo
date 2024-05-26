package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonPage.AbstractComponents;
import pages.LoginPage;

public class LandingPage extends AbstractComponents{

	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
//		initilization
		this.driver = driver;
//		Why this method is created--Before going to any method first this constructor will execute
		PageFactory.initElements(driver, this);
	}
	
	// PageFactory
	@FindBy(id = "userEmail")
	WebElement login_Email;
	
	@FindBy(xpath = "//label/following-sibling::input[@id='userPassword']")
	WebElement login_Password;
	
	@FindBy(css = "input#login[type=submit]")
	WebElement login_Button;
	
	@FindBy(xpath = "//button[text()=' Sign Out ']")
	WebElement signOutButton;
	
	By errorMessage = By.xpath("//div[@id='toast-container']/div/div[1]");
	
	public ProductCatalog loginApplication(String email, String password) {
		login_Email.sendKeys(email);
		login_Password.sendKeys(password);
		login_Button.click();
		ProductCatalog productCatalog = new ProductCatalog(driver);
		return productCatalog;
	}
	
	public String getErrorMessage() {
		waitforElementToAppear(errorMessage);
		return driver.findElement(errorMessage).getText();
	}
	
	public void naviagte_LandingPage() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public void naviagte_LandingPage_AfterSignOut() {
		signOutButton.click();
		waitforElementToAppear(LoginPage.LogoutMessage);
	}
	
}
