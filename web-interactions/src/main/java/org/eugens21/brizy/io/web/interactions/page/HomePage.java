package org.eugens21.brizy.io.web.interactions.page;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.interactions.element.Button;
import org.eugens21.brizy.io.web.interactions.properties.HomePageProperties;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class HomePage {

    Supplier<Button> getStarted;

    public HomePage(HomePageProperties homePageProperties, Page page) {
        getStarted = () -> new Button(page.locator(homePageProperties.getGetStarted()));
    }

    public void openDashboard() {
        getStarted.get().click();
    }

}
