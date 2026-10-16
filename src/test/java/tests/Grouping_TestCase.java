package tests;

import org.testng.annotations.Test;

import base.BaseTest;

public class Grouping_TestCase extends BaseTest {
	
	@Test (groups="sanity")
	public void loginTest() {
		System.out.println("Login Successfull");
     }
	@Test (groups="regression")
	public void searchProduct() {
		System.out.println("Product visible");
		
	}
	@Test (groups="sanity")
	public void logoutTest() {
		System.out.println("logout successfull");
	}

}
