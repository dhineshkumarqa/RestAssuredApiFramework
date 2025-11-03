package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= "src\\test\\java\\Feature\\AddPlace.feature",glue = {"StepDefinition"})
public class Test extends AbstractTestNGCucumberTests {

}
