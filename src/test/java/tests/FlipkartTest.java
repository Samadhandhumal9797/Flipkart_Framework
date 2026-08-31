package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchPage;

public class FlipkartTest extends BaseTest{
	
	
    @DataProvider(name= "productData")
    public Object [][] getProductData() {
    	return new Object[][] {
    		
    		{"Iphone"},
           /* {"Samsung"},
    		{"Laptop"},
    		{"Watch"}*/};}
    	
   // @Parameters("productName") 
	@Test(dataProvider="productData")
	public void searchProductsTest(String productName) throws InterruptedException {              //Most Important even if we call methods we need test case name and a new mehod for verification***
		
		HomePage hp= new HomePage(driver);
		
		hp.searchProducts(productName);
		
		
		SearchPage sp= new SearchPage(driver);
		sp.selectProduct();
		
		ProductPage pp= new ProductPage(driver); 
		
		   pp.clickAddToCart();
			
			Thread.sleep(3000);
			
			pp.clickCart();
			
		CartPage cp= new CartPage(driver);
		boolean result= cp.isProductAdded();
		Assert.assertTrue(result);
			
		
	
		
	}
	
	
}
