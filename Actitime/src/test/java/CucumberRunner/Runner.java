package CucumberRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
			glue= {"com.Accenture.Actitime.Tasks"},
			features= {"src/test/java/FeatureFiles"},
			tags= {"@createcustomer"}
		)
public class Runner {

}
