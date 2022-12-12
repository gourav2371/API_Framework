package AlertsOrPopUpsWindowsHandle;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PopUpHandles {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/alerts");
		driver.findElement(By.id("alertButton")).click();
		try {
			Alert alertbox = driver.switchTo().alert();
			System.out.println(alertbox.getText());
			alertbox.accept();
		}
		catch(NoAlertPresentException e) {
			System.out.println("No Alert present");
		}
	}
}