package com.blablacar.mower.processor.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/MowerActionsProcessor.feature")
public class MowerActionsProcessorTestRunner {

}
