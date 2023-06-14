package org.eugens21.brizy.io.web.test.hook;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.spring.ScenarioScope;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.test.enums.StorageKey;
import org.eugens21.brizy.io.web.test.service.PageService;
import org.eugens21.brizy.io.web.test.storage.Storage;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class PageHooks {

    PageService pageService;
    Storage storage;

    @Before(order = -60000)
    public void doPageInit() {
        BrowserContext context = storage.getValue(StorageKey.CONTEXT, BrowserContext.class);
        Page page = pageService.create(context);
        storage.addValue(StorageKey.PAGE, page);
    }

    @After(order = 90000)
    public void doClosePage() {
        Page page = storage.getValue(StorageKey.PAGE, Page.class);
        page.close();
    }

}
