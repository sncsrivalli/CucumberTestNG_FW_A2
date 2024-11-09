package stepDefinitions;

import java.util.Map;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepo.AddNewUserPage;
import objectRepo.UsersPage;
import utils.ExcelUtility;
import utils.IConstantPath;
import utils.TestContextSetUp;

public class UsersPageSteps {

	TestContextSetUp testContextSetUp;
	
	public UsersPageSteps(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
	}
	
	ExcelUtility excel;
	UsersPage users;
	AddNewUserPage addUser;
	
	@When("add an user")
	public void add_an_user() {
	    users = testContextSetUp.pom.getUsers();
	    users.clickNew();
	    excel = new ExcelUtility();
	    excel.excelInit(IConstantPath.EXCEL_PATH, "Sheet1");
	    addUser = testContextSetUp.pom.getAddUser();
	    Map<String, String> map = excel.readFromExcel("Add User");
	    excel.closeWorkbook();
	    
	    addUser.setEmail(map.get("Email"));
	    addUser.setPassword(map.get("Password"));
	    addUser.setFirstName(map.get("Firstname"));
	    addUser.setLastName(map.get("Lastname"));
	    addUser.setAddress(map.get("Address"));
	    addUser.setContact(map.get("Contact Info"));
	    addUser.setPhoto(map.get("Photo"));
	    addUser.clickSave();
	}

	@Then("user should be created")
	public void user_should_be_created() {
	    System.out.println(users.getSuccessAlertMessage());
	}
}
