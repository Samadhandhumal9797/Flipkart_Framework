package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class MyProfile_TestCase extends BaseTest{

	@Test(priority=1, groups="regression")
	public void LoginTest() {
		System.out.println("Login Successfull");	}
	
	@Test(priority=1, groups="regression")
	public void myProfileVerification() {
		
		HomePage hp= new HomePage(driver);
		hp.clickLoginDropdown();
		
		hp.clickMyProfile();
		
		LoginPage lp= new LoginPage(driver);
		lp.clickRequestOtp();
		
		boolean result= lp.errorMessagedisplayed();
		Assert.assertEquals(result, true);
		
	    System.out.println("Profile Verified");
	}
	
	@Test(priority=3, groups="regression")
	public void LogoutTest() {
		System.out.print("Logout Test Started");
		
		Assert.assertTrue(false);
	}
}
