package org.eugens21.brizy.io.web.interactions.element.nested;

import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.interactions.element.Button;
import org.eugens21.brizy.io.web.interactions.properties.editor.pop_up.EditorPopUpMenuBodyProperties;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EditorPopUpMenuBody {

    Supplier<Button> createYourOwn;

    public EditorPopUpMenuBody(EditorPopUpMenuBodyProperties properties, Page page) {
        this.createYourOwn = () -> new Button(page.locator(properties.getContent().getCreateYourOwn()));
    }

//    TODO temporary solution, refactor
    public void createYourOwn() {
        createYourOwn.get().click();
    }
}
