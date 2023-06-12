package org.eugens21.brizy.io.web.test.config;

import io.cucumber.spring.CucumberContextConfiguration;
import org.eugens21.brizy.io.web.WebDriverConfiguration;
import org.eugens21.brizy.io.web.common.WebCommonConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = {WebDriverConfiguration.class, WebCommonConfiguration.class})
public class BrizyTestsConfig {}
