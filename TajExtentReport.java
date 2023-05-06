package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TajExtentReport {
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
	// TODO Auto-generated method stub
	ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("LoginExtentReports.html");
    extent.attachReporter(spark);
    String Username="test@upswing.global";
	String Password="Test@123";
    ExtentTest test=extent.createTest("Login Scenario");
	driver.get("https://beta.admin.taj.upswing.global/");
	test.pass("Naviagted to beta.admin.taj.upswing.global");
	driver.manage().window().maximize();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@placeholder='Username*']")).sendKeys(Username);
	Thread.sleep(5000);
	test.pass("Entered mail id in Username field");
	driver.findElement(By.xpath("//input[@placeholder='Password*']")).sendKeys(Password);
	Thread.sleep(5000);
	test.pass("Entered Password in Password field");
	driver.findElement(By.xpath("//ion-button[text()='Sign In ']")).click();
	Thread.sleep(5000);
	test.pass("Clicked On Sign-in button.");
	//driver.findElement(By.xpath("//span[text()='ALLOW']")).click();
	Thread.sleep(9000);
	test.pass("Clicked On Allow.");
	test.pass("Test Completed");
	test.pass("Closes the browser");
	driver.quit();
	extent.flush();
}
	
	
}
