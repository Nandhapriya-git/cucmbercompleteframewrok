package TestRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
	    features = "Features",  // Relative to the project root
	    glue = {"StepDefinition", "Hooks"},
	    plugin = {"pretty",  // Console output
	            "html:target/cucumber-reports.html",  // Local Cucumber report
	            "json:target/cucumber.json",          // JSON output (for CI)
	            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
	    		   "rerun:target/failed_scenarios.txt"},
	    publish = true
	)


public class TestRunner  extends AbstractTestNGCucumberTests {

}
