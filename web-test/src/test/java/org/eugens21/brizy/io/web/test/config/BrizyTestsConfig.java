package org.eugens21.brizy.io.web.test.config;

import io.cucumber.spring.CucumberContextConfiguration;
import org.eugens21.brizy.io.web.WebDriverConfiguration;
import org.eugens21.brizy.io.web.common.WebCommonConfiguration;
import org.eugens21.brizy.io.web.interactions.WebInteractionsConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = {WebInteractionsConfiguration.class, WebDriverConfiguration.class, WebCommonConfiguration.class})
public class BrizyTestsConfig {}
