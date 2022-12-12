package pageObjectsUtility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DatePicker
{
	WebDriver driver;
	Select select;
	public DatePicker(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="ui-datepicker-div")
	WebElement datepickerObject;
	
	public WebElement datepicker()
	{
		return datepickerObject;
	}
	
	@FindBy(className="ui-datepicker-title")
	WebElement datepickertitleObject;
	
	public WebElement datepickerTitle()
	{
		return datepickertitleObject;
	}
	
	@FindBy(className="ui-datepicker-month")
	WebElement datepickerMonthObject;
	
	public Select datepickerMonth(String dobMonth)
	{
		select = new Select(datepickerMonthObject);
		select.selectByVisibleText(dobMonth);
		return select;
	}
	
	@FindBy(className="ui-datepicker-year")
	WebElement datepickerYearObject;
	
	public Select datepickerYear(String evalYear)
	{
		select = new Select(datepickerYearObject);
		select.selectByValue(evalYear);
		return select;
	}
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']/tbody/tr/td/a")
	List<WebElement> datepickerDateObject;
	
	public WebElement datepickerDate(String evalDay)
	{
		WebElement dateValues = null;
		
		for(WebElement dateValue : datepickerDateObject)
		{
			if(dateValue.getText().equals(evalDay))
			{
				dateValues = dateValue;
				break;
			}
		}
		return dateValues;
	}
}