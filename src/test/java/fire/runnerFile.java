package fire;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
    features = "src/test/resources",  // Path to feature files
    glue = "fire",  // Path to step definition package
    plugin = {"pretty", "html:target/cucumber-reports"},
    monochrome = true,
    tags = "@G1"
)
public class runnerFile extends AbstractTestNGCucumberTests {
}