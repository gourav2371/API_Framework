package pageObjects;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class MainPageLeftPane
{
	WebDriver driver;
	public MainPageLeftPane(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath="//ul[@class='firstLevel navbarlinksDiv']/li/div/a")
	List<WebElement> leftPaneObject;
	
	public WebElement menuOptions(String optionName)
	{
		System.out.println(leftPaneObject);
		WebElement link = leftPaneObject.stream().filter(option->option.getText().equals(optionName)).findAny().get();
		System.out.println(link.getText());
		return link;
	}
	
	@FindBy(id="test_mgmt_listed")
	WebElement testMgmtWaitlistedPatientsObj;
	
	public WebElement testMgmtWaitlistedPatients()
	{
		return testMgmtWaitlistedPatientsObj;
	}
	
	@FindBy(xpath="//table[@id='wtlisttestmgmtPatients']")
	WebElement waitlistedPatientListObj;
	
	
	public WebElement waitlistedPatientList(String mrno) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='wtlisttestmgmtPatients']")));
		System.out.println("Before headers"+waitlistedPatientListObj);
		List<WebElement> headers = waitlistedPatientListObj.findElements(By.tagName("th"));
		
		List<WebElement> values = null;
		for(int i=0;i<headers.size();i++)
		{
			System.out.println("Index is"+headers.get(i).getText());
			if(headers.get(i).getText().equals("YNH ID"))
			{
				Thread.sleep(5000);
				values= waitlistedPatientListObj.findElements(By.xpath(".//tbody/tr/td["+(i+1)+"]"));
				break;
			}
		}
		return values.stream().filter(value->value.getText().equals(mrno)).findFirst().get();
	}
	
	@FindBy(xpath="//div[@ng-show='test.isTestAllocated && test.stageCode >= 1']")
	List<WebElement> selectedAndNonSelectedTestsObj;
	
	public int selectedTests()
	{
		int assignedTest=0;
		
		for(WebElement selectedTest: selectedAndNonSelectedTestsObj)
		{
			if(selectedTest.getText()!="" && selectedTest.getText()!="-")
			{
				if(selectedTest.getText().equals("Test Assigned")) {
					assignedTest++;
				}
			}
		}
		
		return assignedTest;
	}
	
	@FindBy(xpath="//div[@id='patInfo']/div[2]/table[1]/tbody/tr/td[1]/p/span")
	WebElement countOfTestsObj;
	
	public String AssignedTests()
	{
		return countOfTestsObj.getText();
	}
}