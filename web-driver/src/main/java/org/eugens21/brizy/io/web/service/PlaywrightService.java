package org.eugens21.brizy.io.web.service;

import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Playwright.CreateOptions;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

import static java.util.Objects.isNull;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@NoArgsConstructor(access = PROTECTED)
@FieldDefaults(level = PRIVATE)
class PlaywrightService {

    @Getter(value = PROTECTED)
    Playwright playwright;
    CreateOptions createOptions;

    protected PlaywrightService(CreateOptions createOptions){
        this.createOptions = createOptions;
    }

    protected Playwright create() {
        if (isNull(playwright)) {
            this.playwright = Playwright.create(createOptions);
        }
        return playwright;
    }

    protected void close() {
        playwright.close();
    }

}
