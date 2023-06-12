package org.eugens21.brizy.io.web.test.service;

import com.microsoft.playwright.Page;
import io.cucumber.spring.ScenarioScope;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.service.WebDriverService;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

@Component
@FieldDefaults(makeFinal = true,level = PRIVATE)
@RequiredArgsConstructor
@ScenarioScope
public class PageService {

    WebDriverService driverService;

    @PostConstruct
    private void init() {
        driverService.init();
    }

    @PreDestroy
    private void close() {
        driverService.close();
    }

    public Page create() {
        return driverService.create();
    }

}
