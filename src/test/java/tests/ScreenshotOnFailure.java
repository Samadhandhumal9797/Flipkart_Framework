package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import listeners.TestListeners;
import pages.FlightsPage;
import pages.HomePage;

@Listeners (TestListeners.class)
public class ScreenshotOnFailure extends BaseTest {

	@Test
	public void bookFlight () {
		
		HomePage hp= new HomePage(driver);
		hp.clickFlight();
		
		FlightsPage fp= new FlightsPage(driver);
		fp.clickSearchbox();
		fp.writeFromDestination("Mumbai");
		fp.selectMumbai();
		fp.clickOnSearchFlights();
		
		boolean result=fp.errorMessagePopup();
		
		Assert.assertEquals(result, true);
	}
}
