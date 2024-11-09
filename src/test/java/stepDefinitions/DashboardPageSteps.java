package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import objectRepo.DashboardPage;
import utils.TestContextSetUp;

public class DashboardPageSteps {

	TestContextSetUp testContextSetUp;
	DashboardPage dashboard;

	public DashboardPageSteps(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
	}
	
	@When("I enter category page")
	public void i_enter_category_page() {
		dashboard = testContextSetUp.pom.getDashBDashboard();
		dashboard.clickCourses();
		dashboard.clickCategory();
	}
	
	@When("I enter course page")
	public void i_enter_course_page() {
		dashboard = testContextSetUp.pom.getDashBDashboard();
		dashboard.clickCourses();
		dashboard.clickCourseList();
	}
	
	@When("I enter user page")
	public void i_enter_user_page() {
		dashboard = testContextSetUp.pom.getDashBDashboard();
		dashboard.clickUsers();
	}
	
	@And("logout of skillrary")
	public void logout_of_skillrary() {
		dashboard.signOutOfApp();
	}
}
