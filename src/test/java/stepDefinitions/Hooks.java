package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.TestContextSetUp;

public class Hooks {

	TestContextSetUp testContextSetUp;
	
	public Hooks(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
	}
	
	@Before
	public void beforeScenario() {
		testContextSetUp.driverUtil.maximizeBrowser();
		long time = Long.parseLong(testContextSetUp.property.readFromFile("timeouts"));
		testContextSetUp.driverUtil.waitTillElementFound(time);
	}
	
	@After
	public void afterScenario() {
		testContextSetUp.driverUtil.quitAllWindows();
	}
}
