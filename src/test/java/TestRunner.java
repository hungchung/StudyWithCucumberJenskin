import org.junit.runner.RunWith;

import support.datas.Constant;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Here runner total for all scenario, user run with replace or add tags of
 * scenario
 * 
 * @author hung.cp
 * 
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = { 
		"pretty", "html:target/cucumber","json:target/cucumber.json" }, 
		features = "src/test/resources", 
		glue = {"checkout"},
		tags = { "@checkout" }
)
public class TestRunner {
	
}
