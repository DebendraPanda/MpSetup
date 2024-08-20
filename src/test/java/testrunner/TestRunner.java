package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "Features",
    glue = {"stepdefinations", "AppHooks"},
    plugin = {
        "pretty", 
        "html:target/cucumber-reports.html", 
        "json:target/cucumber-reports/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    }
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
