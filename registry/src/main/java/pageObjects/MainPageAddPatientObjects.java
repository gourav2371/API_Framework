package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MainPageAddPatientObjects
{
	WebDriver driver;
	public MainPageAddPatientObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver,this);
	}
	
	@FindBy(id="add_patient")
	WebElement addNewPatientLinkObject;
	
	public WebElement addNewPatient()
	{
		return addNewPatientLinkObject;
	}
	
	@FindBy(id="navLeftPane")
	WebElement leftPaneObject;
	
	public WebElement leftPane()
	{
		return leftPaneObject;
	}
	
	@FindBy(id="pat_uniqueId")
	WebElement mrNoObject;
	
	public WebElement mrNo()
	{
		return mrNoObject;
	}

	@FindBy(id="add_pat_fname")
	WebElement fNameObject;
	
	public WebElement fName()
	{
		return fNameObject;
	}
	
	@FindBy(id="add_pat_lname")
	WebElement lNameObject;
	
	public WebElement lname()
	{
		return lNameObject;
	}
	
	@FindBy(id="add_pat_email")
	WebElement emailObject;
	
	public WebElement email()
	{
		return emailObject;
	}
	
	@FindBy(id="add_pat_organ")
	WebElement organObject;
	
	public WebElement organInfo()
	{
		return organObject;
	}
	
	@FindBy(id="add_pat_type")
	WebElement patientTypeObject;
	
	public WebElement patientType()
	{
		return patientTypeObject;
	}
	
	@FindBy(id="add_pat_refdate")
	WebElement evalDateObject;
	
	public WebElement evalDate()
	{
		return evalDateObject;
	}
	
	@FindBy(id="add_pat_bloodgroup")
	WebElement bloodGroupObject;
	
	public WebElement bloodGroup()
	{
		return bloodGroupObject;
	}
	
	@FindBy(id="add_pat_dob")
	WebElement dobObject;
	
	public WebElement dobInfo()
	{
		return dobObject;
	}
	
	@FindBy(id="add_pat_referring_provider")
	WebElement refDoctorObject;
	
	public WebElement refDoctor()
	{
		return refDoctorObject;
	}
	
	@FindBy(id="add_pat_dialysiscentre")
	WebElement dailyisCenterObject;
	
	public WebElement dailysisCenterInfo()
	{
		return dailyisCenterObject;
	}
	
	@FindBy(id="save_patient")
	WebElement savePatientObject;
	
	public WebElement savePatientBtn()
	{
		return savePatientObject;
	}
	
	@FindBy(id="canceltoreturn")
	WebElement cancelObject;
	
	public WebElement cancelBtn()
	{
		return cancelObject;
	}
	
	@FindBy(id="addpatient")
	WebElement addPatientContainerObj;
	
	public WebElement addPatientContainer()
	{
		return addPatientContainerObj;
	}
	
	@FindBy(xpath="//img[@id='timeOutAlertClose']")
	WebElement sessionTimeOutObject;
	
	public WebElement sessionTimeOut()
	{
		return sessionTimeOutObject;
	}
	
	@FindBy(xpath="//input[@name='patgender']")
	WebElement genderObject;
	
	public WebElement gender()
	{
		return genderObject;
	}
	
	@FindBy(xpath="//input[@name='patpd']")
	WebElement diagnosisObject;
	
	public WebElement diagnosis()
	{
		return diagnosisObject;
	}
	
	@FindBy(id="add_pat_type")
	WebElement typeOfPatientObject;
	
	public void typeOfPatient(String typeOfPatient)
	{
		Select select  = new Select(typeOfPatientObject);
		select.selectByVisibleText(typeOfPatient);
	}
	
	@FindBy(css="#add_pat_waitlistdate")
	WebElement waitListDateObject;
	
	public WebElement waitListDate()
	{
		return waitListDateObject;
	}
	
}
