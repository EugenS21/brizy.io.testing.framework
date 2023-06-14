package org.eugens21.brizy.io.web.interactions.element.nested;

import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.interactions.properties.editor.EditorWorkspaceContainerProperties;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Container {

    Locator locator;

    public Container(EditorWorkspaceContainerProperties container, Frame frame) {
        this.locator = frame.locator(container.getSelf());
    }

}
