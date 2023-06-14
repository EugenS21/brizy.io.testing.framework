package org.eugens21.brizy.io.web.test.service;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Playwright;
import io.cucumber.spring.ScenarioScope;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.service.WebDriverService;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(makeFinal = true,level = PRIVATE)
@RequiredArgsConstructor
@ScenarioScope
public class ContextService {

    WebDriverService webDriverService;

    @PreDestroy
    public void close() {
        webDriverService.closeContext();
    }

    public BrowserContext create(Browser browser) {
        return webDriverService.createContext(browser);
    }

}
