package org.eugens21.brizy.io.web.test.hook;

import com.microsoft.playwright.Playwright;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.spring.ScenarioScope;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.test.enums.StorageKey;
import org.eugens21.brizy.io.web.test.service.PlaywrightService;
import org.eugens21.brizy.io.web.test.storage.Storage;

import static org.eugens21.brizy.io.web.test.enums.StorageKey.PLAYWRIGHT;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class PlaywrightHooks {

    PlaywrightService playwrightService;
    Storage storage;

    @Before(order = -90000)
    public void initPlaywright() {
        Playwright playwright = playwrightService.create();
        storage.addValue(PLAYWRIGHT, playwright);
    }

    @After(order = 60000)
    public void closePlaywright() {
        Playwright playwright = storage.getValue(PLAYWRIGHT, Playwright.class);
        playwright.close();
    }

}
