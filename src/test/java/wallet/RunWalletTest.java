package wallet;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        plugin = {
                "pretty",
                "html:target/reports/cucumber/html",
                "json:target/cucumber.json",
                "usage:target/usage.jsonx",
                "junit:target/junit.xml"
        })
public class RunWalletTest {
}
