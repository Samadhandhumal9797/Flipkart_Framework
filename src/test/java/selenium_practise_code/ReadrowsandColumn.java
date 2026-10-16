package selenium_practise_code;

	import java.time.Duration;
	import java.util.Set;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	public class ReadrowsandColumn {

		WebDriver driver;
		@Test
		public void launchSomething() throws InterruptedException {
			
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://demoqa.com/browser-windows");
			
			driver.findElement(By.xpath("//*[normalize-space()='Elements']")).click();
			
			driver.findElement(By.xpath("//*[@href='/webtables']")).click();
			
			Thread.sleep(Duration.ofSeconds(3));
			
			WebElement cell=driver.findElement(By.xpath("//*[@class='web-tables-wrapper']//tr[1]//td[1]"));
			String cellName=cell.getText();
			System.out.println(cellName);
			
			for(int r=1; r<=3; r++) {
				
				for (int c=1; c<=6; c++) {
					
				String tableData= driver.findElement(By.xpath("//*[@class='web-tables-wrapper']//tr["+r+"]//td["+c+"]")).getText();
				
				System.out.print(tableData + "\t");
				}
				System.out.println(" ");
			}
			
			
			/*String window= driver.getWindowHandle();
			
			driver.switchTo().window(window);
			
			driver.findElement(By.xpath("//button[normalize-space()='New Tab']")).click();
			
			WebElement name=driver.findElement(By.id("sampleHeading"));
			
			boolean result=name.isDisplayed();
			
			Assert.assertTrue(result);
			
			System.out.println("Test Successful"); */
			
			driver.quit();
			
			
		}
	}


