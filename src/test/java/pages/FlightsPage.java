package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightsPage {

	WebDriver driver;
	
	public FlightsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div[@class='css-g5y9jx r-1awozwy r-13awgt0 r-18u37iz r-1cmwbt1 r-1h0z5md']")
	WebElement searchInputbox;
	
	
	@FindBy(xpath="//input[@placeholder='Search origin city/airport']")
	WebElement searchBox;
	
	@FindBy(xpath="//*[normalize-space()='Chatrapati Shivaji International Airport, IN']")
	WebElement mumbaiAirport;
	
	@FindBy(xpath="//div[@class='css-146c3p1 r-dnmrzs r-1udh08x r-1udbk01 r-3s2u2q r-1iln25a']")
	WebElement searchFlights;
	
	@FindBy(xpath="\"//*[normalize-space()='Please select destination city']\"")
	WebElement errorMessage;
	
	
	public void clickSearchbox() {
		searchInputbox.click();
	}
	
	public void writeFromDestination(String destinationName) {
		searchBox.sendKeys(destinationName);
	}
	
	public void selectMumbai() {
		mumbaiAirport.click();
	}
	
	public void clickOnSearchFlights() {
		searchFlights.click();
	}
	
	public boolean errorMessagePopup() {
		return errorMessage.isDisplayed();
	}
	
	
}
