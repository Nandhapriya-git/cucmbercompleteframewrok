package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "Features",  // Relative to the project root
	    glue = {"StepDefinition", "Hooks"},
	    plugin = {"pretty", "html:target/CucumberReports/CucumberReport.html",
	    		   "rerun:target/failed_scenarios.txt"},
	    publish = true
	)


public class TestRunner {

}
