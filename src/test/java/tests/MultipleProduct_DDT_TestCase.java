package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import utilities.ExcelUtil;

public class MultipleProduct_DDT_TestCase extends BaseTest {
	
	@DataProvider(name="productname")
	
	public Object[][] getProductNames() throws IOException{
		
		String filepath= "src/test/resources/TestData2.xlsx";
		return ExcelUtil.getExcelData(filepath, "Products");
				
	}
    @Test(dataProvider="productname")
 	public void searchProducts(String productName) throws InterruptedException {
		
		HomePage hp= new HomePage(driver);
		hp.searchProducts(productName);
		
		driver.findElement(By.xpath("//*[@title='Flipkart']")).click();
	}
}
