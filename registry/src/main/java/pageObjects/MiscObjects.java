package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MiscObjects
{
	WebDriver driver;
	public MiscObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath="//div[@id='loadingImageDiv']")
	WebElement processingGifObject;
	
	public WebElement processingGif()
	{
		return processingGifObject;
	}
}
