package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshots
{
	
	public String getScreenshot(String methodName, WebDriver driver) throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		
		String destinationFile = System.getProperty("user.dir")+"\\FailedTestsScreenshots\\"+methodName+".jpeg";
		
		File destination  = new File(destinationFile);
		
		FileUtils.copyFile(sourceFile, destination);
		
		return destinationFile;
	}
}