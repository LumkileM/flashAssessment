import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/featureFiles"},
//        tags = "@web",
        glue = {"stepDefinitions"},

        plugin = {"pretty", "html:target/cucumber.html"})

public class WebTestRunner {
}