package stepDefinitions;

import java.io.IOException;

import gsh.registry.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.LoginPageObjects;
import pageObjects.MiscObjects;
import pageObjects.SignOutObject;

public class LoginSteps extends Base
{
		SignOutObject signoutObj;
		MiscObjects miscObj;
		LoginPageObjects loginObj;
		
		@Given("Browser launched and navigated to url")
		public void browser_launched_and_navigated_to_url() throws IOException {
			initialiser();
			loginObj = new LoginPageObjects(driver);
			miscObj = new MiscObjects(driver);
		}

		@When("User enter username as {string} and password as {string}")
		public void user_enter_username_as_and_password_as(String username, String password) {
			loginObj.username().sendKeys(username);
			loginObj.password().sendKeys(password);
		}

		@When("Click login button")
		public void click_login_button() {
			loginObj.submit().click();
		}

		@Then("for testcase {string} validate urls")
		public void for_testcase_validate_urls(String testcase) {
			String expectedResult = "https://ynhh.gridsensehealth.com/GS_UI/gridsense/MasterIndex.html#/home-coordinator";
			String actualResult=driver.getCurrentUrl();
			
			if(testcase.equals("Valid"))
			{
				Assert.assertEquals(expectedResult, actualResult);
				
				signoutObj = new SignOutObject(driver);
				signoutObj.signOutMenu().click();
				signoutObj.signoutIdOption().click();
			}
			else if(testcase.equals("Invalid"))
			{
				Assert.assertEquals(expectedResult, actualResult);
			}
		}
}
