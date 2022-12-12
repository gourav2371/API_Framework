package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig
{
	Properties propertyObject;
	
	public ReadConfig()
	{
		File propertyFilePath = new File(System.getProperty("user.dir")+"\\resources\\data.properties");
		FileInputStream streamObj = null;
		propertyObject = new Properties();
		try {
			streamObj = new FileInputStream(propertyFilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			propertyObject.load(streamObj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getBaseURL()
	{
		return  propertyObject.getProperty("baseUrl");
	}
	
	public String browserName()
	{
		return   propertyObject.getProperty("browser");
	}
	
	public String sheetForLogin()
	{
		return   propertyObject.getProperty("sheetForLogin");
	}
	
	public String sheetForAddPatient()
	{
		return   propertyObject.getProperty("sheetForAddNewPatient");
	}
	
}
