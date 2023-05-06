package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tajlogin {
	WebDriver driver;
	    @BeforeTest
	    @Parameters("browser")
		public void setup(String browser) throws InterruptedException{
	    		ChromeOptions options=new ChromeOptions();
	    		options.addArguments("--disable-notifications");
	    		FirefoxOptions opt=new FirefoxOptions();
	    		opt.addPreference("dom.webnotifications.enabled", false);
	    		
				if(browser.equalsIgnoreCase("firefox")){
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver(opt);
				}
				else if(browser.equalsIgnoreCase("chrome")){
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver(options);
				}
		}
		
		@Test
		public void testParameterWithXML() throws InterruptedException{
		String Username="test@upswing.global";
		String Password="Test@123";
		driver.get("https://beta.admin.taj.upswing.global/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder='Username*']")).sendKeys(Username);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50000));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Password*']")).sendKeys(Password);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//ion-button[text()='Sign In ']")).click();
		Thread.sleep(30000);
//		driver.findElement(By.xpath("//span[text()='ALLOW']")).click();
		driver.quit();
	}
}
