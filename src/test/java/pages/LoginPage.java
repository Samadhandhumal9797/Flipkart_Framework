package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//button[normalize-space()='Request OTP']")
	WebElement requestOtp;
	
	@FindBy(xpath="(//span[normalize-space()='Please enter valid Email ID/Mobile number'])[2]")
	WebElement errorMessage;
	
	
	public void clickRequestOtp() {
		requestOtp.click();
	}
	
	public boolean errorMessagedisplayed() {
		return errorMessage.isDisplayed();
	}

}
