package org.eugens21.brizy.io.web.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features")
public class BrizyTestsRunner extends AbstractTestNGCucumberTests {}
