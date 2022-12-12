package gsh.registry;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadConfig;

public class Base
{
	public WebDriver driver;
	
	WebDriverWait wait;
	ReadConfig propertyObject = new ReadConfig();
	
	@BeforeTest
	public void initialiser() throws IOException
	{
		String browserName = System.getProperties().getProperty("broswer",propertyObject.browserName()).toString();
		
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if(browserName.equals("edge"))
		{
			//WebDriverManager.edgedriver().setup();
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Dell\\Downloads\\geckodriver.exe");
			driver = new EdgeDriver();
		}
		if(browserName.equals("firefox"))
		{
			//WebDriverManager.firefoxdriver().driverVersion("0.30.0").setup();
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Dell\\Downloads\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.navigate().to(propertyObject.getBaseURL());
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}
	
	/*
	 * @AfterClass public void TearDown() { driver.close(); }
	 */
}
