package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import utilities.ExcelUtil;

public class MultipleProductDataDriven_TestCase extends BaseTest{

	@DataProvider(name="productdata")
	
	public Object[][] getPrductData() throws IOException {
		
		String filepath= "src/test/resources/TestData.xlsx";
		return ExcelUtil.getExcelData(filepath, "Products");
			}
	@Test(dataProvider="productdata")
	public void searchMultipleProducts(String productName) throws InterruptedException {
		
		HomePage hp= new HomePage(driver);
		hp.searchProducts(productName);
		
		driver.findElement(By.xpath("//*[@title='Flipkart']")).click();
	}
}
