package gsh.registry;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class DummyTest extends Base{
	
	@Test(groups={"Regression1"})
	public void sampleTest()
	{
		System.out.println("Dummy test run successfully");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
