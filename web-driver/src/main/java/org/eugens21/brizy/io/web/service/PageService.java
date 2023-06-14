package org.eugens21.brizy.io.web.service;


import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.property.WebDriverProperties;

import java.util.Objects;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
class PageService {

    Page page;

    protected Page createNewPage(BrowserContext context) {
        return context.newPage();
    }

    protected void reload() {
        page.reload();
    }

    protected void close() {
        page.close();
    }

}