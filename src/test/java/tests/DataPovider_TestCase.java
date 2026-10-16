package tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;

public class DataPovider_TestCase extends BaseTest{
	
	@DataProvider (name="phoneNames")
	public Object[][] getphoneNames() {
		return new Object[][] {
			{"Vivo"},
			{"Oppo"},
			{"Realme"},
			{"Pocco"}
		};
	}

	@Test (dataProvider="phoneNames")
	public void searchFourProducts(String product) throws InterruptedException{
		
		HomePage hp= new HomePage(driver);
		hp.searchProducts(product);
		
		driver.findElement(By.xpath("//*[@title='Flipkart']")).click();
		
		
		System.out.println("Products:" + product);
	 }
	

}

