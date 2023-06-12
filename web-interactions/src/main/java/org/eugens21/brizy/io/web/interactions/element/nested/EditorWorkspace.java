package org.eugens21.brizy.io.web.interactions.element.nested;

import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.interactions.properties.editor.EditorWorkspaceProperties;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EditorWorkspace {

    Container container;

    public EditorWorkspace(EditorWorkspaceProperties workspaceProperties, Frame frame) {
        this.container = new Container(workspaceProperties.getContainer(), frame);
    }

    public void container() {

    }

}
