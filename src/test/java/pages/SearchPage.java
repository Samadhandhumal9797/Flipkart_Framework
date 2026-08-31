package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[starts-with(@href,'/apple-iphone-16-white-128-gb')]")
	WebElement iphone;
	
	@FindBy(xpath="//span[normalize-space()='Yes']")
	WebElement buttonYes;
	
	@FindBy(xpath="//button[normalize-space()='Submit']")
	WebElement buttonSubmit;
	
	@FindBy(xpath="//*[contains(normalize-space(),'Mixer')][3]")
	WebElement btnMixer;
	
	//@FindBy(xpath="//*[starts-with(@title,'Fastrack Jupiter S3 1.83') and @rel='noopener noreferrer'] ")
	//List<WebElement> smartwatches;
	
	public boolean verifySubmitButton() {
		return buttonSubmit.isDisplayed();
	}
	
	public void clickYesButton() {
		buttonYes.click();
	}
	
	public void selectProduct() {
		
		// String parentWindow = driver.getWindowHandle();
		 
		iphone.click();
		
		for (String window : driver.getWindowHandles()) {
		    driver.switchTo().window(window);
		}
			}
	
	public void selectMixer() {
		
		btnMixer.click();
		
		for (String window1 : driver.getWindowHandles()) {
			driver.switchTo().window(window1);
		}
	}
	//public void selectSmartWatch() {                                                 //Important to click single product from same Xpaths
		//System.out.println("Number of samrtwatches"+ smartwatches.size());
		//smartwatches.get(0).click();
	}
		
	



