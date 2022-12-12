package gsh.registry;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LoginPageObjects;
import pageObjects.MainPageAddPatientObjects;
import pageObjects.MiscObjects;
import pageObjects.SignOutObject;
import pageObjectsUtility.DatePicker;
import utility.ExcelReader;

public class AddNewPatient extends Base
{
	
	MainPageAddPatientObjects mainpageobj = null;
	DatePicker datepickerobj = null;
	MiscObjects miscObj = null;
	LoginPageObjects loginPageObjects;
	SignOutObject signoutObj;
	
	@BeforeClass
	public void setUp() throws IOException
	{
		mainpageobj = new MainPageAddPatientObjects(driver);
		datepickerobj = new DatePicker(driver);
		miscObj = new MiscObjects(driver);
		
		loginPageObjects = new LoginPageObjects(driver);
		loginPageObjects.username().sendKeys("gourav@metamagics.com");
		loginPageObjects.password().sendKeys("Gourav237");
		loginPageObjects.submit().click();
	}
	
	@Test(dataProvider="AddPatient", groups={"group1"})
	public void AddNewPatientValidation(String testcase, String MRNO, String fname, String lname, String bg,
			String organ, String email, String refdoctor, String gender, String typeOfPatient, String evalYear, 
			String evalmonth, String evalDay,String dobYear, String dobMonth, String dobDay)
	{
		wait.until(ExpectedConditions.visibilityOf(mainpageobj.addNewPatient())).click();
		wait.until(ExpectedConditions.invisibilityOf(miscObj.processingGif()));
		wait.until(ExpectedConditions.visibilityOf(mainpageobj.mrNo())).click();
		
		mainpageobj.mrNo().sendKeys(MRNO);
		mainpageobj.fName().sendKeys(fname);
		mainpageobj.lname().sendKeys(lname);
		mainpageobj.email().sendKeys(email);
		mainpageobj.organInfo().sendKeys(organ);
		mainpageobj.typeOfPatient(typeOfPatient);
		
		if(typeOfPatient.equals("Under evaluation"))
		{
			mainpageobj.evalDate().click();
		}
		else
		{
			mainpageobj.waitListDate().click();
		}
		
		datepickerobj.datepickerYear(evalYear);
		datepickerobj.datepickerMonth(evalmonth);
		datepickerobj.datepickerDate(evalDay).click();
		
		mainpageobj.dobInfo().click();
		datepickerobj.datepickerYear(dobYear);
		datepickerobj.datepickerMonth(dobMonth);
		datepickerobj.datepickerDate(dobDay).click();
		
		mainpageobj.bloodGroup().sendKeys(bg);
		mainpageobj.gender().sendKeys(gender);
		mainpageobj.refDoctor().sendKeys(refdoctor);
		
		//mainpageobj.diagnosis().sendKeys("Chronic Kidney Disease");
		
		if(testcase.equals("Valid"))
		{
			Assert.assertTrue(!mainpageobj.savePatientBtn().isEnabled());
			mainpageobj.cancelBtn().click();
			wait.until(ExpectedConditions.invisibilityOf(miscObj.processingGif()));
		}
		else if(testcase.equals("InValid"))
		{
			Assert.assertTrue(!mainpageobj.savePatientBtn().isEnabled());
			mainpageobj.cancelBtn().click();
			wait.until(ExpectedConditions.invisibilityOf(miscObj.processingGif()));
		}
	}
	
	@DataProvider(name="AddPatient")
	public Object[][] provider() throws IOException
	{
		ExcelReader reader = new ExcelReader();
		XSSFSheet sheet = reader.getSheet(propertyObject.sheetForAddPatient());
		Object[][] data = reader.getDataFromSheet(sheet);
		System.out.println(data.length);
		return data;
	}
	
	@AfterClass
	public void tearDown()
	{
		signoutObj = new SignOutObject(driver);
		signoutObj.signOutMenu().click();
		signoutObj.signoutIdOption().click();
	}
}