package listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;

public class TestListeners implements ITestListener {

	public void onTestFailure(ITestResult result) {
		
		
		//Getting driver from BaseTest
		TakesScreenshot ts= (TakesScreenshot) BaseTest.driver;
		
		
		//Taking Screenshot
		File source= ts.getScreenshotAs(OutputType.FILE);
		
		
		//Creating location for screenshot
		File destination= new File("./screenshots/"+result.getName()+ ".png");
		
		 try {

	            FileHandler.copy(source, destination);

	            System.out.println(
	                    "Screenshot saved at: "
	                    + destination.getAbsolutePath()
	            );

	        } catch (IOException e) {

	            e.printStackTrace();
	        }
	}
    
    
}