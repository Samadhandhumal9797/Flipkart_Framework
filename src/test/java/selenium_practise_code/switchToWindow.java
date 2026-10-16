package selenium_practise_code;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class switchToWindow {

    @Test
	public static void windowHandling () throws InterruptedException {
	
	WebDriver driver= new ChromeDriver();
	 
	 driver.get("https://www.flipkart.com/");
	 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	 
	 driver.manage().window().maximize();
	 
	 driver.findElement(By.xpath("//*[@class=\"b3wTlE\"]")).click();
	 driver.findElement(By.xpath("//form[contains(@class,'header-form-search')]//input[@name='q']")).sendKeys("iphone");
	 driver.findElement(By.xpath("//form[contains(@class,'header-form-search')]//input[@name='q']")).sendKeys(Keys.ENTER);
	 driver.findElement(By.xpath("//*[text()='Apple iPhone 17 (Black, 256 GB)']")).click();
	 Thread.sleep(Duration.ofSeconds(3));
	 
	List <String> ids= new ArrayList (driver.getWindowHandles());
	driver.switchTo().window(ids.get(1));
	
	 WebElement price= driver.findElement(By.xpath("//*[text()='Apply offers for maximum savings']"));
     
	 
	 
	 boolean yes= price.isDisplayed();
	 
	Assert.assertTrue(yes);
	 
	
}
	}
