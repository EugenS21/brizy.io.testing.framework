package org.eugens21.brizy.io.web.interactions.page;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.interactions.element.frame.EditorFrame;
import org.eugens21.brizy.io.web.interactions.element.nested.EditorPopUpMenu;
import org.eugens21.brizy.io.web.interactions.element.nested.EditorSidebar;
import org.eugens21.brizy.io.web.interactions.element.nested.EditorWorkspace;
import org.eugens21.brizy.io.web.interactions.properties.editor.EditorPageProperties;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EditorPage {

    EditorPopUpMenu editorPopUpMenu;
    EditorFrame frame;
    EditorSidebar sidebar;
    Page page;

    public EditorPage(EditorPageProperties editorPageProperties, Page page) {
        this.editorPopUpMenu = new EditorPopUpMenu(editorPageProperties.getEditorPopUp(), page);
        this.frame = new EditorFrame(editorPageProperties.getFrame(), page);
        this.sidebar = new EditorSidebar(editorPageProperties.getSidebar(), page);
        this.page = page;
    }

    public void createNewPage() {
        page.waitForLoadState();
        frame.createNewPage();
    }

    public EditorWorkspace workspace() {
        return frame.workspace();
    }

    public EditorPopUpMenu popUpMenu() {
        return editorPopUpMenu;
    }

    public EditorSidebar sidebar() {
        return sidebar;
    }

}
