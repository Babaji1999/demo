package pages;

import org.openqa.selenium.By;

public class LoginPage {
	
	
//	Normally writing
	public static final By homePageHeading = By.cssSelector("h1[class='title'] em");
	public static final By loginHeading = By.xpath("//*[text()='Log in']");
	
//	public static final By login_Email = By.id("userEmail");
//	public static final By login_Password = By.xpath("//label/following-sibling::input[@id='userPassword']");
	
//	public static final By login_Button = By.cssSelector("input#login[type=submit]");
	
	public static final By login_ForgotPwd = By.linkText("Forgot password?");
	public static final By login_DontHaveAcc = By.partialLinkText("Don't have");
	
	public static final By home_Text = By.xpath("//section[@id='sidebar']/p[text()=' Home | ']");
	
//	public static final By all_Products = By.cssSelector(".mb-3");
	public static final By product_Name = By.cssSelector("b");
	public static final By product_AddToCartButton = By.cssSelector(".card-body button:last-of-type");
	
	public static final By loading_Alert = By.xpath("//div[contains(@class,'la-ball-scale-multiple')]");
//	public static final By product_AddedSuccessMessage = By.id("toast-container");
	
	public static final By cart_Button = By.cssSelector("[routerlink*=cart]");
	
	public static final By itemsInCart = By.xpath("//*[@class='cartSection']/h3");
	
//	public static final By checkout_Button = By.xpath("//button[text()='Checkout']");
	
	public static final By selectCountry_Dropdown = By.cssSelector("input[class='input txt text-validated']:nth-child(1)");
	public static final By option_India = By.xpath("//button/span[text()=' India']");
	public static final By placeOrder_Button = By.className("action__submit");
	
	public static final By orderCnfMessage = By.cssSelector("h1[class='hero-primary']");
	
	public static final By download_OrderDetails = By.cssSelector("tr button:first-of-type");

//	public static final By signOutButton = By.xpath("//button[text()=' Sign Out ']");
	public static final By LogoutMessage = By.xpath("//div[@role='alert'][text()=' Logout Successfully ']");
}
