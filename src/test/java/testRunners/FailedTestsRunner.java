package testRunners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "@target/failed_scenarios.txt",
				glue = "stepDefinitions",
				plugin = {"pretty",
						"html:target/HTML/report.html",
						"json:target/JSON/report.json",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class FailedTestsRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}
