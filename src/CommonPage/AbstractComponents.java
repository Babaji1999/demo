package CommonPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.CartPage;
import PageObject.OrderPage;
import pages.LoginPage;

public class AbstractComponents {
	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
	}
	
	By checkout_Button = By.xpath("//button[text()='Checkout']");
	By backToCart_Button = By.xpath("//button[text()='Go Back to Cart']");
	
	@FindBy(css = "[routerlink*=myorders]")
	WebElement orders_Button;

	public void waitforElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));	
	}
	
	public void waitforElementToDisappear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOf(element));	
	}
	
	public void waitforElementToBeClickable(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(findBy));	
	}
	
	public CartPage gotToCartPage() {
		driver.findElement(LoginPage.cart_Button).click();
		waitforElementToBeClickable(checkout_Button);
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public OrderPage gotToOrderPage() {
		orders_Button.click();
		waitforElementToBeClickable(backToCart_Button);
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}
}
