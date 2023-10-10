package runner;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {
                "html:target/build/cucumber-html-report.html",
                "pretty:target/build/cucumber-pretty.txt",
                "json:target/build/cucumber.json"
        },
        features = {"src/test/resources/features"},
        stepNotifications = true,
        glue = {""},
        tags = "@API-1"
)
public class RunnerTest {
    @BeforeClass
    public static void beforeExecution() {
    }

    @AfterClass
    public static void afterExecution() {
    }
}
