package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Features", glue="stepDefinitions")
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
