package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects
{
	WebDriver driver;
	public LoginPageObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(css="#loginName")
	WebElement usernameObj;
	
	@FindBy(xpath="//input[@id='loginPwd']")
	WebElement passwordObj;
	
	@FindBy(id="SignIn")
	WebElement signInBtnObj;
	
	public WebElement username()
	{
		return usernameObj;
	}
	
	public WebElement password()
	{
		return passwordObj;
	}
	
	public WebElement submit()
	{
		return signInBtnObj;
	}
}