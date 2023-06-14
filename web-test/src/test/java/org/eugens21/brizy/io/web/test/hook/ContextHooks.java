package org.eugens21.brizy.io.web.test.hook;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.spring.ScenarioScope;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.test.service.ContextService;
import org.eugens21.brizy.io.web.test.storage.Storage;

import static org.eugens21.brizy.io.web.test.enums.StorageKey.BROWSER;
import static org.eugens21.brizy.io.web.test.enums.StorageKey.CONTEXT;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ContextHooks {

    ContextService contextService;
    Storage storage;

    @Before(order = -70000)
    public void initContext() {
        Browser browser = storage.getValue(BROWSER, Browser.class);
        BrowserContext context = contextService.create(browser);
        storage.addValue(CONTEXT, context);
    }

    @After(order = 80000)
    public void closeContext() {
        BrowserContext context = storage.getValue(CONTEXT, BrowserContext.class);
        context.close();
    }
    
}
