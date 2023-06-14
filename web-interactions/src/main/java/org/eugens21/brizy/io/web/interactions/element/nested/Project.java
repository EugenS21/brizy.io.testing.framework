package org.eugens21.brizy.io.web.interactions.element.nested;

import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.interactions.dto.ProjectDto;
import org.eugens21.brizy.io.web.interactions.element.Button;
import org.eugens21.brizy.io.web.interactions.element.Span;
import org.eugens21.brizy.io.web.interactions.element.TextInput;
import org.eugens21.brizy.io.web.interactions.properties.dashboard.ProjectProperties;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Project {

    Supplier<TextInput> title;
    Supplier<Button> publish;
    Supplier<Button> openProject;
    Supplier<Button> editProject;
    Supplier<ProjectMenu> projectMenu;

    public Project(ProjectProperties properties, Locator locator) {
        this.title = () -> new TextInput(locator.locator(properties.getTitle()));
        this.publish = () -> new Button(locator.locator(properties.getPublishProject()));
        this.openProject = () -> new Button(locator.locator(properties.getOpenProject()));
        this.editProject = () -> new Button(locator.locator(properties.getEdit()));
        this.projectMenu = () -> new ProjectMenu(properties.getMenu(), locator);
    }

    public ProjectDto get() {
        return ProjectDto.builder()
                .title(title.get().getText())
                .build();
    }

    public void edit() {
        editProject.get().click();
    }

    public void delete() {
        projectMenu.get().open().delete();
    }

}
