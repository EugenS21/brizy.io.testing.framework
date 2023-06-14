package org.eugens21.brizy.io.web.test.steps;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.When;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.interactions.element.nested.Project;
import org.eugens21.brizy.io.web.interactions.page.DashboardPage;
import org.eugens21.brizy.io.web.interactions.properties.WebLocatorsProperties;
import org.eugens21.brizy.io.web.interactions.properties.dashboard.DashboardPageProperties;
import org.eugens21.brizy.io.web.test.enums.StorageKey;
import org.eugens21.brizy.io.web.test.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DashboardPageSteps {

    DashboardPageProperties dashboardPageProperties;
    Storage storage;

    @Autowired
    public DashboardPageSteps(WebLocatorsProperties webLocatorsProperties, Storage storage) {
        this.dashboardPageProperties = webLocatorsProperties.getDashboard();
        this.storage = storage;
    }

    @When("^select '(.*)' from projects list$")
    public void selectProjectFromProjectsList(String projectName) {
        Page page = storage.getValue(StorageKey.DASHBOARD_PAGE, Page.class);
        DashboardPage dashboardPage = new DashboardPage(dashboardPageProperties, page);
        Project projectByTitle = dashboardPage.getProjectByTitle(projectName);
        projectByTitle.edit();
    }
}
