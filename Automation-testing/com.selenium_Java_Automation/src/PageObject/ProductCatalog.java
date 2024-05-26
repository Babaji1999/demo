package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonPage.AbstractComponents;
import pages.LoginPage;

public class ProductCatalog extends AbstractComponents{
	
	WebDriver driver;
	
	public ProductCatalog(WebDriver driver) {
//		sending driver to parent constructor
		super(driver);
//		initilization
		this.driver = driver;
//		Why this method is created--Before going to any method first this constructor will execute
		PageFactory.initElements(driver, this);
	}
	
	By all_Products = By.cssSelector(".mb-3");
	public static final By product_AddToCartButton = By.cssSelector(".card-body button:last-of-type");
	By product_AddedSuccessMessage = By.id("toast-container");
	
	// PageFactory
	
	@FindBy(css = ".mb-3")
	List<WebElement> all_ProductsList;
	
	@FindBy(xpath = "//div[contains(@class,'la-ball-scale-multiple')]")
	WebElement loading_alert;
	
	public List<WebElement> getproductList() {
		waitforElementToAppear(all_Products);
		return all_ProductsList;
	}
	
	public WebElement getProductName(String productName) {
		WebElement product_Name = all_ProductsList.stream().filter(product -> product.findElement(LoginPage.product_Name).getText().equals(productName)).findFirst().orElse(null);
		return product_Name;
	}
	
	public void addProductToCart(String productName) {
		WebElement prod = getProductName(productName);
		prod.findElement(product_AddToCartButton).click();
		waitforElementToAppear(product_AddedSuccessMessage);
		waitforElementToDisappear(loading_alert);
	}
}
