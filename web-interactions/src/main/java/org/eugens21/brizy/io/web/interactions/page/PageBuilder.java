package org.eugens21.brizy.io.web.interactions.page;

import io.vavr.control.Try;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.interactions.dto.SidebarItemDto;
import org.eugens21.brizy.io.web.interactions.element.Div;
import org.eugens21.brizy.io.web.interactions.element.frame.EditorContainer;
import org.eugens21.brizy.io.web.interactions.element.frame.container.Page;
import org.eugens21.brizy.io.web.interactions.element.frame.container.PageElement;
import org.eugens21.brizy.io.web.interactions.element.nested.EditorSidebar;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PageBuilder {

    EditorContainer container;
    EditorSidebar sidebar;
    @Getter
    Page page;

    public PageBuilder(EditorContainer container, EditorSidebar sidebar) {
        this.container = container;
        this.sidebar = sidebar;
        this.page = new Page();
    }

    public void add(List<SidebarItemDto> elements) {
        elements.forEach(element -> {
            PageElement parentElement = getParentPageElement(element.getParentName());
            Div foundElement = sidebar.fromAddElementsControl().getElement(element.getType());
            PageElement pageElement = container.addElement(foundElement, parentElement, element.getElementPosition());
            page.addElement(element.getElementName(), pageElement);
        });
    }

    private PageElement getParentPageElement(String parentName) {
        return Try.of(() -> page.getElement(parentName))
                .getOrElse(() -> null);
    }

}
