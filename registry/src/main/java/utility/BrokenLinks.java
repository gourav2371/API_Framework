package utility;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gsh.registry.Base;

public class BrokenLinks extends Base
{
	WebDriver driver;
	public BrokenLinks(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName="a")
	List<WebElement> allLinksObj;
	
	public List<WebElement> allLinks()
	{
		return allLinksObj;
	}
}
