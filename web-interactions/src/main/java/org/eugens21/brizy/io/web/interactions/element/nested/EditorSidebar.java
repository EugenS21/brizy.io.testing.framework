package org.eugens21.brizy.io.web.interactions.element.nested;

import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.interactions.element.Button;
import org.eugens21.brizy.io.web.interactions.properties.editor.EditorSidebarProperties;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EditorSidebar {

    Supplier<Button> addItems;
    EditorSidebarContent content;

    public EditorSidebar(EditorSidebarProperties sidebarProperties, Page page) {
        this.addItems = () -> new Button(page.locator(sidebarProperties.getAddItems().getSelf()));
        this.content = new EditorSidebarContent(sidebarProperties.getAddItems().getContent().getMain(), page);
    }

    public EditorSidebarContent add() {
        addItems.get().click();
        return content;
    }

}
