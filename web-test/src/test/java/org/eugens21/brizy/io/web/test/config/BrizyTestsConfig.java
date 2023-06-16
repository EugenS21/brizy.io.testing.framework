package org.eugens21.brizy.io.web.test.config;

import io.cucumber.spring.CucumberContextConfiguration;
import jakarta.annotation.PreDestroy;
import org.eugens21.brizy.io.web.WebDriverConfiguration;
import org.eugens21.brizy.io.web.common.WebCommonConfiguration;
import org.eugens21.brizy.io.web.interactions.WebInteractionsConfiguration;
import org.eugens21.brizy.io.web.reporting.WebReportingConfiguration;
import org.eugens21.brizy.io.web.reporting.service.EnvironmentPropertiesWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Path;
import java.util.Map;

@CucumberContextConfiguration
@SpringBootTest(classes = {WebInteractionsConfiguration.class, WebDriverConfiguration.class, WebCommonConfiguration.class, WebReportingConfiguration.class})
public class BrizyTestsConfig {

    @Autowired
    EnvironmentPropertiesWriter environmentPropertiesWriter;

    @PreDestroy
    public void initProperties() {
        environmentPropertiesWriter.writeProperties(Path.of("target/allure-results/environment.properties"), Map.of(
                "Executor", System.getProperty("os.name"),
                "Java", System.getProperty("java.version")
        ));
    }

}
