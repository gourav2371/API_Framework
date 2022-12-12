package gsh.registry;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LoginPageObjects;
import pageObjects.MainPageAddPatientObjects;

public class SessionTimeOut extends Base
{
	WebDriver driver;
	LoginPageObjects loginPageObjects;
	@BeforeTest
	private void setUp() throws IOException
	{
		loginPageObjects = new LoginPageObjects(driver);
		loginPageObjects.username().sendKeys("gourav@metamagics.com");
		loginPageObjects.password().sendKeys("Gourav237");
		loginPageObjects.submit().click();
	}
	
	@Test
	public void sessionTimeOutTest()
	{
		MainPageAddPatientObjects object = new MainPageAddPatientObjects(driver);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMinutes(16));
		
		wait.until(ExpectedConditions.visibilityOf(object.sessionTimeOut())).click();
		
		//Assert.assertEquals(propertyObject.get("baseUrl"), driver.getCurrentUrl());
	}
}