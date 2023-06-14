package org.eugens21.brizy.io.web.interactions.page;

import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.interactions.element.nested.Project;
import org.eugens21.brizy.io.web.interactions.element.nested.ProjectsDashboard;
import org.eugens21.brizy.io.web.interactions.properties.dashboard.DashboardPageProperties;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DashboardPage {

    ProjectsDashboard projectsDashboard;

    public DashboardPage(DashboardPageProperties dashboardPageProperties, Page page) {
        this.projectsDashboard = new ProjectsDashboard(dashboardPageProperties.getProjects(), page);
    }

    public Project getProjectByTitle(String title) {
        return projectsDashboard.getProject(title);
    }

}
