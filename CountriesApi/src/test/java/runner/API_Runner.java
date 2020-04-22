package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features= "features/Countries.feature" //Path of the Features File
        , glue={"stepDefinition"} //Step Definition
        ,plugin={"summary","pretty","html:test_output/cucumber-html-report","json:test_output/cucumber.json",
        "testng:test_output/cucumber.xml","rerun:test_output/rerun.txt" }//To generate different types of report

        //,dryRun=true//To check the mapping between feature file and step definition file
        , strict=true //To check if any step is not defined in the step definition file.
        , monochrome = true //Display the console output in a readable format.

        //, tags={"@Smoke"}
        //, tags={"@E2E"}
        //, tags={"@Reg"}
        //, tags= {"@Smoke”, "@Reg"} Execute ONLY test(s) tagged as @Smoke AND @Reg
        //, tags={"@Smoke,@Reg"} // Execute all tests tagged as @Smoke OR @Reg
        //, tags={"~@Smoke","@Reg"} // Want to Ignore Particular Scenario(s)

)





public class API_Runner extends AbstractTestNGCucumberTests {


}

