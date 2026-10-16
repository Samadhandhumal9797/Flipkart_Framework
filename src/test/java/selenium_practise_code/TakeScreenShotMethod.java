package selenium_practise_code;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;

public class TakeScreenShotMethod extends BaseTest{

	@Test
	public void screenshotTest() throws IOException {
		
	try {	HomePage hp= new HomePage(driver);
		String title = driver.getTitle();
		
		System.out.println(title);
		
		Assert.assertEquals(title, "flipkart");
		}
	
	catch(AssertionError e) {
		
		
		//taking the Driver from BaseClass
		TakesScreenshot ts= (TakesScreenshot)BaseTest.driver;
		
		//taking screenshot of current page
		File source= ts.getScreenshotAs(OutputType.FILE);
		
		//creating location
		
		File destination= new File("./screenshots" + ".png");
		
		FileHandler.copy(source, destination);
		
		System.out.println("Screenshot taken");
		
		throw e; }
	}
}

