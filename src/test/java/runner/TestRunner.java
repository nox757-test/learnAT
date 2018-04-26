package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features"},
            glue = "stepDefenition",
            tags = {"@11111, @11112"},
            plugin = {"html:target/cucumber-html-report",
            "json:target/cucumber.json",
            "pretty:target/cucumber-pretty.txt",
            "usage:target/cucumber-usage.json",
            "junit:target/cucumber-results.xml"})
public class TestRunner {
}
