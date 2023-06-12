package org.eugens21.brizy.io.web.test.hook;

import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
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

    @Before(order = 1)
    public void doPageInit() {
        Page page = pageService.create();
        storage.addValue(StorageKey.PAGE, page);
    }

    @After(order = 10)
    public void doClosePage() {
        Page page = storage.getValue(StorageKey.PAGE, Page.class);
        page.close();
    }

}
