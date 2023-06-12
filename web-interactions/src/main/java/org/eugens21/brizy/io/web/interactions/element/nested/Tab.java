package org.eugens21.brizy.io.web.interactions.element.nested;

import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.interactions.element.Image;
import org.eugens21.brizy.io.web.interactions.element.Span;
import org.eugens21.brizy.io.web.interactions.properties.editor.pop_up.EditorPopUpMenuHeaderTabProperties;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Tab {

    Supplier<Image> icon;
    Supplier<Span> name;

    public Tab(EditorPopUpMenuHeaderTabProperties tabProperties, Locator locator) {
        this.icon = () -> new Image(locator.locator(tabProperties.getIcon()));
        this.name = () -> new Span(locator.locator(tabProperties.getName()));
    }

    public void select() {
        name.get().click();
    }

    public String name() {
        return name.get().getText();
    }

}
