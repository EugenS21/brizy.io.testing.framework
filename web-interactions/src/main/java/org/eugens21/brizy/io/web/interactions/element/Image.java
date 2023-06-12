package org.eugens21.brizy.io.web.interactions.element;

import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class Image {

    Locator locator;

    public String getSrc() {
        return locator.getAttribute("href");
    }

}
