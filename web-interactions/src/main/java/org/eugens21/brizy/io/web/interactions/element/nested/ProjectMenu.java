package org.eugens21.brizy.io.web.interactions.element.nested;


import com.microsoft.playwright.Locator;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.interactions.element.Button;
import org.eugens21.brizy.io.web.interactions.properties.dashboard.ProjectMenuProperties;

import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class ProjectMenu {

    Supplier<Button> showMore;
    Supplier<Button> delete;

    public ProjectMenu(ProjectMenuProperties menu, Locator locator) {
        this.showMore = () -> new Button(locator.locator(menu.getSelf()));
        this.delete = () -> new Button(locator.locator(menu.getDelete()));
    }

    public MenuOperations open() {
        showMore.get().click();
        return new MenuOperations();
    }

    protected class MenuOperations {

        public void delete() {
            delete.get().click();
        }

    }


}
