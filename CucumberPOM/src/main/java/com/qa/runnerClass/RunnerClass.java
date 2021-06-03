package com.qa.runnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:/ECOMM_ONE_CLICK/CucumberPOM/src/main/java/com/qa/feature/flipcart.feature", //where feature file is available
                 glue = { "com/qa/stepDefinitions" },
                 dryRun = false,
                 monochrome = false
               // format = {"pretty","html:test-output"}
               //  strict = true
               //  tags = "@SmokeTest"
                 )

public class RunnerClass {

}