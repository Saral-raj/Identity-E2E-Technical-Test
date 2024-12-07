package identity.testrunners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/CarValuation.feature",
        glue = {"stepDefinitions"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports/cucumber.json"
        },
        monochrome = true,
        tags = "@CarValuationTest"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
