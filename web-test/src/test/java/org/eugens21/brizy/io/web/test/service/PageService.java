package org.eugens21.brizy.io.web.test.service;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import io.cucumber.spring.ScenarioScope;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.service.WebDriverService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(makeFinal = true,level = PRIVATE)
@RequiredArgsConstructor
@ScenarioScope
public class PageService {

    public Page create(BrowserContext browserContext) {
        return browserContext.newPage();
    }

}
