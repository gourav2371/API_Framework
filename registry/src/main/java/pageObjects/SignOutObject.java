package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignOutObject
{
	WebDriver driver;
	public SignOutObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver,this);
	}
	
	@FindBy(id="signoutOption")
	WebElement signOutMenuObj;
	
	public WebElement signOutMenu()
	{
		return signOutMenuObj;
	}
	
	@FindBy(id="signoutId")
	WebElement signoutOptionObj;
	
	public WebElement signoutIdOption()
	{
		return signoutOptionObj;
	}
	
	
}
