package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//*[contains(text(),'Apple iPhone 16') and (@class='css-146c3p1 r-dnmrzs r-1udh08x r-1udbk01 r-3s2u2q r-1iln25a r-cqee49 r-1et8rh5 r-ubezar')]")
	WebElement iPhone16;

	
	public boolean isProductAdded() {
		return iPhone16.isDisplayed();
	}
}
