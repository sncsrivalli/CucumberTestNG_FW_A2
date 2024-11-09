package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepo.AddNewCategoryPage;
import objectRepo.CategoryPage;
import utils.TestContextSetUp;

public class CategoryPageSteps {
	
	TestContextSetUp testContextSetUp;
	CategoryPage category;
	AddNewCategoryPage addCategory;
	String newCategoryName;

	public CategoryPageSteps(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
	}

	
	@When("^add a (.*)$")
	public void add_a_category(String categoryName) {
		category = testContextSetUp.pom.getCategory();
		category.clickNew();
		addCategory = testContextSetUp.pom.getAddCategory();

		newCategoryName = categoryName;
		addCategory.setName(categoryName);
		addCategory.clickSave();
	}

	@Then("category should be created")
	public void category_should_be_created() {
		System.out.println(category.getSuccessAlertMessage());
	}

	@When("I delete category")
	public void i_delete_category() {
		category.deleteCourse(testContextSetUp.driverUtil, newCategoryName);
	}

	@Then("category should be removed from category list")
	public void category_should_be_removed_from_category_list() {
		System.out.println(category.getSuccessAlertMessage());
	}
}
