package org.eugens21.brizy.io.web.interactions.element.nested;

import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.interactions.exception.ProjectNotFoundException;
import org.eugens21.brizy.io.web.interactions.properties.dashboard.ProjectsListProperties;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class ProjectsDashboard {

    Supplier<List<Project>> projects;

    public ProjectsDashboard(ProjectsListProperties projectsListProperties, Page page) {
        this.projects = () -> initProjects(projectsListProperties, page);
    }

    private List<Project> initProjects(ProjectsListProperties projectsListProperties, Page page) {
        return page.locator(projectsListProperties.getSelf().concat(projectsListProperties.getItems())).all().stream()
                .map(locator -> new Project(projectsListProperties.getProject(), locator))
                .collect(Collectors.toList());
    }

    public Project getProject(String title) {
        return projects.get().stream()
                .filter(el->el.get().getTitle().equals(title))
                .findFirst()
                .orElseThrow(() -> new ProjectNotFoundException(String.format("Project with title %s not found", title)));
    }

}
