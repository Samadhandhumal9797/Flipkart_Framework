package listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import utilities.ExtentReportManager;

public class TestListeners implements ITestListener {
	
	//Create ExtentReport instance
	ExtentReports extent = ExtentReportManager.getReportInstance();  //here we are directly calling a method from ExtentReportManager class because method is STATIC
    
	//Represent individual test
	ExtentTest test;                                               //Import it
	
	
	public void onTestStart(ITestResult result) {
		
		//create a test in ExtentReport
		test= extent.createTest(result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		test.pass("Test Passed");
	}
	
    
	public void onTestFailure(ITestResult result) {
		
		
		//Create test for extent report on failure
		test.fail(result.getThrowable());
		
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
	            
	            
	            // to attach screenshot to Extent Report
	            test.addScreenCaptureFromPath(destination.getAbsolutePath());

	        } catch (IOException e) {

	            e.printStackTrace();
	        }
	}
    
	public void onTestSkipped(ITestResult result) {
		test.skip("Test Skipped");
	}
	
	 @Override
	    public void onFinish(org.testng.ITestContext context) {

	        // Generate the HTML report
	        extent.flush();
	 }
	
	
    
}