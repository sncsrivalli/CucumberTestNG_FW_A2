package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
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
	
	@AfterStep
	public void afterStep(Scenario scenario) {
		if(scenario.isFailed()) {
			File screenshot = testContextSetUp.driverUtil.getScreenshot(scenario.getName());
			byte[] byteArray = null;
			try {
				byteArray = FileUtils.readFileToByteArray(screenshot);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			scenario.attach(byteArray, "image/png", "failed-test");
		}
	}
	
	@After
	public void afterScenario() {
		testContextSetUp.driverUtil.quitAllWindows();
	}
}
