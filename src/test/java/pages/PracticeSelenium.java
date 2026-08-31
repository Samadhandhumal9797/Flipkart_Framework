package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PracticeSelenium {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Thread.sleep(Duration.ofSeconds(5));
		
		WebElement loginButton= driver.findElement(By.xpath("//*[@title='Login']"));
		
		Actions Action= new Actions(driver);
		Action.moveToElement(loginButton).perform();
		
		List<WebElement> dropdownOptions= driver.findElements(By.xpath("//*[@class='CfNfim']//*[normalize-space(text())]"));
		
		for(int i=0; i<dropdownOptions.size(); i++) {
			System.out.println(i + " --> [" + dropdownOptions.get(i).getText() + "]");
		}
		
		driver.quit();

	}

}
