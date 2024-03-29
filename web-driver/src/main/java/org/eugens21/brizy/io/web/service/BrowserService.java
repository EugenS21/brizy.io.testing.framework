package org.eugens21.brizy.io.web.service;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Playwright;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

import java.util.Objects;

import static lombok.AccessLevel.PROTECTED;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
class BrowserService {

    org.eugens21.brizy.io.web.enums.BrowserType type;
    LaunchOptions launchOptions;
    @Getter(value = PROTECTED)
    @NonFinal
    Browser browser;

    protected BrowserService(org.eugens21.brizy.io.web.enums.BrowserType type, LaunchOptions launchOptions) {
        this.launchOptions = launchOptions;
        this.type = type;
    }

    protected Browser launch(Playwright playwright) {
        return type.getBrowserType(playwright).launch(launchOptions);
    }

    protected void close() {
        if(Objects.nonNull(browser)) {
            browser.close();
        }
    }


}
