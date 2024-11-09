package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import objectRepo.LoginPage;
import utils.TestContextSetUp;

public class LoginPageSteps {

	TestContextSetUp testContextSetUp;
	LoginPage login;
	
	public LoginPageSteps(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
	}
	
	@Given("I navigate to skillrary app")
	public void i_navigate_to_skillrary_app() {
		testContextSetUp.driverUtil.navigateToApp(testContextSetUp.property.readFromFile("url"));		
	}

	@And("login to Skillrary as admin")
	public void login_to_skillrary_as_admin() {
		login = testContextSetUp.pom.getLogin();
		login.loginToApp(testContextSetUp.property.readFromFile("username"), 
				testContextSetUp.property.readFromFile("password"));
	}
}
