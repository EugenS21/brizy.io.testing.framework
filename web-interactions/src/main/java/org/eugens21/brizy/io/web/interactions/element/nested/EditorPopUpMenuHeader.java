package org.eugens21.brizy.io.web.interactions.element.nested;

import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.interactions.element.TextInput;
import org.eugens21.brizy.io.web.interactions.exception.TabNotFoundException;
import org.eugens21.brizy.io.web.interactions.properties.editor.pop_up.EditorPopUpMenuHeaderProperties;
import org.eugens21.brizy.io.web.interactions.properties.editor.pop_up.EditorPopUpMenuHeaderTabsProperties;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EditorPopUpMenuHeader {

    Supplier<List<Tab>> headerTabs;
    Supplier<TextInput> search;

    public EditorPopUpMenuHeader(EditorPopUpMenuHeaderProperties headerProperties, Page page) {
        this.headerTabs = () -> initTabs(headerProperties.getTabs(), page);
        this.search = () -> new TextInput(page.locator(headerProperties.getSearch()));
    }

    private List<Tab> initTabs(EditorPopUpMenuHeaderTabsProperties tabs, Page page) {
        return page.locator(tabs.getSelf()).all().stream()
                .map(el->new Tab(tabs.getTab(), el))
                .collect(Collectors.toList());
    }

    public Tab getTab(String tab) {
        return  headerTabs.get().stream()
                .filter(el->el.name().equals(tab))
                .findFirst()
                .orElseThrow(() -> new TabNotFoundException(String.format("Unable to find tab with name %s", tab)));
    }

}
