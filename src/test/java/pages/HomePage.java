package pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	
	// see this code is required in all the object pages or not?
	
			public HomePage(WebDriver driver) {
				
				this.driver= driver;
				
				PageFactory.initElements(driver, this);
			}
	
		@FindBy(xpath="//*[@name='q']") 
		WebElement searchBox;
		
		// select My profile from homePage
		@FindBy(xpath= "//*[@alt='My Profile']")
		WebElement myProfile;
		
	//	@FindBy(xpath="//*[@type= 'submit']")
		//WebElement searchButton;
	
		//mouse hover on dropdown
		@FindBy(xpath="(//img[@alt='Chevron'])[1]")
		WebElement loginDropdown;
		
		//flights webelement
		@FindBy(xpath="//*[@style='display: flex; position: relative; width: 29.3333px; height: 22px;']")
		WebElement btnFlight;
		
		
		public void searchProducts(String productName) throws InterruptedException {
			
			searchBox.clear();
			Thread.sleep(Duration.ofSeconds(2));
			searchBox.sendKeys(productName);
			searchBox.sendKeys(Keys.ENTER);
		//	searchButton.click();
		}
			
		public void clickMyProfile() {
			myProfile.click();
		
					
		}
		
		public void clickLoginDropdown () {
			loginDropdown.click();
		}
		
		public void clickFlight() {
			btnFlight.click();
		}
}
