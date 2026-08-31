package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.SearchPage;

public class ScrollToElement_TestCase extends BaseTest {
	
	@Test
	public void verifyScrollingToFeedback() throws InterruptedException {
		
		HomePage hp= new HomePage(driver);
		hp.searchProducts("samsung");
		
		WebElement feedback= driver.findElement(By.xpath("//span[normalize-space()='Did you find what you were looking for?']"));
		
		JavascriptExecutor js=  (JavascriptExecutor)driver;  // JavascriptExcutor is interface not class that's why we are declaring like this
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", feedback);
		
		SearchPage sp= new SearchPage(driver);
		sp.clickYesButton();
		
		boolean result= sp.verifySubmitButton();
		Assert.assertEquals(result, true);
		
		
	}

}
