package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,features="src/test/resources/Features/E2E.feature",
glue= {"StepDefination"},
plugin = {"json:target/cucumber.json"})

public class TestRunner {
	
	

}
