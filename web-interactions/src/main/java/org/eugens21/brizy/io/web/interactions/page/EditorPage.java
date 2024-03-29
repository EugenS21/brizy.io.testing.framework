package org.eugens21.brizy.io.web.interactions.page;

import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.interactions.element.frame.EditorContainer;
import org.eugens21.brizy.io.web.interactions.element.nested.EditorPopUpMenu;
import org.eugens21.brizy.io.web.interactions.element.nested.EditorSidebar;
import org.eugens21.brizy.io.web.interactions.properties.editor.EditorPageProperties;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EditorPage {

    EditorPopUpMenu editorPopUpMenu;
    EditorContainer container;
    Page page;
    PageBuilder pageBuilder;

    public EditorPage(EditorPageProperties editorPageProperties, Page page) {
        this.editorPopUpMenu = new EditorPopUpMenu(editorPageProperties.getEditorPopUp(), page);
        this.container = new EditorContainer(editorPageProperties.getFrame(), page);
        EditorSidebar sidebar = new EditorSidebar(editorPageProperties.getSidebar(), page);
        this.page = page;
        this.pageBuilder = new PageBuilder(container, sidebar);
    }

    public void createNewPage() {
        page.waitForLoadState();
        container.createNewPage();
    }

    public EditorPopUpMenu popUpMenu() {
        return editorPopUpMenu;
    }

    public PageBuilder editPage() {
        return pageBuilder;
    }

    public byte[] takeScreenshot() {
        return page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
    }

}
