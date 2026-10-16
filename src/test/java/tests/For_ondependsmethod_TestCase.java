package tests;

import org.testng.annotations.Test;

import base.BaseTest;

public class For_ondependsmethod_TestCase extends BaseTest{
	
	@Test 
	public void loginTest() {
		System.out.println("Login Successfull");
     }
	@Test (dependsOnMethods="loginTest")
	public void searchProduct() {
		System.out.println("Product visible");
		
	}
	@Test (dependsOnMethods="searchProduct")
	public void logoutTest() {
		System.out.println("logout successfull");
	}

}
