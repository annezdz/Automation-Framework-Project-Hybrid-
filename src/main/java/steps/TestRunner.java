package steps;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/features/login.feature"},
        monochrome = true
        ,glue =  {"steps"},
        plugin = {"pretty","html:target/HTMLReports/HtmlReports.html", "json:target/JSONReports/reportJson.json",
                "junit:target/JUNITReports/JUNITReports.xml"},
        tags = "@smokeTest"
)
public class TestRunner {
}
