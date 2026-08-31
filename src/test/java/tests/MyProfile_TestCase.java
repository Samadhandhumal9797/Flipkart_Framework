package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class MyProfile_TestCase extends BaseTest{

	@Test
	public void myProfileVerification() {
		
		HomePage hp= new HomePage(driver);
		hp.clickLoginDropdown();
		
		hp.clickMyProfile();
		
		LoginPage lp= new LoginPage(driver);
		lp.clickRequestOtp();
		
		boolean result= lp.errorMessagedisplayed();
		Assert.assertEquals(result, true);
	}
}
