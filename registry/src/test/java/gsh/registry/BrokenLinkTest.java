package gsh.registry;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.BrokenLinks;

public class BrokenLinkTest extends Base
{
	@Test
	public void getBrokenLinks() throws IOException
	{
		BrokenLinks links = new BrokenLinks(driver);
		URL url;
		HttpURLConnection con;
		List<WebElement>linksOnPage = links.allLinks();
		for(WebElement link : linksOnPage)
		{
			String urllinkforConnection = link.getAttribute("href");
			url = new URL(urllinkforConnection);
			 con = (HttpURLConnection) url.openConnection();
			 con.connect();
			 if(con.getResponseCode() == 200)
			 {
				 System.out.println("Active Links");
			 }
			 else
			 {
				 System.out.println("Not  a valid url");
			 }
		}
	}
}