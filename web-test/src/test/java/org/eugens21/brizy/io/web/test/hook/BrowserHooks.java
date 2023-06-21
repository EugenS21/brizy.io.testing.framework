package org.eugens21.brizy.io.web.test.hook;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.test.service.BrowserService;
import org.eugens21.brizy.io.web.test.storage.Storage;

import static org.eugens21.brizy.io.web.test.enums.StorageKey.BROWSER;
import static org.eugens21.brizy.io.web.test.enums.StorageKey.PLAYWRIGHT;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class BrowserHooks {

    BrowserService browserService;
    Storage storage;

    @Before(order = -80)
    public void initBrowser() {
        Playwright playwright = storage.getValue(PLAYWRIGHT, Playwright.class);
        Browser browser = browserService.create(playwright);
        storage.addValue(BROWSER, browser);
    }

    @After(order = 70)
    public void closeBrowser() {
        Browser browser = storage.getValue(BROWSER, Browser.class);
        browser.close();
    }

}
