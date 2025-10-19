package ebay.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/ebay/user/pages",       // Path to your feature files
		glue = "ebay.user.steps",                        // Package with your step definitions
		plugin = {
				"pretty",                                   // Console output
				"html:target/cucumber-report.html",         // HTML report
				"json:target/cucumber-report.json"          // JSON report
		},
		monochrome = true                               // Cleaner console output
)
public class TestRunner {
}
