package Assignement;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
glue = {"Assignement"},monochrome = true,strict = true//,tags = {"@Functionaltest"}
 )

public class TestRunner extends AbstractTestNGCucumberTests {
}