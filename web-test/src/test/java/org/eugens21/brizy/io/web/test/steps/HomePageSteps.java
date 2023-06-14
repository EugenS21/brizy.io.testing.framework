package org.eugens21.brizy.io.web.test.steps;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.apache.commons.lang3.StringUtils;
import org.eugens21.brizy.io.web.interactions.page.DashboardPage;
import org.eugens21.brizy.io.web.interactions.page.HomePage;
import org.eugens21.brizy.io.web.interactions.properties.HomePageProperties;
import org.eugens21.brizy.io.web.interactions.properties.WebLocatorsProperties;
import org.eugens21.brizy.io.web.test.enums.StorageKey;
import org.eugens21.brizy.io.web.test.storage.Storage;
import org.eugens21.brizy.io.web.test.tools.PageSwitcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Supplier;

import static org.apache.commons.lang3.StringUtils.EMPTY;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class HomePageSteps {

    HomePageProperties locatorsProperties;
    PageSwitcher pageSwitcher;
    Storage storage;

    @Autowired
    public HomePageSteps(WebLocatorsProperties webLocatorsProperties, Storage storage) {
        this.pageSwitcher = new PageSwitcher();
        this.storage = storage;
        this.locatorsProperties = webLocatorsProperties.getHome();
    }

    @When("navigate to home page")
    public void navigateToHomePage() {
        Page page = storage.getValue(StorageKey.PAGE, Page.class);
        page.navigate(EMPTY);
        HomePage homePage = new HomePage(locatorsProperties, page);
        storage.addValue(StorageKey.HOME_PAGE, homePage);
    }

    @When("open dashboard page")
    public void navigateToDashboardPage() {
        HomePage homePage = storage.getValue(StorageKey.HOME_PAGE, HomePage.class);
        Page page = storage.getValue(StorageKey.PAGE, Page.class);
        homePage.openDashboard();
        Page dashboardPage = pageSwitcher.switchFromCurrentPageToSpecificTab(page, 1);
        storage.addValue(StorageKey.DASHBOARD_PAGE, dashboardPage);
    }


}
