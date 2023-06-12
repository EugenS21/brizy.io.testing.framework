package org.eugens21.brizy.io.web.service;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.eugens21.brizy.io.web.property.ContextProperties;
import org.eugens21.brizy.io.web.property.WebDriverProperties;

import java.util.Objects;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@FieldDefaults(makeFinal = true, level = PRIVATE)
class BrowserContextService {

    @Getter(value = PROTECTED)
    @NonFinal
    BrowserContext context;
    NewContextOptions contextProperties;

    protected BrowserContextService(NewContextOptions contextProperties) {
        this.contextProperties = contextProperties;
    }

    protected BrowserContext newContext(Browser browser) {
        if (Objects.isNull(context)) {
            this.context = browser.newContext(contextProperties);
        }
        return context;
    }

    protected void close() {
        if (Objects.nonNull(context)) {
            context.close();
        }
    }

}
