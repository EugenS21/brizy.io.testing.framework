package org.eugens21.brizy.io.web.interactions.element.frame;

import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Page;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.interactions.element.Button;
import org.eugens21.brizy.io.web.interactions.element.nested.EditorWorkspace;
import org.eugens21.brizy.io.web.interactions.properties.editor.EditorFrameProperties;

import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class EditorFrame {

    Frame frame;
    Supplier<Button> addButton;
    EditorWorkspace workspace;


    public EditorFrame(EditorFrameProperties properties, Page page) {
        this.frame = page.frame(properties.getName());
        this.addButton = () -> new Button(frame.locator(properties.getAddButton()));
        this.workspace = new EditorWorkspace(properties.getWorkspace(), frame);
    }

    public void createNewPage() {
        addButton.get().click();
    }

    public EditorWorkspace workspace() {
        return workspace;
    }

}
