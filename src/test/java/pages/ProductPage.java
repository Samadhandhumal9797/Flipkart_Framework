package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;


public class ProductPage {
	
	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=("//*[contains(@style,'border-radius: 12px; border-width: 1px;') and (@class='css-g5y9jx')]"))
	WebElement addToCartButton;
	
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
	

	@FindBy(xpath="//*[@href= '/viewcart?marketplace=FLIPKART']")
	WebElement cartButton;
	
	@FindBy(xpath="(//div[normalize-space()='Add to cart'])[1]")
	WebElement btnAddToCart;
	
	
	
	
	
	public void clickAddToCart() {
		
		addToCartButton.click();
	}
	
	public void clickCart() {
	  cartButton.click();
	}
	
	public void addToCartMixer() {
		btnAddToCart.click();
	}
	
	
}
