package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {                                                             //driver setup
	
	public static WebDriver driver;
   
	@Parameters("browser")
	@BeforeClass
	public void setup(@Optional("chrome")String browser) {                                   // launch browser
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			driver= new ChromeDriver();
							
		}
		
		else if(browser.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();
			
			}
		
		else {
			System.out.println("Invalid Browser");
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//*[@class='b3wTlE']")).click();
	}
	
	@AfterClass
	public void tearDown() {                                                     //close browser
	//WebElement flipkart= driver.findElement(By.xpath("//*[@title='Flipkart']"));
		//flipkart.click();                                                   
		
		driver.quit(); 
	}  
}
