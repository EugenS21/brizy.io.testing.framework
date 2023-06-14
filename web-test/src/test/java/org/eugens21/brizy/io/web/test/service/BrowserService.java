package org.eugens21.brizy.io.web.test.service;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;
import io.cucumber.spring.ScenarioScope;
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
public class BrowserService {

    WebDriverService webDriverService;

    @PreDestroy
    public void close() {
        webDriverService.closeBrowser();
    }

    public Browser create(Playwright playwright) {
        return webDriverService.createBrowser(playwright);
    }

}
