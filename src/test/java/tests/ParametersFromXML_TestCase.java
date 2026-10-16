package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;

public class ParametersFromXML_TestCase extends BaseTest {
	
	@Parameters("productName")
	@Test
	public void searchPhonesFromXML(String productName) throws InterruptedException {
		
		HomePage hp= new HomePage(driver);
		hp.searchProducts(productName);
		
		driver.findElement(By.xpath("//*[@title='Flipkart']")).click();
	}

}
