package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


	
	@RunWith(Cucumber.class)
	@CucumberOptions(
			
			features="@target/failed_scenarios.txt",
			glue={"StepDefinition","Hooks"},
			plugin= {"pretty",
					"html:target/rerun-reports/rerun.html"}
			
			)
	
	public class TestReRunner {
		
	}

