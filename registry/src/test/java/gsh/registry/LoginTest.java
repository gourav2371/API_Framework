package gsh.registry;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LoginPageObjects;
import pageObjects.MiscObjects;
import pageObjects.SignOutObject;
import utility.ExcelReader;

public class LoginTest extends Base
{
	SignOutObject signoutObj;
	MiscObjects miscObj;
	LoginPageObjects loginObj;
	
	@BeforeClass
	public void setUp() throws IOException
	{
		loginObj = new LoginPageObjects(driver);
		miscObj = new MiscObjects(driver);
	}
	
	@Test(dataProvider="loginData")
	public void login(String testcase, String username, String password, String expectedResult)
	{
		loginObj.username().sendKeys(username);
		loginObj.password().sendKeys(password);
		loginObj.submit().click();
		
		wait.until(ExpectedConditions.invisibilityOf(miscObj.processingGif()));

		String actualResult=driver.getCurrentUrl();
		
		if(testcase.equals("Valid"))
		{
			Assert.assertEquals(expectedResult, actualResult);
			
			signoutObj = new SignOutObject(driver);
			signoutObj.signOutMenu().click();
			signoutObj.signoutIdOption().click();
		}
		else if(testcase.equals("Invalid"))
		{
			Assert.assertEquals(expectedResult, actualResult);
		}
	}
	
	@DataProvider(name="loginData")
	public Object[][] provider() throws IOException
	{
		ExcelReader reader = new ExcelReader();
		XSSFSheet sheet = reader.getSheet(propertyObject.sheetForLogin());
		Object[][] data = reader.getDataFromSheet(sheet);
		System.out.println(data.length);
		return data;
	}
	
}