package org.eugens21.brizy.io.web.interactions.element.frame;

import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.interactions.element.Button;
import org.eugens21.brizy.io.web.interactions.element.Div;
import org.eugens21.brizy.io.web.interactions.element.frame.container.PageElement;
import org.eugens21.brizy.io.web.interactions.enums.ElementPositions;
import org.eugens21.brizy.io.web.interactions.properties.editor.EditorFrameProperties;
import org.eugens21.brizy.io.web.interactions.properties.editor.EditorWorkspaceContainerProperties;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class EditorContainer {

    Frame frame;
    Supplier<Button> addButton;
    Supplier<List<Locator>> elements;
    Supplier<PageElement> emptyContainer;

    public EditorContainer(EditorFrameProperties properties, Page page) {
        EditorWorkspaceContainerProperties container = properties.getWorkspace().getContainer();
        this.frame = page.frame(properties.getName());
        this.addButton = () -> new Button(frame.locator(properties.getAddButton()));
        this.elements = () -> frame.locator(container.getSelf().concat(container.getItem())).all();
        this.emptyContainer = () -> {
            frame.hover(container.getSelf());
            return new PageElement(frame.locator(container.getSelf()));
        };
    }

    public List<PageElement> getElements() {
        return elements.get().stream()
                .map(PageElement::new)
                .collect(Collectors.toList());
    }

    public void createNewPage() {
        addButton.get().click();
    }

    public PageElement addElement(Div element, PageElement parent, ElementPositions position) {
        if (Objects.isNull(parent)) {
            parent = emptyContainer.get();
        }
        parent.moveElementToPosition(element, position);
        return getLatestAddedElement();
    }

    private PageElement getLatestAddedElement() {
        return getElements().get(elements.get().size() - 1);
    }

}
