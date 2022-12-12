package AlertsOrPopUpsWindowsHandle;

import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		for(int i=0;i<5;i++)
		{
			driver.findElement(By.id("newWindowBtn")).click();
		}
		
		String parentWindow = driver.getWindowHandle();
		
		Set<String> handles = driver.getWindowHandles();
		
		System.out.println(handles.size());
		int counter=0;
		HashMap<Integer,String> map = new HashMap();
		for(String handle : handles)
		{
			if(!handle.equals(parentWindow)) {
				counter++;
				map.put(counter,handle);
			}
		}
		
		String windowSecond = map.get(2);
		driver.switchTo().window(windowSecond).close();
	}
}
