package question;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewTest {
 WebDriver driver;
 Actions action;
	@Test(priority=0)
	public void OpenChrome() {
	System.setProperty("webdriver.chrome.driver", "D://Selenium//drivers//chromedriver.exe");

	}

	@Test(priority=1)
	public void goToDista() {
		driver= new ChromeDriver();
		action= new Actions(driver);
		driver.get("https://www.dista.ai/");
		driver.manage().window().maximize();
		
	}
	@Test(priority=2)
	public void gotoproducts(){
		WebElement menu_product = driver.findElement(By.linkText("Products"));
		action.moveToElement(menu_product).perform();
		
		driver.findElement(By.linkText("Dista Food")).click();				
	}
	
	@Test(priority=3)
	public void goToDistaFood(){
		
		//new WebDriverWait(driver, 30).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
		
		
		WebElement total_branches = driver.findElement(By.xpath("//div[text()='Branches']/../div/span[2]"));
		//WebElement element= driver.findElement(By.xpath("/html[1]/body[1]"));
		//action.moveToElement(total_branches).perform();
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", total_branches);
		
		JavascriptExecutor js = (JavascriptExecutor) driver; js.executeScript("window.scrollBy(0,350)", "");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Total Branches: "+total_branches.getText());
		
	}
	
	@Test(priority=4)
	public void closeBrowser(){
		driver.quit();
	
	}
	
	}

