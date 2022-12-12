package gsh.registry;

import java.io.IOException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LoginPageObjects;
import pageObjects.MainPageLeftPane;
import pageObjects.MiscObjects;

public class UnderEvalTestMgmt extends Base
{
	LoginPageObjects loginPageObjects = null;
	MiscObjects miscObj = null;
	
	@BeforeClass
	public void setUp() throws IOException
	{
		 loginPageObjects = new LoginPageObjects(driver);
		 miscObj = new MiscObjects(driver);
		 loginPageObjects.username().sendKeys("gourav@metamagics.com");
		 loginPageObjects.password().sendKeys("Gourav237");
		 loginPageObjects.submit().click();
		 wait.until(ExpectedConditions.invisibilityOf(miscObj.processingGif()));
	}
	
	@Test( groups={"group1"})
	public void testAssgined() throws InterruptedException
	{
		MainPageLeftPane pane = new MainPageLeftPane(driver);
	
		pane.menuOptions("Test Management").click();
		wait.until(ExpectedConditions.invisibilityOf(miscObj.processingGif()));
		
		pane.testMgmtWaitlistedPatients().click();
		wait.until(ExpectedConditions.invisibilityOf(miscObj.processingGif()));
		
		if(pane.testMgmtWaitlistedPatients().isDisplayed())
		{
			pane.waitlistedPatientList("MRNO1111").click();
			wait.until(ExpectedConditions.invisibilityOf(miscObj.processingGif()));
			Thread.sleep(5000);
		}
		
		Assert.assertEquals(Integer.parseInt(pane.AssignedTests()), pane.selectedTests());
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
}