package org.eugens21.brizy.io.web.interactions.element;

import com.microsoft.playwright.Locator;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class Span {

    Locator locator;

    public String  getText() {
        return locator.textContent();
    }

    public void click() {
        locator.click();
    }

}