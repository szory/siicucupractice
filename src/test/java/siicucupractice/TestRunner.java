package siicucupractice;

//import io.cucumber.junit.Cucumber;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
//import io.cucumber.junit.CucumberOptions;
//import org.junit.runner.RunWith;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("siicucupractice")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value= "html:target/site/cucumber-pretty")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value= "json:target/cucumber/cucumber.json")
public class TestRunner {
}
