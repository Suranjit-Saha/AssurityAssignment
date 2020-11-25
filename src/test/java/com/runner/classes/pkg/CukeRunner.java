package com.runner.classes.pkg;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty"},
    features = {
        "src/test/resources/features"
    },
    glue = {
            "com/glue/code/pkg"
    }

)
public class CukeRunner {}