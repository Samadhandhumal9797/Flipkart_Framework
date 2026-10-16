package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	public static ExtentReports getReportInstance() {    // This method creates report location

        String path = System.getProperty("user.dir")
                + "/reports/ExtentReport.html";

        ExtentSparkReporter spark =                      // here we are creating reporter and telling it to use  given/ above path
                new ExtentSparkReporter(path);

        
        // Report configuration
        spark.config().setDocumentTitle("Automation Test Report");
        spark.config().setReportName("Functional Testing");
        spark.config().setTheme(Theme.DARK);
        //This is not much required part
        
        
        ExtentReports extent = new ExtentReports();     //creating report object

        extent.attachReporter(spark);                   //telling to extent to use ExtentSparkReporter to generate the report

        
        // System information
        extent.setSystemInfo("Tester", "Pavan");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Browser", "Edge");
        extent.setSystemInfo("Operating System",
                System.getProperty("os.name"));
        extent.setSystemInfo("Java Version",
                System.getProperty("java.version"));
        //Same with this part of code= not so important
        
        
        
        return extent;
    }
}
